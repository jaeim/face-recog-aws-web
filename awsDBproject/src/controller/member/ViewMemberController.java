package controller.member;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

import model.Member;
import model.service.Manager;
// 재임
public class ViewMemberController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String login_id = request.getParameter("login_id");
		
		Member member = new Member();
		try {
			Manager manager = Manager.getInstance();
			member = manager.getOneMemberByLoginId(login_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		String filePath = "C:/dev/" + member.getMember_name() + ".jpg";
////		String filePath = getClass().getResource("/").getPath() + member.getMember_name() + ".jpg";
//		
// 		byte[] imageByte = member.getImage_blob();
//		ByteArrayInputStream inputStream = new ByteArrayInputStream(imageByte);
//		BufferedImage bufferedImage = ImageIO.read(inputStream);
//
//		ImageIO.write(bufferedImage, "jpg", new File(filePath)); //저장하고자 하는 파일 경로를 입력합니다.
//		
//		request.setAttribute("filepath", filePath);
//		request.setAttribute("member", member);
		
		if(member == null) {
			return "";
		}
		
		request.setAttribute("member", member);
		return "/test/viewUser.jsp";		
	}
}
