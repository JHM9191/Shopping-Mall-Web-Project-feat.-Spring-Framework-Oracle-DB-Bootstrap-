package sp365.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp365.frame.Biz;
import sp365.vo.BoardVO;

@Controller
public class ManagerController {

	@Resource(name = "bbiz")
	Biz<String, BoardVO> bbiz;

	@RequestMapping("/main_mgr.sp")
	public ModelAndView main_mgr(ModelAndView mv) {
		ArrayList<BoardVO> list = null;
		int count = 0;
		try {
			list = bbiz.get();
			for (BoardVO dbboard : list) {
				if (dbboard.getB_reply() == null) {
					count++;
				}
			}
			mv.addObject("b_count", count);
			mv.setViewName("manager/main_mgr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	// Manager Q&A
	@RequestMapping("/qna_mgr.sp")
	public ModelAndView qna_mgr(ModelAndView mv) {
		ArrayList<BoardVO> list = null;
		try {
			list = bbiz.get();
			mv.addObject("blist", list);
			mv.addObject("center", "qna_mgr");
			mv.setViewName("manager/main_mgr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/qna_replyimpl_mgr.sp")
	public String qna_replyimpl_mgr(HttpServletRequest request) {
		String result = null;
		String id = request.getParameter("b_id");
		String reply = request.getParameter("b_reply");
		System.out.println(id + " " + reply);
		BoardVO dbboard = null;
		try {
			dbboard = bbiz.get(id);
			dbboard.setB_reply(reply);
			bbiz.modify(dbboard);
			result = "redirect:qna_mgr.sp";
		} catch (Exception e) {
			result = "redirect:error.sp";
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/qna_deleteimpl_mgr.sp")
	public String qna_deleteimpl_mgr(String b_id) {
		String result = null;
		System.out.println(b_id);
		try {
			bbiz.remove(b_id);
			result = "redirect:qna_mgr.sp";
		} catch (Exception e) {
			result = "redirect:error.sp";
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/qna_updatereplyimpl_mgr.sp")
	public String qna_updatereplyimpl_mgr(BoardVO board) {
		String result = null;
		System.out.println(board.toString());
		try {
//			bbiz.remove(b_id);
			result = "redirect:qna_mgr.sp";
		} catch (Exception e) {
			result = "redirect:error.sp";
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/statistics_mgr.sp")
	public ModelAndView statistics_mgr(ModelAndView mv, HttpServletRequest request) {
		String productType = request.getParameter("productType");
		String period = request.getParameter("period");
		String cond = request.getParameter("cond");
		System.out.println("statistics_mgr");
		System.out.println(productType + " " + period + " " + cond);
		mv.addObject("productType", productType);
		mv.addObject("period", period);
		mv.addObject("cond", cond);

		String productType_name = null;
		String period_name = null;
		String cond_name = null;
		if (productType.equals("All")) {
			productType_name = "전체";
		} else if (productType.equals("New")) {
			productType_name = "New Arrival";
		} else if (productType.equals("Best")) {
			productType_name = "Best";
		}

		if (period.equals("total")) {
			period_name = "전체기간";
		} else if (period.equals("1")) {
			period_name = "최근 1년";
		} else if (period.equals("2")) {
			period_name = "최근 2년";
		} else if (period.equals("3")) {
			period_name = "최근 3년";
		}

		if (cond.equals("monthly")) {
			cond_name = "월별";
		} else if (cond.equals("yearly")) {
			cond_name = "년별";
		} else if (cond.equals("daily")) {
			cond_name = "일별";
		}

		mv.addObject("productType_name", productType_name);
		mv.addObject("period_name", period_name);
		mv.addObject("cond_name", cond_name);
		mv.addObject("center", "statistics_mgr");
		System.out.println("addObject success");
		mv.setViewName("manager/main_mgr");
		return mv;
	}

}
