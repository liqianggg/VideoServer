package com.netease.vcloud.upload.service.impl;

import java.io.IOException;
import java.util.Map;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.upload.module.VideoTranscodeModule;
import com.netease.vcloud.upload.param.VideoTranscodeParam;
import com.netease.vcloud.upload.service.ViderTranscodeService;
import com.netease.vcloud.upload.util.VideoTranscodeUtil;

/**
 * 
 * <p>Company: NewNet</p>
* @date       2016-7-19
* @author zhangxufeng
 */
public class ViderTranscodeServiceImpl implements ViderTranscodeService {

	@Override
	public VideoTranscodeModule ViderTranscode(Map<String, Object> initParamMap) throws VcloudException {
		try {
			VideoTranscodeParam videoTranscodeParam = new VideoTranscodeParam(initParamMap);
			VideoTranscodeUtil util = new VideoTranscodeUtil(videoTranscodeParam);
			VideoTranscodeModule videoTranscodeModule = util.videoTranscode();
			return videoTranscodeModule;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
