package com.repository.mapper;

import java.util.ArrayList;

import model.WorkingInfo;

public interface WorkingInfoMapper {
	ArrayList<WorkingInfo> selectWorkingInfoById(int log_id);
	int insertWorkingInfo(WorkingInfo info);
}
