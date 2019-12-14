package sp365.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		// login�� �ߴٸ�, logingid�� session�� �������̱� ������ session���� loginid�� �����������. 	
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("loginid");
		System.out.println(u_id);
		if (u_id == null) { // login �ȵǾ� ���� ���. 
			session.invalidate();
			result = "redirect:login.sp";
		} else { // login �Ǿ� ������ ��ٱ��Ͽ� ��ǰ �ֱ� ��� ����. 
			// form�� �ִ� ������ request�� ��������. 
			String p_id = request.getParameter("p_id");
			System.out.println(p_id);
			int qty = Integer.parseInt(request.getParameter("qty"));
			System.out.println(qty);
			String size = request.getParameter("size");
			System.out.println(size);

			
			ProductVO pd = null; // �ҷ��� ��ǰ ��ü �غ�. 
			CartVO newCart = null; // �߰��� īƮ ��ü �غ�. 
			try {
				pd = pbiz.get(p_id);
				System.out.println("product info: " + pd.toString());
				int price = pd.getP_price();

				// īƮ VO�� �ְ�
				newCart = new CartVO();
				newCart.setC_qty(qty);
				newCart.setC_size(size);
				newCart.setP_id(p_id);
				newCart.setU_id(u_id);
				newCart.setO_id("null"); // ���� ���̱� ������ Order Id�� null�� ���� ����. 
				newCart.setC_price(price * qty);

				// ����!
				cbiz.register(newCart);
				
				// pdetail.sp �� ������ 
				result = "redirect:pdetail.sp?p_id=" + p_id; 
				
				// īƮ�� ���������� �߰��Ǿ����� cartResult�� success ������. 
				System.out.println("cart insert success");
			} catch (Exception e1) {
				result = "redirect:error.sp";
				e1.printStackTrace();
			}
		}
		return result;
	}

	// ���߿� ���ο��� cart ���� ����
	// cart.sp ������ cart.sp?u_id=loginid ���� �� ��� ��!
	@RequestMapping("/cart.sp")
	public ModelAndView cart(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("this is /cart.sp");
//		String u_id = request.getParameter("u_id");
		// Session�� �ִ� loginid �������� ������� ������.
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("loginid");


		// �� u_id�� ��ġ�ϰ� o_id�� 'null'�� �ֵ��� īƮ ����Ʈ�� �޾ƿ�
		ArrayList<CartVO> cartlist = null;
		try {
			cartlist = cbiz.getmycart(u_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int subtotal = 0;
		// īƮ�� ����� �ִ� ������ �������� ��ƿ� + subtotal ���
		ArrayList<ProductVO> pdlist = new ArrayList<ProductVO>();
		for (CartVO c : cartlist) {
			subtotal += c.getC_price();
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
	public String updateCartItem(ModelAndView mv, HttpServletRequest request, @RequestParam int id[],
			@RequestParam int qty[], @RequestParam int price[]) {
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("loginid");


		for (int i = 0; i < id.length; i++) {
			CartVO vo = new CartVO();
			vo.setC_id(id[i]);
			vo.setC_qty(qty[i]);
			vo.setC_price(qty[i] * price[i]);
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

}
