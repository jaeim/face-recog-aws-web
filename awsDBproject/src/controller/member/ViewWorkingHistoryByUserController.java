package controller.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.WorkingInfo;
import model.service.Manager;

public class ViewWorkingHistoryByUserController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int _id = Integer.parseInt(request.getParameter("_id"));
		
		ArrayList<WorkingInfo> workingInfoList = null;
		Member member = null;
		try {
			Manager manager = Manager.getInstance();
			workingInfoList = manager.selectWorkingInfoAndLogInfoById(_id);
			member = manager.getOneMemberById(_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("workingInfoList", workingInfoList);
		request.setAttribute("member", member);
		
		return "/user/viewWorkingInfoByUser.jsp";
	}
}
