package com.netease.vcloud.upload.param;

import java.util.Map;

public class DeleteVideoParam {

	private int vid;
	private int style;
	
	

	public DeleteVideoParam() {
		super();
	}
	
	public DeleteVideoParam(int vid, int style) {
		super();
		this.vid = vid;
		this.style = style;
	}

	public DeleteVideoParam(Map<String, Object> initParamMap) {
		super();
		this.vid = (Integer) initParamMap.get("vid");
		this.style = (Integer) initParamMap.get("style");
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

}
