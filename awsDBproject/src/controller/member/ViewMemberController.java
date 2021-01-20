package controller.member;

import java.net.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

import model.Member;
import model.service.Manager;
// 재임
public class ViewMemberController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String login_id = request.getParameter("login_id");
		
		Member member = new Member();
		try {
			Manager manager = Manager.getInstance();
			member = manager.getOneMemberByLoginId(login_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] image = member.getImage_blob();
		if(image != null) {
			
		}
		
		request.setAttribute("member", member);
		return "/user/result.jsp";	
		
	}
}
