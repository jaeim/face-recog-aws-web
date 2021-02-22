package controller.working;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.LogInfo;
import model.WorkingInfo;
import model.service.Manager;

public class DetailLogController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Manager manager = Manager.getInstance();
		
		int work_id = Integer.valueOf(request.getParameter("workId"));
		
		WorkingInfo workInfo = manager.getLogInfoByWorkId(work_id);
		
		LogInfo logInfo = workInfo.getLogInfo();
		
		System.out.println(logInfo.getTITLE());
		
		request.setAttribute("logInfo", logInfo);
		
		return "/working/detailLog.jsp";
	}

}
