package com.repository.mapper;

import model.LogInfo;

public interface LogInfoMapper {
	LogInfo selectLogInfoByIdInfo (int usr_id);
	int insertLogInfo (LogInfo logInfo);
}
