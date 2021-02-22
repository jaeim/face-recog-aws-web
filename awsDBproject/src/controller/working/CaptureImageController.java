package controller.working;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ImageInfo;
import model.service.Manager;

public class CaptureImageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int work_id = Integer.valueOf(request.getParameter("workId"));
		
		Manager manager = Manager.getInstance();

		ArrayList<ImageInfo> imageInfoList = manager.selectImageInfoByWorkId(work_id);
		
		request.setAttribute("imageInfoList", imageInfoList);
		
		return "/working/imgGallery.jsp";
//		return "/working/captureImage.jsp";
	}

}
