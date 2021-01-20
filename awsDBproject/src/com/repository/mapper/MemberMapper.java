package com.repository.mapper;

import model.Member;

public interface MemberMapper {
	Member selectOneMemberByLoginId(String login_id);

}
