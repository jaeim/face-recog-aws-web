package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.service.Manager;

public class LoginCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");
		
		Manager manager = Manager.getInstance();
		Member member = manager.loginCheck(login_id, password);
		
		if(member == null) {
			return "/user/fail.jsp";
		}
		
		request.setAttribute("member", member);
		return "/user/result.jsp";
	}

}
