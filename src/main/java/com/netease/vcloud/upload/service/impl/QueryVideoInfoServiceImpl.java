package com.netease.vcloud.upload.service.impl;

/**
 * <p>Company: NewNet</p>
* @date       2016-7-19
* @author zhangxufeng
 */
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.upload.module.VideoInfoRetModule;
import com.netease.vcloud.upload.param.QueryVideoInfoParam;
import com.netease.vcloud.upload.service.QueryVideoInfoService;
import com.netease.vcloud.upload.util.QueryVideoInfoUtil;

public class QueryVideoInfoServiceImpl implements QueryVideoInfoService {

	public static final Logger logger = Logger.getLogger(QueryVideoInfoServiceImpl.class);
	@Override
	public VideoInfoRetModule queryVideoInfo(Map<String, Object> initParamMap) throws VcloudException {
			
		try {
			QueryVideoInfoParam queryVideoInfoParam = new QueryVideoInfoParam(initParamMap);
			QueryVideoInfoUtil util = new QueryVideoInfoUtil(queryVideoInfoParam);
			VideoInfoRetModule videoInfoRetModule = util.queryVideoInfo();
			return videoInfoRetModule ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
