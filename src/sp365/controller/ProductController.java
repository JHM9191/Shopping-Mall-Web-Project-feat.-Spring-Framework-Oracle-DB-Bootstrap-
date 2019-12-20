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
import sp365.vo.InputVO;
import sp365.vo.ProductVO;
import sp365.vo.UserVO;

@Controller
public class ProductController {

	@Resource(name = "pbiz")
	Biz<String, ProductVO> pbiz;

	@Resource(name = "ubiz")
	Biz<String, UserVO> ubiz;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//페이지 리스트 구현 (pagination)
	@RequestMapping("/plist.sp")
	public ModelAndView plist(ModelAndView mv, HttpServletRequest request, PageMaker pagemaker) {
		int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		int contentnum = Integer.parseInt(request.getParameter("contentnum"));
		String search = request.getParameter("search");
		String menu = request.getParameter("menu");
		String cat = request.getParameter("cat");
		System.out.println(menu + " " + cat);
		System.out.println(search);
		ArrayList<ProductVO> plist = null;

		try {

			int totCount = pbiz.count_all();
			String navi = "전체 상품";

			if (search != null) {
				InputVO input = new InputVO(search);
				pagemaker.pagination(pagenum, contentnum, pbiz.count_search(search));
				plist = pbiz.getsearch(pagemaker.getStartRow(), pagemaker.getEndRow(), search);
				totCount = pbiz.count_search(search);
				mv.addObject("search", search);
				System.out.println(plist);
				navi = search + "(으)로 검색된 상품";
			} else {
				if (cat.equals("none")) {
					if (menu.equals("All")) {
						System.out.println("All");
						pagemaker.pagination(pagenum, contentnum, pbiz.count_all());
						plist = pbiz.get_all(pagemaker.getStartRow(), pagemaker.getEndRow());
						totCount = pbiz.count_all();
					} else if (menu.equals("New")) {
						System.out.println("New");
						pagemaker.pagination(pagenum, contentnum, pbiz.count_new());
						plist = pbiz.get_new(pagemaker.getStartRow(), pagemaker.getEndRow());
						totCount = pbiz.count_new();
						navi = "New Arrival";
					} else if (menu.equals("Best")) {
						System.out.println("Best");
						pagemaker.pagination(pagenum, contentnum, pbiz.count_best());
						plist = pbiz.get_best(pagemaker.getStartRow(), pagemaker.getEndRow());
						totCount = pbiz.count_best();
						navi = "★☆인기 상품☆★";
					}
				} else {
					if (menu.equals("All")) {
						System.out.println("All>Category");
						pagemaker.pagination(pagenum, contentnum, pbiz.count_by_cat(cat));
						plist = pbiz.get_by_cat(pagemaker.getStartRow(), pagemaker.getEndRow(), cat);
						totCount = pbiz.count_by_cat(cat);
						navi = "전체 상품 > " + cat;
					} else if (menu.equals("New")) {
						System.out.println("New>Category");
						pagemaker.pagination(pagenum, contentnum, pbiz.count_new_by_cat(cat));
						plist = pbiz.get_new_by_cat(pagemaker.getStartRow(), pagemaker.getEndRow(), cat);
						totCount = pbiz.count_new_by_cat(cat);
						navi = "New Arrival > " + cat;
					} else if (menu.equals("Best")) {
						System.out.println("Best>Category");
						pagemaker.pagination(pagenum, contentnum, pbiz.count_best_by_cat(cat));
						plist = pbiz.get_best_by_cat(pagemaker.getStartRow(), pagemaker.getEndRow(), cat);
						totCount = pbiz.count_best_by_cat(cat);
						navi = "★☆인기 상품☆★ > " + cat;
					}
				}
			}

			for (ProductVO p : plist) {
				System.out.println("plist: " + p.toString());
			}

			mv.addObject("navi", navi);
			mv.addObject("totCount", totCount);
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
	//상품 상세페이지 구현
	@RequestMapping("/pdetail.sp")
	public ModelAndView pdetail(ModelAndView mv, HttpServletRequest request) {

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
}
