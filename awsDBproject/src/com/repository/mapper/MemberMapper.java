package com.repository.mapper;

import org.apache.ibatis.annotations.Param;

import model.Member;

public interface MemberMapper {
	Member selectOneMemberByLoginId(String login_id);
	Member loginCheck(@Param("login_id") String login_id, @Param("password") String password);
}
