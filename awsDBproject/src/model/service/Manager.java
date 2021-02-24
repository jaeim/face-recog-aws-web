package model.service;

import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.If;

import model.*;
import model.dao.*;

public class Manager {
	private static Manager manager = new Manager();
	private MemberDAO memberDAO;
	private SettingDAO settingDAO;
	private LogInfoDAO logInfoDAO;
	private WorkingInfoDAO workingInfoDAO;
	private ImageInfoDAO imageInfoDAO;
	
	private Manager() {
		try {
			memberDAO = MemberDAO.getInstance();
			settingDAO = SettingDAO.getInstance();
			logInfoDAO = LogInfoDAO.getInstance();
			workingInfoDAO = WorkingInfoDAO.getInstance();
			imageInfoDAO = ImageInfoDAO.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Manager getInstance() {
		return manager;
	}
	
	public ArrayList<Member> getAllMember(){
		ArrayList<Member> memberList = memberDAO.selectAllMember();
		
		return memberList;
	}
	
	public Member getOneMemberById(int id) {
		Member member = memberDAO.selectOneMemberById(id);
		return member;	
	}
	
	public Member getOneMemberByLoginId(String login_id) throws NotFoundException {
		Member member = memberDAO.selectOneMemberByLoginId(login_id);
//		if (member == null) {	throw new NotFoundException(login_id + "는(은) 존재하지 않는 아이디 입니다.");		}
		return member;	
	}
	
	public Member loginCheck(String login_id, String password) throws NotFoundException {
		Member member = memberDAO.loginCheck(login_id, password);
		if (member == null) {	throw new NotFoundException(login_id + "는(은) 존재하지 않는 아이디 입니다.");		}
		return member;	
	}
	
	public boolean updateMember(Member member) {
		int result = memberDAO.updateMember(member);
		if(result >= 1) {
			return true;
		}
		return false;
	}
	
	public boolean updateMemberNoImage(Member member) {
		int result = memberDAO.updateMemberNoImage(member);
		if(result >= 1) {
			return true;
		}
		return false;
	}
	
	public Setting getSetting() throws NotFoundException {
		Setting stg = settingDAO.selectSettingInfo();
//		if (stg == null) {	throw new NotFoundException("설정 정보를 찾을 수 없습니다.");	}
		return stg;
	}
	
	public int updateSetting(Setting stg) {
		return settingDAO.updateSettingInfo(stg);
	}
	
	public ArrayList<WorkingInfo> getWorkingInfoById(int log_id) {
		ArrayList<WorkingInfo> workingInfoList = workingInfoDAO.selecWorkingInfoById(log_id);
		
		return workingInfoList;
	}
	
	public boolean insertWorkingInfo(WorkingInfo info) {
		int result = workingInfoDAO.insertWorkingInfo(info);
		System.out.println(result);
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
	public WorkingInfo getLogInfoByWorkId(int work_id) {
		WorkingInfo workInfo = workingInfoDAO.selectLogInfoByWorkId(work_id);
	
		return workInfo;
	}
	
	public int selectWorkTimeForToday(int userId, String workingDate) {
		int workTime = workingInfoDAO.selectWorkTimeForToday(userId, workingDate);
		
		return workTime;
	}
	
	public ArrayList<LogInfo> getLogInfoById(int user_id) {
		ArrayList<LogInfo> logInfoList = logInfoDAO.selectLogInfoById(user_id);
		
		return logInfoList;
	}
	
	public boolean insertLogInfo(LogInfo info) {
		int result = logInfoDAO.insertLogInfo(info);
		System.out.println(result);
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
	public ArrayList<ImageInfo> selectAllImageInfo(){
		System.out.println("manager");
		ArrayList<ImageInfo> imageInfoList = imageInfoDAO.selectAllImageInfo();
		return imageInfoList;
	}
	
	public ArrayList<ImageInfo> selectImageInfoByWorkId(int work_id){
		ArrayList<ImageInfo> imageInfoList = imageInfoDAO.selectImageInfoByWorkId(work_id);
		return imageInfoList;
	}
	
	public boolean insertImageInfo(ImageInfo imageInfo) {
		int result = imageInfoDAO.insertImageInfo(imageInfo);
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	// 모든 근로자 수 반환
	public int countAllMember() {
		int count = memberDAO.countAllMember();
		return count;
	}
	
	public boolean insertMember(Member member) {
		System.out.println("Manager insertMember");
		int result = memberDAO.insertMember(member);
		
		if(result == 1){ return true; }
		
		return false;
	}
	// 근무자 기본키로 근무기록과 그에 맞는 로그 객체 반환
	public ArrayList<WorkingInfo> selectWorkingInfoAndLogInfoById(int _id) {
		ArrayList<WorkingInfo> workingInfoList = null;
		workingInfoList = workingInfoDAO.selectWorkingInfoAndLogInfoById(_id);
		return workingInfoList;
	}
	
	public WorkingInfo selectWorkInfoByWorkId(int workId) {
		WorkingInfo info = null;
		info = workingInfoDAO.selectWorkInfoByWorkId(workId);
		return info;
	}
}
