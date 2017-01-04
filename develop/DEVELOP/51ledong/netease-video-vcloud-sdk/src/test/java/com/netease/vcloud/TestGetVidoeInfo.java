package com.netease.vcloud;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;

import com.netease.vcloud.client.QueryVideoInfoClient;
import com.netease.vcloud.upload.module.VideoInfoRetModule;

@Ignore
public class TestGetVidoeInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Object> initParamMap = null;
		QueryVideoInfoClient qt = new QueryVideoInfoClient();
		initParamMap = new HashMap<String, Object>();
		initParamMap.put("vid", 58116);
		try {
			VideoInfoRetModule videoInfoRetModule = qt.queryVideoInfo(initParamMap);
			System.out.println(videoInfoRetModule.toString());
		} catch (VcloudException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
