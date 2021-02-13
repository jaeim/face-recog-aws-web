package controller.working;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.Manager;
import model.ImageInfo;
import model.Member;


public class ShowCaptureImageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Manager manager = Manager.getInstance();
//		테이블에서 캡쳐이미지테이블 읽기
		ArrayList<ImageInfo> imageInfoList = manager.selectAllImageInfo();
//		DTO로 저장하여 setAttribute하기
		
		request.setAttribute("imageInfoList", imageInfoList);
		
		return "/working/showCaptureImage.jsp";
	}

}
