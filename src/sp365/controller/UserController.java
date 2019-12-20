package sp365.controller;


import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp365.frame.Biz;
import sp365.vo.BoardVO;
import sp365.vo.CartVO;
import sp365.vo.OrderVO;
import sp365.vo.ProductVO;
import sp365.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	@Qualifier("ubiz")
	Biz<String, UserVO> ubiz;
	
	@Resource(name = "cbiz")
	Biz<String, CartVO> cbiz;
	
	@Resource(name = "obiz")
	Biz<String, OrderVO> obiz;
	
	@Resource(name = "pbiz")
	Biz<String, ProductVO> pbiz;
	
	@Resource(name = "bbiz")
	Biz<String, BoardVO> bbiz;
	
	@RequestMapping("/uupdateimpl.sp")
	public ModelAndView updateimpl(ModelAndView mv, HttpServletRequest request, UserVO user) {
		
		try {
			ubiz.modify(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("duser", user);
        mv.addObject("center", "user/mypage");
        mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/uupdate.sp")
	public ModelAndView update(ModelAndView mv,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginid");
		try {
			UserVO user = ubiz.get(id);
			System.out.println(user.toString());
			mv.addObject("duser", user);
			mv.addObject("center", "user/update");
			mv.setViewName("main");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("/umypage.sp")
	public ModelAndView mypage(HttpServletRequest request) {
	      ModelAndView mv = new ModelAndView();
	      HttpSession session = request.getSession();
	      String id = (String) session.getAttribute("loginid");
	      try {
	         UserVO user = ubiz.get(id);
	         System.out.println(user.toString());
	         mv.addObject("duser", user);
	         mv.addObject("center", "user/mypage");
	         mv.setViewName("main");
	      } catch (Exception e) {
	         
	         e.printStackTrace();
	      }
	      return mv;
	}
	
	@RequestMapping("/udelete.sp")
	public ModelAndView delete(HttpServletRequest request, String id) {
		ModelAndView mv = new ModelAndView();
		try {
			ubiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = 
				request.getSession();
		if(session != null) {
			session.invalidate();
		}
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/odetail.sp")
	public ModelAndView odetail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
	      String u_id = (String) session.getAttribute("loginid");   
	      System.out.print(u_id);

		try {			
			
			// 세션으로 부터 u_id를 얻고 , 그다음 orderlist를 얻는다
			ArrayList<OrderVO> orderlist = obiz.getmyorder(u_id);
			System.out.println(orderlist);
			// cart
			ArrayList<CartVO> carts = new ArrayList<CartVO>();
			// u_id가 갖고 있는 o_id를 얻고, 그다음 cartlist를 얻는다(왜냐하면,수량과 사이즈가 여기에 들어 있기 때문에)
			
			
			for(OrderVO o: orderlist) {
				String o_id = o.getO_id();
				try {
					carts.addAll(cbiz.getbyorder(o_id));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		   System.out.println(carts);
		   
		   ArrayList<ProductVO> prod_o_detail_list = new ArrayList<ProductVO>();

			// 그리고 cart로 부터 product에 대한 상품에 정보를 얻는다
			for(CartVO c: carts) {
				String p_id=c.getP_id();				
				try {
					prod_o_detail_list.add(pbiz.get(p_id));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println(prod_o_detail_list);
			
			mv.addObject("cartlist", carts);
			mv.addObject("prod_o_detail_list", prod_o_detail_list);
			mv.addObject("center", "user/orderdetail");

		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}
	
	
	// User 개인 Q&A
	@RequestMapping("/mypage_qna.sp")
	public ModelAndView mypage_qna(ModelAndView mv, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		String u_id = (String) session.getAttribute("loginid");	
		System.out.print(u_id);
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();

		try {
			list = bbiz.mypageget(u_id);
			System.out.println(list.toString());
			mv.addObject("my_blist", list);
			mv.addObject("center", "user/mypage_qna");
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/qna_updateimpl_mypage.sp")
	public String qna_updateimpl_mypage(BoardVO board, HttpServletRequest request) {
		System.out.println("board info received: " + board);
		HttpSession session = request.getSession();
		BoardVO uboard = new BoardVO(board.getB_id(), board.getB_title(), board.getB_writer(), board.getB_content(),
				board.getB_reply(), (String) session.getAttribute("loginid"));
		System.out.println("board info to be sent to db: " + uboard);
		String result = null;
		try {
			bbiz.modify(uboard);
			result = "redirect:mypage_qna.sp";
		} catch (Exception e) {
			result = "redirect:error.sp";
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/qna_deleteimpl_mypage.sp")
	public String qna_deleteimpl_mypage(String b_id) {
		String result = null;
		System.out.println(b_id);
		try {
			bbiz.remove(b_id);
			result = "redirect:mypage_qna.sp";
		} catch (Exception e) {
			result = "redirect:error.sp";
			e.printStackTrace();
		}
		return result;
	}



		
	
	// 전체 QnA
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
	public String qna_addimpl_user(BoardVO board, HttpServletRequest request) {
		HttpSession session = request.getSession();
		board.setU_id((String)session.getAttribute("loginid"));
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
	public String qna_updateimpl_user(BoardVO board, HttpServletRequest request) {
		System.out.println("board info received: " + board);
		HttpSession session = request.getSession();
		BoardVO uboard = new BoardVO(board.getB_id(), board.getB_title(), board.getB_writer(), board.getB_content(),
				board.getB_reply(), (String) session.getAttribute("loginid"));
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






