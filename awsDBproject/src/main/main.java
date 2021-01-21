package main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.ibatis.javassist.ByteArrayClassPath;

import com.mysql.cj.jdbc.Blob;

import model.Member;
import model.dao.MemberDAO;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("테스트시작");
		Connect c = new Connect();
		c.test();
		
//		MemberDAO memberDAO = MemberDAO.getInstance();
//		Member member = memberDAO.selectOneMemberByLoginId("yhj");
//		
//		saveImage(member);
//		System.out.println("이름 : " + member.getMember_name() + " / 비밀번호 : " + member.getPassword());
	
		
		
	}

//	public static void saveImage(Member member) throws Exception {
//		String filePath = "C:/dev/" + member.getMember_name() + ".jpg";
//		byte[] imageByte = member.getImage_blob();
//		ByteArrayInputStream inputStream = new ByteArrayInputStream(imageByte);
//		BufferedImage bufferedImage = ImageIO.read(inputStream);
//
//		ImageIO.write(bufferedImage, "jpg", new File(filePath)); //저장하고자 하는 파일 경로를 입력합니다.
//
//	}

}

