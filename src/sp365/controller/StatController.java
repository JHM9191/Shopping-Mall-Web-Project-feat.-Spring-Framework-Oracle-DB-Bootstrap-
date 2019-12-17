package sp365.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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
	public void statpayment(ModelAndView mv, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			ArrayList<StatVO> list = sbiz.getbypayment();
			for (StatVO s : list) {
				System.out.println(s.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}

}
