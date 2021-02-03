package controller.working;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.service.Manager;

public class ShowMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Manager manager = Manager.getInstance();
		
		ArrayList<Member> memberList = manager.getAllMember();
		
		request.setAttribute("memberList", memberList);
		
		return "/working/showInfo.jsp";
	}

}
