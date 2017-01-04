package com.netease.vcloud.upload.service;

import java.util.Map;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.upload.module.VideoTranscodeModule;

/**
 * 
 * <p>Company: NewNet</p>
 * @date       2016-7-19
 * @author zhangxufeng
 */
public interface ViderTranscodeService {

	public VideoTranscodeModule ViderTranscode(Map<String, Object> initParamMap)throws VcloudException;
}
