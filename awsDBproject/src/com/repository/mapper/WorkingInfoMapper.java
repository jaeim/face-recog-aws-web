package com.repository.mapper;

import model.WorkingInfo;

public interface WorkingInfoMapper {
	WorkingInfo selectWorkingInfoById(int user_id);
	int insertWorkingInfo(WorkingInfo info);
}
