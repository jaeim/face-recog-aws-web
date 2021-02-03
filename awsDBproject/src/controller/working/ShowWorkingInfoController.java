package controller.working;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.WorkingInfo;
import model.service.Manager;

public class ShowWorkingInfoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Manager manager = Manager.getInstance();
		
		int logId = Integer.valueOf(request.getParameter("logId"));
		
		ArrayList<WorkingInfo> workingInfoList = manager.getWorkingInfoById(logId);
		request.setAttribute("workingInfoList", workingInfoList);
		
		return "/working/showInfo.jsp";
	}

}
