package com.repository.mapper;

import java.util.ArrayList;
import model.ImageInfo;
import model.WorkingInfo;

public interface ImageInfoMapper {
	ArrayList<ImageInfo> selectAllImageInfo();
	int insertImageInfo(ImageInfo imageInfo);
	ArrayList<ImageInfo> selectImageInfoByWorkId(int work_id);
}