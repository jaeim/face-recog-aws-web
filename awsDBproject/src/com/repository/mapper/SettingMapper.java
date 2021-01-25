package com.repository.mapper;

import model.Setting;

public interface SettingMapper {
	Setting selectSettingInfo();
	
	int updateSettingInfo(Setting stg);
}
