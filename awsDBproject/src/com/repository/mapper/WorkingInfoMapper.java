package com.repository.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.WorkingInfo;

public interface WorkingInfoMapper {
	ArrayList<WorkingInfo> selectWorkingInfoById(int log_id);
	int insertWorkingInfo(WorkingInfo info);
	WorkingInfo selectLogInfoByWorkId(int work_id);
	ArrayList<WorkingInfo> selectWorkingInfoAndLogInfoById(int _id);
	Integer selectWorkTimeForToday(@Param("usr_id") int userId, @Param("working_dt") String workingDate);
	WorkingInfo selectWorkInfoByWorkId(int workId);
	int deleteWorkInfoByWorkId(int workId);
}
