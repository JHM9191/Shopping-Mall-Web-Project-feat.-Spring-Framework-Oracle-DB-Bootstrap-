package sp365.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp365.frame.Biz;
import sp365.page.PageMaker;
import sp365.vo.ProductVO;
import sp365.vo.UserVO;

@Controller
public class ProductController {

	@Resource(name = "pbiz")
	Biz<String, ProductVO> pbiz;

	@Resource(name = "ubiz")
	Biz<String, UserVO> ubiz;

	@RequestMapping("/main.sp")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		try {

			ArrayList<ProductVO> bestlist = pbiz.get_main_new();
			ArrayList<ProductVO> newlist = pbiz.get_main_best();

//			UserVO u = biz_u.get(id);

			mv.addObject("jsp_bestlist", bestlist);
			mv.addObject("jsp_newlist", newlist);
//			mv.addObject("center", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/plist.sp")
	public ModelAndView plist(ModelAndView mv, HttpServletRequest request, PageMaker pagemaker) {
		int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		int contentnum = Integer.parseInt(request.getParameter("contentnum"));
		String menu = request.getParameter("menu");
		String cat = request.getParameter("cat");
		System.out.println(menu + " " + cat);
		ArrayList<ProductVO> plist = null;
		try {
			if (cat.equals("none")) {
				if (menu.equals("All")) {
					System.out.println("All");
					pagemaker.pagination(pagenum, contentnum, pbiz.count_all());
					plist = pbiz.get_all(pagemaker.getStartRow(), pagemaker.getEndRow());
				} else if (menu.equals("New")) {
					System.out.println("New");
					pagemaker.pagination(pagenum, contentnum, pbiz.count_new());
					plist = pbiz.get_new(pagemaker.getStartRow(), pagemaker.getEndRow());
				} else if (menu.equals("Best")) {
					System.out.println("Best");
					pagemaker.pagination(pagenum, contentnum, pbiz.count_best());
					plist = pbiz.get_best(pagemaker.getStartRow(), pagemaker.getEndRow());
				}
			} else {
				if (menu.equals("All")) {
					System.out.println("All>Category");
					pagemaker.pagination(pagenum, contentnum, pbiz.count_all());
					plist = pbiz.get_by_cat(pagemaker.getStartRow(), pagemaker.getEndRow(), cat);
				} else if (menu.equals("New")) {
					System.out.println("All>Category");
					pagemaker.pagination(pagenum, contentnum, pbiz.count_new());
					plist = pbiz.get_new_by_cat(pagemaker.getStartRow(), pagemaker.getEndRow(), cat);
				} else if (menu.equals("Best")) {
					System.out.println("All>Category");
					pagemaker.pagination(pagenum, contentnum, pbiz.count_best());
					plist = pbiz.get_best_by_cat(pagemaker.getStartRow(), pagemaker.getEndRow(), cat);
				}
			}
			for (ProductVO p : plist) {
				System.out.println("plist: " + p.toString());
			}
			mv.addObject("menu", menu);
			mv.addObject("cat", cat);
			mv.addObject("pagenum", pagenum);
			mv.addObject("contentnum", contentnum);
			mv.addObject("page", pagemaker);
			mv.addObject("plist", plist);
			mv.addObject("center", "product/list");
			System.out.println("setViewName");
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/pdetail.sp")
	public ModelAndView pdetail(ModelAndView mv, HttpServletRequest request) {
		System.out.println("pdetail");

//		/** 임의로 loginid 만듦 **/
//		HttpSession session = request.getSession();
//		session.setAttribute("loginid", "id01");

		String id = request.getParameter("p_id");
		ProductVO product = null;
		try {
			product = pbiz.get(id);
			System.out.println("pdetail: " + product.toString());

			if (product.getP_stock() != 0) { // 재고 상황에 따라 다르게 표시! ++ 어떻게 결제 막을 것인가?
				mv.addObject("pd_stockstatus", "In Stock");
			} else {
				mv.addObject("pd_stockstatus", "Out of Stock");
			}
//			mv.addObject("pd_id", product.getP_id()); // cart로 id 넘겨주기 위함
//			mv.addObject("pd_name", product.getP_name());
//			mv.addObject("pd_category", product.getP_category());

			// 할인 가격으로 띄우는 기능 추가해야함
//			mv.addObject("pd_price", product.getP_price());
//			mv.addObject("pd_dday", product.getP_delivery_day());

			mv.addObject("pd", product);

			// main에 있는 ${center}에 product/single-product.jsp 담아주기.
			mv.addObject("center", "product/single-product");
			// new랑 best 아이콘을 띄워볼까~~
			mv.setViewName("main");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("login")
	public void login() {

	}
}
