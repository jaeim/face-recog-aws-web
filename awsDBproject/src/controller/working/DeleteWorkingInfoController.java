package controller.working;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.Manager;

public class DeleteWorkingInfoController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int work_id = Integer.parseInt(request.getParameter("work_id").toString());
		int result = 0;
		Manager manager = Manager.getInstance();
		try {
			result = manager.deleteWorkInfoByWorkId(work_id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "/user/resultForDeleteWork.jsp";
	}

}
