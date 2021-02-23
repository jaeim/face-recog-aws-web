package controller.member;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			String str_id = request.getParameter("id");
			int id = -1;
			if(str_id == null) {
				HttpSession session = request.getSession();
				id = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
				System.out.println(id);
			}
			if(str_id != null) {
				id = Integer.valueOf(str_id);
			}

			if(id == -1) {
//				오류
				return null; 
			}
			
			Member member = manager.getOneMemberById(id);
			
			request.setAttribute("member", member);
			return "/user/updateForm.jsp";
		}
		
		String result = request.getParameter("image");
	    Member member = new Member();
	    
//		사진이 첨부되었을 때
		if(result == null) {	
			String path = "/home/ubuntu/log";
//			String path = "C:\\project\\awsworkspace\\userImage";
			System.out.println(path);
			int maxFileSize = 1024 * 1024 * 2;
			
//			전달 받은 이미지 저장
			MultipartRequest multipartRequest = new MultipartRequest(request, path, maxFileSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration fileNames = multipartRequest.getFileNames();
			if(fileNames == null) {
				System.out.println("파일 이름 없음");
			}
			String filename = "";
			while(fileNames.hasMoreElements()) {
				String key = (String) fileNames.nextElement();
				filename = multipartRequest.getFile(key).getName();
			}
			System.out.println(filename);
			
//			저장한 이미지 다시 읽기 (db에 저장해야 하기 떄문에)
			BufferedImage bImage = ImageIO.read(new File(path + "/" + filename));
		    ByteArrayOutputStream bos = new ByteArrayOutputStream();
		    ImageIO.write(bImage, "jpeg", bos);
		    byte [] image_blob = bos.toByteArray();
			
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
		     
//			사진이 첨부되지 않았을 때
		}else {
			System.out.println("result is " + result);
			System.out.println(request.getParameter("login_id"));
			System.out.println(request.getParameter("name"));
			System.out.println(request.getParameter("password"));
			member.set_id(Integer.valueOf(request.getParameter("id")));
			member.setMember_name(request.getParameter("name"));
			member.setLogin_id(request.getParameter("login_id"));
			member.setPassword(request.getParameter("password"));
			
			if(manager.updateMemberNoImage(member)){
		    	System.out.println("Update Success!");
		    }else {
		    	System.out.println("Update fail..");
		    }
			
		}
		
		return "redirect:/user/update?id=" + member.get_id();
	}

}
