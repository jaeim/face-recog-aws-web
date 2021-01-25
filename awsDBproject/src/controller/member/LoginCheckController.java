package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import controller.Controller;
import model.Member;
import model.service.Manager;

public class LoginCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		if(request.getMethod().equals("POST")) {
			
		}
		
		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");
		
		Manager manager = Manager.getInstance();
		Member member = manager.loginCheck(login_id, password);
		
		if(member == null) {
			return "/user/fail.jsp";
		}
		
//		여기서 response해도 괜찮지 않을까?
//		응답이 이미 커밋된 후에는 forward할 수 없다는 오류가 뜬다.
		
		request.setAttribute("member", member);
		return "/user/result.jsp";
	}

}
