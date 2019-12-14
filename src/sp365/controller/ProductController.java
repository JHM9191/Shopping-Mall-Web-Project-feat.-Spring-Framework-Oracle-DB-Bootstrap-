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
			pagemaker.setTotalcount(biz.productcount()); // ��ü ��ǰ ������ �����Ѵ�.
			System.out.println("plist()" + biz.productcount());
			pagemaker.setPagenum(pagenum); // ���� �������� ������ ��ü�� �����Ѵ�.
			pagemaker.setContentnum(contentnum); // �� �������� ��� �Խñ��� �������� �����Ѵ�.
			pagemaker.setCurrentblock(pagenum); // ���� ������ ����� ������� ���� ������ ��ȣ�� ���ؼ� �����Ѵ�.
			pagemaker.setLastblock(pagemaker.getTotalcount()); // ������ ��� ��ȣ�� ��ü �Խñ� ���� ���ؼ� ���Ѵ�.

			pagemaker.prevnext(pagenum); // ���� ������ ��ȣ�� ȭ��ǥ�� ��Ÿ���� ���Ѵ�.
			pagemaker.setStartPage(pagemaker.getCurrentblock()); // ���� �������� ������ ��� ��ȣ�� ���Ѵ�.
			pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock()); // ������ �������� ������ ������ ��ϰ� ���� ������
																							// ��� ��ȣ�� ���Ѵ�.
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
			pagemaker.setTotalcount(biz.productcatcount(p_category)); // ��ü ��ǰ ������ �����Ѵ�.
			System.out.println("plist()" + biz.productcount());
			pagemaker.setPagenum(pagenum); // ���� �������� ������ ��ü�� �����Ѵ�.
			pagemaker.setContentnum(contentnum); // �� �������� ��� �Խñ��� �������� �����Ѵ�.
			pagemaker.setCurrentblock(pagenum); // ���� ������ ����� ������� ���� ������ ��ȣ�� ���ؼ� �����Ѵ�.
			pagemaker.setLastblock(pagemaker.getTotalcount()); // ������ ��� ��ȣ�� ��ü �Խñ� ���� ���ؼ� ���Ѵ�.

			pagemaker.prevnext(pagenum); // ���� ������ ��ȣ�� ȭ��ǥ�� ��Ÿ���� ���Ѵ�.
			pagemaker.setStartPage(pagemaker.getCurrentblock()); // ���� �������� ������ ��� ��ȣ�� ���Ѵ�.
			pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock()); // ������ �������� ������ ������ ��ϰ� ���� ������
																							// ��� ��ȣ�� ���Ѵ�.
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
			pagemaker.setTotalcount(biz.productnewcount()); // ��ü ��ǰ ������ �����Ѵ�.
			System.out.println("plist()" + biz.productnewcount());
			pagemaker.setPagenum(pagenum); // ���� �������� ������ ��ü�� �����Ѵ�.
			pagemaker.setContentnum(contentnum); // �� �������� ��� �Խñ��� �������� �����Ѵ�.
			pagemaker.setCurrentblock(pagenum); // ���� ������ ����� ������� ���� ������ ��ȣ�� ���ؼ� �����Ѵ�.
			pagemaker.setLastblock(pagemaker.getTotalcount()); // ������ ��� ��ȣ�� ��ü �Խñ� ���� ���ؼ� ���Ѵ�.

			pagemaker.prevnext(pagenum); // ���� ������ ��ȣ�� ȭ��ǥ�� ��Ÿ���� ���Ѵ�.
			pagemaker.setStartPage(pagemaker.getCurrentblock()); // ���� �������� ������ ��� ��ȣ�� ���Ѵ�.
			pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock()); // ������ �������� ������ ������ ��ϰ� ���� ������
																							// ��� ��ȣ�� ���Ѵ�.
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

//		/** ���Ƿ� loginid ���� **/
//		HttpSession session = request.getSession();
//		session.setAttribute("loginid", "id01");

		String id = request.getParameter("p_id");
		ProductVO product = null;
		try {
			product = biz.get(id);
			System.out.println("pdetail: " + product.toString());

			if (product.getP_stock() != 0) { // ��� ��Ȳ�� ���� �ٸ��� ǥ��! ++ ��� ���� ���� ���ΰ�?
				mv.addObject("pd_stockstatus", "In Stock");
			} else {
				mv.addObject("pd_stockstatus", "Out of Stock");
			}
//			mv.addObject("pd_id", product.getP_id()); // cart�� id �Ѱ��ֱ� ����
//			mv.addObject("pd_name", product.getP_name());
//			mv.addObject("pd_category", product.getP_category());

			// ���� �������� ���� ��� �߰��ؾ���
//			mv.addObject("pd_price", product.getP_price());
//			mv.addObject("pd_dday", product.getP_delivery_day());
			
			mv.addObject("pd", product);
			
			// main�� �ִ� ${center}�� product/single-product.jsp ����ֱ�. 
			mv.addObject("center", "product/single-product");
			// new�� best �������� �������~~
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
