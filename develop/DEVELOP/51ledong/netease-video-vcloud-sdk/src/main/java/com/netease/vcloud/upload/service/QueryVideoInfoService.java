package com.netease.vcloud.upload.service;

import java.util.Map;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.upload.module.VideoInfoRetModule;

/**
 * 视频信息类
 * <p>Company: NewNet</p>
 * @date       2016-7-19
 * @author zhangxufeng
 */
public interface QueryVideoInfoService {

	/**
	 * 查询视频相信信息
	 * @param vid
	 * @return VideoInfoModule
	 */
	public VideoInfoRetModule queryVideoInfo(Map<String, Object> initParamMap)throws VcloudException;
}
