package com.repository.mapper;

import org.apache.catalina.User;

import model.Member;

public interface MemberMapper {
	Member selectOneMemberByLoginId(String login_id);
}
