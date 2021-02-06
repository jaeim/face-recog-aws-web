package controller.working;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.LogInfo;
import model.service.Manager;

public class ShowLogInfoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Manager manager = Manager.getInstance();
		
		int memberId = Integer.valueOf((String) request.getParameter("memberId"));
		ArrayList<LogInfo> logInfoList = manager.getLogInfoById(memberId);
		
		for(LogInfo info : logInfoList) {
			System.out.println(info.getLOG_ID());
		}
		
		request.setAttribute("logInfoList", logInfoList);
		return "/working/showInfo.jsp";
	}

}
