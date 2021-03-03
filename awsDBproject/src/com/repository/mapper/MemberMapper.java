package com.repository.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.Member;
import model.Setting;

public interface MemberMapper {
	ArrayList<Member> selectAllMember();
	Member selectOneMemberById(int id);
	Member selectOneMemberByLoginId(String login_id);
	Member loginCheck(@Param("login_id") String login_id, @Param("password") String password);
	int countAllMember();
	int insertMember(Member member);
	int updateMember(Member member);
	int updateMemberNoImage(Member member);
	int deleteMemberById(int id);
}
