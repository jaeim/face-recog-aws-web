package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.service.Manager;
// 재임
public class ViewMemberController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String login_id = request.getParameter("login_id");
		
		Member member = new Member();
		try {
			Manager manager = Manager.getInstance();
			member = manager.getOneMemberByLoginId(login_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user/result.jsp";
	}
}
