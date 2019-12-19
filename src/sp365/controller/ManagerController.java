package sp365.controller;

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
			productType_name = "��ü";
		} else if (productType.equals("New")) {
			productType_name = "New Arrival";
		} else if (productType.equals("Best")) {
			productType_name = "Best";
		}

		if (period.equals("total")) {
			period_name = "��ü�Ⱓ";
		} else if (period.equals("1")) {
			period_name = "�ֱ� 1��";
		} else if (period.equals("2")) {
			period_name = "�ֱ� 2��";
		} else if (period.equals("3")) {
			period_name = "�ֱ� 3��";
		}

		if (cond.equals("monthly")) {
			cond_name = "����";
		} else if (cond.equals("yearly")) {
			cond_name = "�⺰";
		} else if (cond.equals("daily")) {
			cond_name = "�Ϻ�";
		}

		mv.addObject("productType_name", productType_name);
		mv.addObject("period_name", period_name);
		mv.addObject("cond_name", cond_name);
		mv.addObject("center", "statistics_mgr");
		System.out.println("addObject success");
		mv.setViewName("manager/main_mgr");
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

//	// User Q&A
//	@RequestMapping("/qna_user.sp")
//	public ModelAndView qna_user(ModelAndView mv, HttpServletRequest request) {
//		ArrayList<BoardVO> list = null;
//		try {
//			list = bbiz.get();
//			mv.addObject("blist", list);
//			mv.addObject("center", "user/qna_user");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		mv.setViewName("main");
//		return mv;
//	}
//
//	@RequestMapping("/qna_addimpl_user.sp")
//	public String qna_addimpl_user(BoardVO board, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		board.setU_id((String) session.getAttribute("loginid"));
//		System.out.println(board);
//		String result = null;
//		try {
//			bbiz.register(board);
//			result = "redirect:qna_user.sp";
//		} catch (Exception e) {
//			result = "redirect:error.sp";
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	@RequestMapping("/qna_updateimpl_user.sp")
//	public String qna_updateimpl_user(BoardVO board, HttpServletRequest request) {
//		System.out.println("board info received: " + board);
//		HttpSession session = request.getSession();
//		String result = null;
//		try {
////		BoardVO uboard = new BoardVO(board.getB_id(), board.getB_title(), board.getB_writer(), board.getB_content(),
////				null, (String) session.getAttribute("loginid"));
//			BoardVO uboard = bbiz.get(board.getB_id());
//			uboard.setB_title(board.getB_title());
//			uboard.setB_content(board.getB_title());
//			System.out.println("board info to be sent to db: " + uboard);
//
//			bbiz.modify(uboard);
//			result = "redirect:qna_user.sp";
//		} catch (Exception e) {
//			result = "redirect:error.sp";
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	@RequestMapping("/qna_deleteimpl_user.sp")
//	public String qna_deleteimpl_user(String b_id) {
//		String result = null;
//		System.out.println(b_id);
//		try {
//			bbiz.remove(b_id);
//			result = "redirect:qna_user.sp";
//		} catch (Exception e) {
//			result = "redirect:error.sp";
//			e.printStackTrace();
//		}
//		return result;
//	}

}
