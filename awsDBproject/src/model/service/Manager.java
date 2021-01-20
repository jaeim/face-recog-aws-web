package model.service;

import org.apache.jasper.tagplugins.jstl.core.If;

import model.Member;
import model.dao.MemberDAO;

public class Manager {
	private static Manager manager = new Manager();
	private MemberDAO memberDAO;
	
	private Manager() {
		try {
			memberDAO = MemberDAO.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Manager getInstance() {
		return manager;
	}
	
	public Member getOneMemberByLoginId(String login_id) throws NotFoundException {
		Member member = memberDAO.selectOneMemberByLoginId(login_id);
		if (member == null) {	throw new NotFoundException(login_id + "는(은) 존재하지 않는 아이디 입니다.");		}
		return member;	
	}
}
