package cn.appsys.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.backend.BackUserService;
import cn.appsys.service.devuser.DevUserService;

@Controller
public class LoginControler {
	
	@Resource
	private BackUserService backUserService;
	@Resource
	private DevUserService devUserService;
	
	/**
	 * 后台管理员注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/manager/logout")
	public String doBackLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/manager/login";
	}
	
	@RequestMapping("/manager/main")
	public String toBackendMain() {
		return "backend/main";
	}
	
	/**
	 * 后台管理员登录
	 * @param request
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	@RequestMapping("/manager/dologin")
	public String doBackLogin(HttpServletRequest request,@RequestParam String userCode,@RequestParam String userPassword) {
		BackendUser loginUser = backUserService.login(userCode,userPassword);
		if(loginUser == null) {
			request.setAttribute("error","用户名或密码错误");
			return "backendlogin";
		}
		request.getSession().setAttribute("backLoginUser",loginUser);
		return "redirect:/manager/main";
	}
	
	/**
	 * 开发者注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/dev/logout")
	public String doDevLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/dev/login";
	}
	
	@RequestMapping("/dev/main")
	public String toDevMain() {
		return "developer/main";
	}
	
	/**
	 * 开发者登录
	 * @param request
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	@RequestMapping("/dev/dologin")
	public String doDevLogin(HttpServletRequest request,@RequestParam String devCode,@RequestParam String devPassword) {
		DevUser loginUser = devUserService.login(devCode,devPassword);
		if(loginUser == null) {
			request.setAttribute("error", "用户名或密码错误");
			return "devlogin";
		}
		request.getSession().setAttribute("devLoginUser", loginUser);
		return "redirect:/dev/main";
	}
	
	//后台管理和开发者平台登录入口跳转
	@RequestMapping("/manager/login")
	public String toManagerLogin() {
		return "backendlogin";
	}
	
	@RequestMapping("/dev/login")
	public String toDevLogin() {
		return "devlogin";
	}
}
