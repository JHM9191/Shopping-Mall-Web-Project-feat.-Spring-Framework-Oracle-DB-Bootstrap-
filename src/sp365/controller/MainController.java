package sp365.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sp365.frame.Biz;
import sp365.vo.ProductVO;
import sp365.vo.UserVO;

@Controller
public class MainController {

	@Resource(name = "ubiz")
	Biz<String, UserVO> ubiz;
	
	@Resource(name = "pbiz")
	Biz<String, ProductVO> pbiz;
	
	@RequestMapping("/main.sp")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			ArrayList<ProductVO> bestlist = pbiz.get_main_new();
			ArrayList<ProductVO> newlist = pbiz.get_main_best();
			mv.addObject("jsp_bestlist", bestlist);
			mv.addObject("jsp_newlist", newlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/login.sp")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "user/login");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/logout.sp")
	public String logout(HttpServletRequest request, ModelAndView mv) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return "redirect:main.sp";
	}

	@RequestMapping("/signup.sp")
	public ModelAndView signup(ModelAndView mv) {
		mv.addObject("center", "user/signup");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/signupimpl.sp")
	public String signupimpl(UserVO user) {
		System.out.println(user.toString());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {
			ubiz.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:main.sp";
	}

	@RequestMapping("/loginimpl.sp")
	public ModelAndView loginimpl(HttpServletRequest request, ModelAndView mv) {
		String u_id = request.getParameter("u_id");
		String u_pwd = request.getParameter("u_pwd");

		UserVO dbuser = null;
		try {
			dbuser = ubiz.get(u_id);
			if (dbuser.getU_id() != null) {
				if (dbuser.getU_pwd().equals(u_pwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("loginid", u_id);
					if (dbuser.getU_is_mgr().equals("y")) { // 운영자이면 main_mgr로 이동
						mv.setViewName("redirect:main_mgr.sp");
						return mv;
					}
				} else {
					mv.addObject("loginResult", "Invalid Password");
					mv.addObject("center", "user/login");
				}
			} else {
				mv.addObject("loginResult", "No id");
				mv.addObject("center", "user/login");
			}

		} catch (Exception e) {
			mv.addObject("center", "user/signup");
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}

	//아이디 중복 체크
		@RequestMapping(value = "/idCheck.sp", method = RequestMethod.POST)
			public @ResponseBody String AjaxView(  
				        @RequestParam("u_id") String u_id, String idcheck){
				String str = "";
				try {
					idcheck = ubiz.get(u_id).getU_id();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(idcheck);
				if(idcheck == null){ //이미 존재하는 계정
					str = "YES";	
				}else{	//사용 가능한 계정
					str = "NO";	
				}
				return str;
			}



}
