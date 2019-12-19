package sp365.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sp365.frame.Biz;
import sp365.vo.CartVO;
import sp365.vo.ProductVO;

@Controller
public class CartController {
	@Resource(name = "cbiz")
	Biz<String, CartVO> cbiz;

	@Resource(name = "pbiz")
	Biz<String, ProductVO> pbiz;

	@RequestMapping("/addcart.sp")
	public String addcart(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) {
		String result = null;
		
		// login을 했다면, logingid가 session에 있을것이기 때문에 session에서 loginid를 가져와줘야함. 	
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("loginid");
		System.out.println(u_id);
		if (u_id == null) { // login 안되어 있을 경우. 
			session.invalidate();
			result = "redirect:login.sp";
		} else { // login 되어 있을때 장바구니에 상품 넣기 기능 수행. 
			// form에 있는 데이터 request로 가져오기. 
			String p_id = request.getParameter("p_id");
			System.out.println(p_id);
			int qty = Integer.parseInt(request.getParameter("qty"));
			System.out.println(qty);
			String size = request.getParameter("size");
			System.out.println(size);

			
			ProductVO pd = null; // 불러올 상품 객체 준비. 
			CartVO newCart = null; // 추가할 카트 객체 준비. 
			try {
				pd = pbiz.get(p_id);
				System.out.println("product info: " + pd.toString());
				int price = pd.getP_price();

				// 카트 VO에 넣고
				newCart = new CartVO();
				newCart.setC_qty(qty);
				newCart.setC_size(size);
				newCart.setP_id(p_id);
				newCart.setU_id(u_id);
				newCart.setO_id("null"); // 구매 전이기 때문에 Order Id에 null이 들어가는 것임. 
				newCart.setC_sum(price * qty);

				// 전송!
				cbiz.register(newCart);
				
				// pdetail.sp 로 보내기 
				result = "redirect:pdetail.sp?p_id=" + p_id; 
				
				// 카트로 성공적으로 추가되었을때 cartResult에 success 보내기. 
				System.out.println("cart insert success");
			} catch (Exception e1) {
				result = "redirect:error.sp";
				e1.printStackTrace();
			}
		}
		return result;
	}

	// 나중에 메인에서 cart 가는 설정
	@RequestMapping("/cart.sp")
	public ModelAndView cart(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("this is /cart.sp");
		
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("loginid");

		if (u_id == null) { // login 안되어 있을 경우. 
			session.invalidate();
			mv.setViewName("user/login");
			return mv;
			
		} else {
			// 내 u_id에 일치하고 o_id가 'null'인 애들을 카트 리스트에 받아옴
			ArrayList<CartVO> cartlist = null;
			try {
				cartlist = cbiz.getmycart(u_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			int subtotal = 0;
			// 카트에 담아져 있는 아이템 정보들을 담아옴 + subtotal 계산
			ArrayList<ProductVO> pdlist = new ArrayList<ProductVO>();
			for (CartVO c : cartlist) {
				subtotal += c.getC_sum();
				String product_id = c.getP_id();
				try {
					pdlist.add(pbiz.get(product_id));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
			System.out.println(pdlist);
			System.out.println(cartlist);
	
			mv.addObject("subtotal", subtotal);
			mv.addObject("pdlist", pdlist);
			mv.addObject("cartlist", cartlist);
			mv.addObject("center", "cart/cart");
			mv.setViewName("main");
		}
		System.out.println("cart.sp success");

		return mv;
	}

	@RequestMapping("/deletecitem.sp")
	public String deleteCartItem(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) {
		
		String c_id = request.getParameter("c_id");
		
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("loginid");

		try {
			cbiz.remove(c_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("delete cart item success");
		return "redirect:cart.sp?u_id=" + u_id;
	}

	@RequestMapping("/updatecitem.sp")
	public String updateCartItem(ModelAndView mv, HttpServletRequest request, @RequestParam String id[],
			@RequestParam int qty[], @RequestParam int price[]) {
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("loginid");


		for (int i = 0; i < id.length; i++) {
			CartVO vo = new CartVO();
			vo.setC_id(id[i]);
			vo.setC_qty(qty[i]);
			vo.setC_sum(qty[i] * price[i]);
			System.out.println(vo);
			try {
				cbiz.modify(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("update cart item success");
		return "redirect:cart.sp?u_id=" + u_id;
	}

	
	@RequestMapping("/getcartqty.sp")
	@ResponseBody
	public int getCartQty(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("loginid");
		
		if (u_id == null) { // login 안되어 있을 경우. 
			session.invalidate();
			return 0;
		}
		
		ArrayList<CartVO> mycart = null;
		try {
			mycart = cbiz.getmycart(u_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int cartQty = mycart.size();
		return cartQty;
	}
}
