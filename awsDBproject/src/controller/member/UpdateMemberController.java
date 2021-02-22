package controller.member;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;
import model.Member;
import model.service.Manager;

public class UpdateMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stu
		Manager manager = Manager.getInstance();
//		폼 요청
		if(request.getMethod().equals("GET")) {
			int id = Integer.valueOf(request.getParameter("id"));
			Member member = manager.getOneMemberById(id);
			
			request.setAttribute("member", member);
			return "/user/updateForm.jsp";
		}
		
//		업데이트 요청
		String path = "C:\\project\\awsworkspace\\userImage";
		System.out.println(path);
		int maxFileSize = 1024 * 1024 * 2;
		
//		전달 받은 이미지 저장
		MultipartRequest multipartRequest = new MultipartRequest(request, path, maxFileSize, "utf-8", new DefaultFileRenamePolicy());
		Enumeration fileNames = multipartRequest.getFileNames();
		String filename = "";
		while(fileNames.hasMoreElements()) {
			String key = (String) fileNames.nextElement();
			filename = multipartRequest.getFile(key).getName();
		}
		System.out.println(filename);
		
//		저장한 이미지 다시 읽기 (db에 저장해야 하기 떄문에)
		BufferedImage bImage = ImageIO.read(new File(path + "/" + filename));
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    ImageIO.write(bImage, "jpeg", bos);
	    byte [] image_blob = bos.toByteArray();
		
	    Member member = new Member();
	    member.setImage_blob(image_blob);
	    member.set_id(Integer.valueOf(multipartRequest.getParameter("id")));
	    member.setMember_name(multipartRequest.getParameter("name"));
	    member.setLogin_id(multipartRequest.getParameter("login_id"));
	    member.setPassword(multipartRequest.getParameter("password"));
	    
	    if(manager.updateMember(member)) {
	    	System.out.println("Update Success!");
	    }else {
	    	System.out.println("Update fail..");
	    }
	    
	    
		return "redirect:/user/update?id=" + member.get_id();
	}

}
