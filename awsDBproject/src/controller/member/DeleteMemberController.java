package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.Manager;

public class DeleteMemberController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int member_id = Integer.parseInt(request.getParameter("member_id").toString());
		int result = 0;
		Manager manager = Manager.getInstance();
		try {
			result = manager.deleteMemberById(member_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/user/site-login";
	}

}
