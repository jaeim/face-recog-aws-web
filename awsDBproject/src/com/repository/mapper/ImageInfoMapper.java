package com.repository.mapper;

import java.util.ArrayList;
import model.ImageInfo;
import model.WorkingInfo;

public interface ImageInfoMapper {
	ArrayList<ImageInfo> selectAllImageInfo();
	ArrayList<ImageInfo> selectImageInfoByUserId(int user_id);
	int insertImageInfo(ImageInfo imageInfo);
}