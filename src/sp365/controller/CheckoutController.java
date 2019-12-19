package sp365.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp365.frame.Biz;
import sp365.vo.CartVO;
import sp365.vo.OrderVO;
import sp365.vo.ProductVO;
import sp365.vo.UserVO;

@Controller
public class CheckoutController {
	
	@Resource(name = "cbiz")
	Biz<String, CartVO> cbiz;

	@Resource(name = "pbiz")
	Biz<String, ProductVO> pbiz;
	
	@Resource(name = "ubiz")
	Biz<String, UserVO> ubiz;
	
	@Resource(name = "obiz")
	Biz<String, OrderVO> obiz;

	// 나중에 메인에서 cart 가는 설정
	@RequestMapping("/checkout.sp")
	public ModelAndView checkout(ModelAndView mv, HttpServletRequest request) {
		System.out.println("this is checkout.sp");
		
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("loginid");

		String subtotal = request.getParameter("subtotal");
		
		if (u_id == null) { // login 안되어 있을 경우. 
			session.invalidate();
			mv.setViewName("user/login");
			return mv;
			
		} else {
			// u_id를 통해 장바구니에 있는 카트리스트 불러옴
			ArrayList<CartVO> cartlist = null;
			try {
				cartlist = cbiz.getmycart(u_id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 위에서 얻은 카트 p_id들로 아이템 정보들을 담아옴 
			ArrayList<ProductVO> pdlist = new ArrayList<ProductVO>();
			for (CartVO c : cartlist) {
				String product_id = c.getP_id();
				try {
					pdlist.add(pbiz.get(product_id));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//u_id를 통해 user 정보 가져옴
			UserVO user = null;
			try {
				user = ubiz.get(u_id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			int qty = cartlist.size();
			
			mv.addObject("f_user", user);
			mv.addObject("f_pdlist", pdlist);
			mv.addObject("f_cartlist", cartlist);
			mv.addObject("total", subtotal);
			mv.addObject("f_qty", qty);
			
			mv.addObject("center", "checkout/checkout");
			mv.setViewName("main");
			System.out.println("checkout.sp success");

		}
		
		return mv;
	}
	
	@RequestMapping("/confirmorder.sp")
	public ModelAndView confirmOrder(ModelAndView mv, HttpServletRequest request, OrderVO order) {
		System.out.println("this is confirmorder.sp");
		
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("loginid");
		
		if (u_id == null) { // login 안되어 있을 경우. 
			session.invalidate();
			mv.setViewName("user/login");
			return mv;
			
		} else {
			// order 테이블에 넣기 위해 u_id 세팅해줌
			order.setU_id(u_id);
			
			// order db에 넣고 o_id 받아오기
			ArrayList<OrderVO> temp = null;
			try {
				obiz.register(order);
				temp = obiz.getmyorder(u_id);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println(temp);
			String o_id = temp.get(0).getO_id();
			
			order.setO_id(o_id);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("YY년 MM월 dd일 HH:mm");
			String date = dateFormat.format(temp.get(0).getO_regdate());
			
			// u_id를 통해 장바구니에 있는 카트리스트 불러옴
			ArrayList<CartVO> cartlist = null;
			try {
				cartlist = cbiz.getmycart(u_id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 위에서 얻은 카트 p_id들로 아이템 정보들을 담아옴 
			ArrayList<ProductVO> pdlist = new ArrayList<ProductVO>();
			for (CartVO c : cartlist) {
				String product_id = c.getP_id();
				try {
					pdlist.add(pbiz.get(product_id));
				} catch (Exception e) {
					e.printStackTrace();
				}
				c.setO_id(o_id);
				try {
					cbiz.setorderid(c);
					System.out.println("set order id success");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
			System.out.println(o_id);
			
			mv.addObject("order_info", order);
			mv.addObject("regdate", date);
			mv.addObject("c_pdlist", pdlist);
			mv.addObject("c_cartlist", cartlist);
			mv.addObject("center", "checkout/confirmation");
			mv.setViewName("main");
		}
		
		return mv;
	
	}
}
