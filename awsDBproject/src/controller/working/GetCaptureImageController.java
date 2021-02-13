package controller.working;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import controller.Controller;
import model.ImageInfo;
import model.Member;
import model.service.Manager;

public class GetCaptureImageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Manager manager = Manager.getInstance();
		
		Date now = new Date();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-SS");
		System.out.println(format.format(now));
		
		String path="C:\\Users\\yoo77\\Image\\capture";
		int maxFileSize = 1024 * 1024 * 15;
		MultipartRequest mRequest = new MultipartRequest(request, path, maxFileSize, "utf-8", new DefaultFileRenamePolicy());
		String imageName = mRequest.getFile("image").getName();
		String id = mRequest.getParameter("id");
		String work = mRequest.getParameter("work");
		
		System.out.println("id : " + id + ", work : " + work + ", ImageName : " + imageName);
		
		Member member = manager.getOneMemberByLoginId(id);
		ImageInfo imageInfo = new ImageInfo();
		imageInfo.setUSER_ID(member.get_id());
		imageInfo.setPATH(path + "\\" + imageName);
		
		if(manager.insertImageInfo(imageInfo)) {
			System.out.println("Success to insert image!");
		}else {
			System.out.println("Fail to insert image..");
		}
		
		return "/test/viewCaptureImage.jsp";
	}

}
