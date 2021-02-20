package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Member;
import model.service.Manager;
import model.service.NotFoundException;
import model.service.PasswordMismatchException;

public class SiteLoginController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");
		
		try {
			Manager manager = Manager.getInstance();
			Member member = manager.loginCheck(login_id, password);
			
			HttpSession session = request.getSession();
			session.setAttribute(UserSessionUtils.USER_SESSION_KEY, member.get_id());
			
			// 근태정보 가져오기
			
			// 모든 근무자 정보 가져오기
			
			request.setAttribute("memeber", member);
			// 로그인 시 메인페이지로 이동
			return "user/mainPage.jsp";			
		} catch (Exception e) {
			if(e instanceof NotFoundException) {request.setAttribute("notFound", true);}
			if(e instanceof PasswordMismatchException) {request.setAttribute("passwordMismatch", true);}
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
            return "/user/login.jsp";			
		}
	}
}
