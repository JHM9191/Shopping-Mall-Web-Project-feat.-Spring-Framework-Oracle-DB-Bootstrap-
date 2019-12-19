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

	// ���߿� ���ο��� cart ���� ����
	@RequestMapping("/checkout.sp")
	public ModelAndView checkout(ModelAndView mv, HttpServletRequest request) {
		System.out.println("this is checkout.sp");
		
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("loginid");

		String subtotal = request.getParameter("subtotal");
		
		if (u_id == null) { // login �ȵǾ� ���� ���. 
			session.invalidate();
			mv.setViewName("user/login");
			return mv;
			
		} else {
			// u_id�� ���� ��ٱ��Ͽ� �ִ� īƮ����Ʈ �ҷ���
			ArrayList<CartVO> cartlist = null;
			try {
				cartlist = cbiz.getmycart(u_id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// ������ ���� īƮ p_id��� ������ �������� ��ƿ� 
			ArrayList<ProductVO> pdlist = new ArrayList<ProductVO>();
			for (CartVO c : cartlist) {
				String product_id = c.getP_id();
				try {
					pdlist.add(pbiz.get(product_id));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//u_id�� ���� user ���� ������
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
		
		if (u_id == null) { // login �ȵǾ� ���� ���. 
			session.invalidate();
			mv.setViewName("user/login");
			return mv;
			
		} else {
			// order ���̺� �ֱ� ���� u_id ��������
			order.setU_id(u_id);
			
			// order db�� �ְ� o_id �޾ƿ���
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
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("YY�� MM�� dd�� HH:mm");
			String date = dateFormat.format(temp.get(0).getO_regdate());
			
			// u_id�� ���� ��ٱ��Ͽ� �ִ� īƮ����Ʈ �ҷ���
			ArrayList<CartVO> cartlist = null;
			try {
				cartlist = cbiz.getmycart(u_id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// ������ ���� īƮ p_id��� ������ �������� ��ƿ� 
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
