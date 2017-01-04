package com.netease.vcloud.upload.param;

import java.util.Map;
/**
 * 
 * @author zhangxufeng
 *
 */
public class QueryVideoInfoParam {

	private int vid;

	
	public QueryVideoInfoParam(Map<String, Object> initParamMap) {
		this.vid = (Integer) initParamMap.get("vid");
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}
	
	
}
