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

public class RegisterMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
//		String path = "/home/ubuntu/log";
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
	    
	    System.out.println(image_blob);
	    
	    Member member = new Member();
	    member.setImage_blob(image_blob);
	    member.setLogin_id(multipartRequest.getParameter("id"));
	    member.setMember_name(multipartRequest.getParameter("name"));
	    member.setPassword(multipartRequest.getParameter("password"));
	    
	    Manager manager = Manager.getInstance();
	    if(manager.insertMember(member)) {
	    	System.out.println("Insert Success!");
	    }else {
	    	System.out.println("Insert Fail..");
	    }
	    
	    return "redirect:/user/site-login";	
	}

}
