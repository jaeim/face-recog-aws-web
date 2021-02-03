package com.repository.mapper;

import java.util.ArrayList;

import model.LogInfo;

public interface LogInfoMapper {
	ArrayList<LogInfo> selectLogInfoById (int usr_id);
	int insertLogInfo (LogInfo logInfo);
}
