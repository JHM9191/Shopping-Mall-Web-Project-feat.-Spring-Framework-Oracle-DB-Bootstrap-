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
	Biz<String, ProductVO> biz;

	@Resource(name = "ubiz")
	Biz<String, UserVO> biz_u;

	@RequestMapping("/main.sp")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		try {

			ArrayList<ProductVO> bestlist = biz.getbest();
			ArrayList<ProductVO> newlist = biz.getnew();

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

//	@RequestMapping("/plist.sp")
//	public ModelAndView plist(ModelAndView mv) {
//		System.out.println("plist");
//		ArrayList<ProductVO> plist = null;
//		try {
//			plist = biz.get();
//			mv.addObject("plist", plist);
//			mv.setViewName("product/list");
//			System.out.println("setViewName");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return mv;
//	}

	@RequestMapping("/plist.sp")
	public ModelAndView plist(ModelAndView mv, HttpServletRequest request, PageMaker pagemaker) {
		int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		System.out.println("plist()" + pagenum);
		int contentnum = Integer.parseInt(request.getParameter("contentnum"));
		System.out.println("plist()" + contentnum);
		try {
			pagemaker.setTotalcount(biz.productcount()); // 전체 상품 개수를 지정한다.
			System.out.println("plist()" + biz.productcount());
			pagemaker.setPagenum(pagenum); // 현재 페이지를 페이지 객체에 지정한다.
			pagemaker.setContentnum(contentnum); // 한 페이지에 몇개씩 게시글을 보여줄지 지정한다.
			pagemaker.setCurrentblock(pagenum); // 현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
			pagemaker.setLastblock(pagemaker.getTotalcount()); // 마지막 블록 번호를 전체 게시글 수를 통해서 정한다.

			pagemaker.prevnext(pagenum); // 현제 페이지 번호로 화살표를 나타낼지 정한다.
			pagemaker.setStartPage(pagemaker.getCurrentblock()); // 시작 페이지를 페이지 블록 번호로 정한다.
			pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock()); // 마지막 페이지를 마지막 페이지 블록과 현재 페이지
																							// 블록 번호로 정한다.
			pagemaker.setStartRow(pagenum);
			pagemaker.setEndRow(pagenum);
			List<ProductVO> plist = new ArrayList<ProductVO>();
			plist = biz.productList(pagemaker.getStartRow(), pagemaker.getEndRow());
			for (ProductVO p : plist) {
				System.out.println("plist()" + p.toString());
			}
			mv.addObject("plist", plist);
			mv.addObject("page", pagemaker);
			mv.addObject("center", "product/list");
			mv.setViewName("main");
			System.out.println("setViewName");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("/plistcat.sp")
	public ModelAndView plistcat(ModelAndView mv, HttpServletRequest request, PageMaker pagemaker) {
		int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		System.out.println("plist()" + pagenum);
		int contentnum = Integer.parseInt(request.getParameter("contentnum"));
		System.out.println("plist()" + contentnum);
		String p_category = request.getParameter("cat");
		System.out.println(p_category);
		try {
			pagemaker.setTotalcount(biz.productcatcount(p_category)); // 전체 상품 개수를 지정한다.
			System.out.println("plist()" + biz.productcount());
			pagemaker.setPagenum(pagenum); // 현재 페이지를 페이지 객체에 지정한다.
			pagemaker.setContentnum(contentnum); // 한 페이지에 몇개씩 게시글을 보여줄지 지정한다.
			pagemaker.setCurrentblock(pagenum); // 현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
			pagemaker.setLastblock(pagemaker.getTotalcount()); // 마지막 블록 번호를 전체 게시글 수를 통해서 정한다.

			pagemaker.prevnext(pagenum); // 현제 페이지 번호로 화살표를 나타낼지 정한다.
			pagemaker.setStartPage(pagemaker.getCurrentblock()); // 시작 페이지를 페이지 블록 번호로 정한다.
			pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock()); // 마지막 페이지를 마지막 페이지 블록과 현재 페이지
																							// 블록 번호로 정한다.
			pagemaker.setStartRow(pagenum);
			pagemaker.setEndRow(pagenum);
			List<ProductVO> plist = new ArrayList<ProductVO>();
			plist = biz.productcatList(pagemaker.getStartRow(), pagemaker.getEndRow(), p_category);
			for (ProductVO p : plist) {
				System.out.println("plist()" + p.toString());
			}
			mv.addObject("plist", plist);
			mv.addObject("page", pagemaker);
			mv.addObject("pcate", p_category);
			mv.addObject("center", "product/list");
			mv.setViewName("main");
			System.out.println("setViewName");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("/plistnew.sp")
	public ModelAndView plistnew(ModelAndView mv, HttpServletRequest request, PageMaker pagemaker) {
		int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		System.out.println("plistnew()" + pagenum);
		int contentnum = Integer.parseInt(request.getParameter("contentnum"));
		System.out.println("plistnew()" + contentnum);
		try {
			pagemaker.setTotalcount(biz.productnewcount()); // 전체 상품 개수를 지정한다.
			System.out.println("plist()" + biz.productnewcount());
			pagemaker.setPagenum(pagenum); // 현재 페이지를 페이지 객체에 지정한다.
			pagemaker.setContentnum(contentnum); // 한 페이지에 몇개씩 게시글을 보여줄지 지정한다.
			pagemaker.setCurrentblock(pagenum); // 현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
			pagemaker.setLastblock(pagemaker.getTotalcount()); // 마지막 블록 번호를 전체 게시글 수를 통해서 정한다.

			pagemaker.prevnext(pagenum); // 현제 페이지 번호로 화살표를 나타낼지 정한다.
			pagemaker.setStartPage(pagemaker.getCurrentblock()); // 시작 페이지를 페이지 블록 번호로 정한다.
			pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock()); // 마지막 페이지를 마지막 페이지 블록과 현재 페이지
																							// 블록 번호로 정한다.
			pagemaker.setStartRow(pagenum);
			pagemaker.setEndRow(pagenum);
			List<ProductVO> plist = new ArrayList<ProductVO>();
			plist = biz.productnewList(pagemaker.getStartRow(), pagemaker.getEndRow());
			for (ProductVO p : plist) {
				System.out.println("plist()" + p.toString());
			}
			mv.addObject("plist", plist);
			mv.addObject("page", pagemaker);
			mv.addObject("center", "product/list");
			System.out.println("setViewName");
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/pdetail.sp")
	public ModelAndView pdetail(ModelAndView mv, HttpServletRequest request) {
		System.out.println("pdetail");

//		/** 임의로 loginid 만듦 **/
//		HttpSession session = request.getSession();
//		session.setAttribute("loginid", "id01");

		String id = request.getParameter("p_id");
		ProductVO product = null;
		try {
			product = biz.get(id);
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
