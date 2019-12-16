package sp365.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView statistics_mgr(ModelAndView mv) {
		System.out.println("statistics_mgr");
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

	// User Q&A
	@RequestMapping("/qna_user.sp")
	public ModelAndView qna_user(ModelAndView mv, HttpServletRequest request) {
		ArrayList<BoardVO> list = null;
		try {
			list = bbiz.get();
			mv.addObject("blist", list);
			mv.addObject("center", "user/qna_user");
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/qna_addimpl_user.sp")
	public String qna_addimpl_user(BoardVO board) {
		System.out.println(board);
		String result = null;
		try {
			bbiz.register(board);
			result = "redirect:qna_user.sp";
		} catch (Exception e) {
			result = "redirect:error.sp";
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/qna_updateimpl_user.sp")
	public String qna_updateimpl_user(BoardVO board) {
		System.out.println("board info received: " + board);

		BoardVO uboard = new BoardVO(board.getB_id(), board.getB_title(), board.getB_writer(), board.getB_content(),
				board.getB_reply());
		System.out.println("board info to be sent to db: " + uboard);
		String result = null;
		try {
			bbiz.modify(uboard);
			result = "redirect:qna_user.sp";
		} catch (Exception e) {
			result = "redirect:error.sp";
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/qna_deleteimpl_user.sp")
	public String qna_deleteimpl_user(String b_id) {
		String result = null;
		System.out.println(b_id);
		try {
			bbiz.remove(b_id);
			result = "redirect:qna_user.sp";
		} catch (Exception e) {
			result = "redirect:error.sp";
			e.printStackTrace();
		}
		return result;
	}

}
