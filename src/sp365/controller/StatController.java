package sp365.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp365.frame.Biz;
import sp365.vo.StatVO;

@Controller
public class StatController {

	@Resource(name = "sbiz")
	Biz<String, StatVO> sbiz;

	@RequestMapping("/statpayment.sp")
	public ModelAndView statpayment(ModelAndView mv, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
//			ArrayList<StatVO> list = sbiz.getbypayment();
//			ArrayList<StatVO> payment = sbiz.getbypayment();
//			ArrayList<StatVO> yearly = sbiz.getyearly();
			ArrayList<StatVO> monthly = sbiz.getmonthly();
//			ArrayList<StatVO> daily = sbiz.getdaily();
//			System.out.println("By payment: " + payment.toString());
//			System.out.println("yearly: " + yearly.toString());
			System.out.println("monthly: " + monthly.toString());
//			System.out.println("daily: " + daily.toString());
			JSONArray ja = new JSONArray();
			for (StatVO s : monthly) {
				JSONObject obj = new JSONObject();
				obj.put("categories", s.getCondition());
				obj.put("series", s.getTotSale());
				ja.add(obj);
			}

			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json; charset=UTF-8");
			out.write(ja.toJSONString());
//			for (StatVO s : list) {
//				System.out.println(s.toString());
//			}

			mv.addObject("StatVO", monthly);
			mv.addObject("center", "statistics_mgr");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		mv.setViewName("main_mgr");
		return mv;
	}

}
