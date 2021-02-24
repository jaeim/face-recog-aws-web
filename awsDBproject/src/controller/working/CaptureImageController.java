package controller.working;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ImageInfo;
import model.WorkingInfo;
import model.service.Manager;

public class CaptureImageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int work_id = Integer.valueOf(request.getParameter("workId"));
		String member_name = request.getParameter("memberName");
		
		Manager manager = Manager.getInstance();
		
		WorkingInfo workingInfo = manager.selectWorkInfoByWorkId(work_id);
		
		ArrayList<ImageInfo> imageInfoList = manager.selectImageInfoByWorkId(work_id);
		
		request.setAttribute("memberName", member_name);
		request.setAttribute("workingInfo", workingInfo);
		request.setAttribute("imageInfoList", imageInfoList);
		
		return "/working/imgGallery.jsp";
//		return "/working/captureImage.jsp";
	}

}
