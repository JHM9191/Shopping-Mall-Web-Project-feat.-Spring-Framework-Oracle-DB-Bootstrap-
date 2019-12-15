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

	@RequestMapping("/uu.sp")
	@ResponseBody
	public void uu(HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ArrayList<UserVO> list = null;
		try {
			list = ubiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for (UserVO u : list) {
			JSONObject jo = new JSONObject();
			jo.put("id", u.getU_id());
			jo.put("pwd", u.getU_pwd());
			jo.put("name", u.getU_name());
			ja.add(jo);
		}
		out.print(ja.toJSONString());
		out.close();
	}

	@RequestMapping("/login.sp")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "user/login");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/logout.sp")
	public ModelAndView logout(HttpServletRequest request, ModelAndView mv) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		mv.setViewName("main");
		return mv;
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
					if (dbuser.getU_is_mgr() == 'y') { // 운영자이면 main_mgr로 이동
//						mv.setViewName("/manager/main_mgr");
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

//	@RequestMapping("/udelete.mc")
//	public String delete(String id) {
//		try {
//			biz.remove(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "redirect:ulist.mc";
//	}
//	@RequestMapping("/uupdateimpl.mc")
//	public String updateimpl(UserVO user) {
//		try {
//			biz.modify(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		String id = user.getU_id();
//		return "redirect:main.sp?id="+id;
//	}
//	
//	@RequestMapping("/uupdate.mc")
//	public ModelAndView update(ModelAndView mv,
//			String id) {
//		UserVO user = null;
//		try {
//			user = biz.get(id);
//			mv.addObject("uuser", user);
//			//mv.addObject("center", "user/update");
//			mv.setViewName("main");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return mv;
//	}

}
