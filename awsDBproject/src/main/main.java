package main;

import model.Member;
import model.dao.MemberDAO;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println("테스트시작");
//		Connect c = new Connect();
//		c.test();
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		Member member = memberDAO.selectOneMemberByLoginId("yhj");
		
		System.out.println("이름 : " + member.getMember_name() + " / 비밀번호 : " + member.getPassword());
				
	}

}
