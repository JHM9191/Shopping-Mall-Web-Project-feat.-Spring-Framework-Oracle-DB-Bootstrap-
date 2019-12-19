package sp365.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
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
	public void statpayment(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		ArrayList<StatVO> statlist = null;
		String productType = request.getParameter("productType");
		String period = request.getParameter("period");
		String cond = request.getParameter("cond");
		System.out.println(productType + " " + period + " " + cond);

//		if (cond.equals("payment")) {
//			System.out.println("payment");
//			statlist = sbiz.getbypayment();
//		} else 

		// 전체 상품
		if (productType.equals("All")) {
			mv.addObject("productType_name", "전체");
			if (period.equals("total")) {
				mv.addObject("period_name", "전체기간");
				if (cond.equals("yearly")) {
					System.out.println("getyearly");
					statlist = sbiz.getyearly();
				} else if (cond.equals("monthly")) {
					statlist = sbiz.getmonthly();
					System.out.println("getmonthly");
				} else if (cond.equals("daily")) {
					statlist = sbiz.getdaily();
					System.out.println("getdaily");
				}
			} else {
				mv.addObject("period_name", "최근" + period + "년");
				int per = Integer.parseInt(period);
				if (cond.equals("yearly")) {
					statlist = sbiz.getyearlyfor(per);
					System.out.println("getyearlyfor");
				} else if (cond.equals("monthly")) {
					statlist = sbiz.getmonthlyfor(per);
					System.out.println("getmonthlyfor");
				} else if (cond.equals("daily")) {
					statlist = sbiz.getdailyfor(per);
					System.out.println("getdailyfor");
				}
			}
		} else if (productType.equals("New")) {// New
			mv.addObject("productType_name", "New Arrival");
			if (period.equals("total")) {
				mv.addObject("period_name", "전체기간");
				if (cond.equals("yearly")) {
					System.out.println("getnewyearly");
					statlist = sbiz.getnewyearly();
				} else if (cond.equals("monthly")) {
					statlist = sbiz.getnewmonthly();
					System.out.println("getnewmonthly");
				} else if (cond.equals("daily")) {
					statlist = sbiz.getnewdaily();
					System.out.println("getnewdaily");
				}
			} else {
				mv.addObject("period_name", "최근" + period + "년");
				int per = Integer.parseInt(period);
				if (cond.equals("yearly")) {
					statlist = sbiz.getnewyearlyfor(per);
					System.out.println("getnewyearlyfor");
				} else if (cond.equals("monthly")) {
					statlist = sbiz.getnewmonthlyfor(per);
					System.out.println("getnewmonthlyfor");
				} else if (cond.equals("daily")) {
					statlist = sbiz.getnewdailyfor(per);
					System.out.println("getnewdailyfor");
				}
			}
		} else if (productType.equals("Best")) {// Best
			mv.addObject("productType_name", "Best");
			if (period.equals("total")) {
				mv.addObject("period_name", "전체기간");
				if (cond.equals("yearly")) {
					System.out.println("getbestyearly");
					statlist = sbiz.getbestyearly();
				} else if (cond.equals("monthly")) {
					statlist = sbiz.getbestmonthly();
					System.out.println("getbestmonthly");
				} else if (cond.equals("daily")) {
					statlist = sbiz.getbestdaily();
					System.out.println("getbestdaily");
				}
			} else {
				mv.addObject("period_name", "최근" + period + "년");
				int per = Integer.parseInt(period);
				if (cond.equals("yearly")) {
					statlist = sbiz.getbestyearlyfor(per);
					System.out.println("getbestyearlyfor");
				} else if (cond.equals("monthly")) {
					statlist = sbiz.getbestmonthlyfor(per);
					System.out.println("getbestmonthlyfor");
				} else if (cond.equals("daily")) {
					statlist = sbiz.getbestdailyfor(per);
					System.out.println("getbestdailyfor");
				}
			}
		}
		try {
			out = response.getWriter();

			JSONArray statarray = new JSONArray();
			for (StatVO s : statlist) {
				ArrayList<Object> list = new ArrayList<Object>();
				list.add(s.getCondition());
				list.add(s.getTotSale());
				statarray.add(list);
			}
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json; charset=UTF-8");
			out.write(statarray.toJSONString());
			mv.addObject("center", "statistics_mgr");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
