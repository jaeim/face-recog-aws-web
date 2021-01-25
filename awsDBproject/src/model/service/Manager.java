package model.service;

import org.apache.jasper.tagplugins.jstl.core.If;

import model.Member;
import model.Setting;
import model.dao.MemberDAO;
import model.dao.SettingDAO;

public class Manager {
	private static Manager manager = new Manager();
	private MemberDAO memberDAO;
	private SettingDAO settingDAO;
	
	private Manager() {
		try {
			memberDAO = MemberDAO.getInstance();
			settingDAO = SettingDAO.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Manager getInstance() {
		return manager;
	}
	
	public Member getOneMemberByLoginId(String login_id) throws NotFoundException {
		Member member = memberDAO.selectOneMemberByLoginId(login_id);
//		if (member == null) {	throw new NotFoundException(login_id + "는(은) 존재하지 않는 아이디 입니다.");		}
		return member;	
	}
	
	public Member loginCheck(String login_id, String password) throws NotFoundException {
		Member member = memberDAO.loginCheck(login_id, password);
//		if (member == null) {	throw new NotFoundException(login_id + "는(은) 존재하지 않는 아이디 입니다.");		}
		return member;	
	}
	
	public Setting getSettingInfo() {
		System.out.println("Manager.getSettingInfo");
		Setting setting = settingDAO.selectSettingInfo();
		
		return setting;
	}
}
