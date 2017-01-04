package com.netease.vcloud.upload.demo;

import java.util.HashMap;
import java.util.Map;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.client.QueryVideoInfoClient;
import com.netease.vcloud.upload.module.VideoInfoRetModule;

public class QueryVideoInfoDemo {

	public static void main(String[] args) {
		QueryVideoInfoClient QueryVideoInfoClient = new QueryVideoInfoClient();
		VideoInfoRetModule videoInfoRetModule = new VideoInfoRetModule();
		Map<String, Object> initParamMap = null;
		initParamMap = new HashMap<String, Object>();
		int vid = 64267;
		initParamMap.put("vid", vid);
		try {
			videoInfoRetModule = QueryVideoInfoClient.queryVideoInfo(initParamMap);
			System.out.println(videoInfoRetModule.toString());
		} catch (VcloudException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
