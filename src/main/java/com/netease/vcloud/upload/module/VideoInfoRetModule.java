package com.netease.vcloud.upload.module;

/**
 * 
 * @author zhangxufeng
 * @date 2016-7-19
 *
 */
public class VideoInfoRetModule {

	private VideoInfoModule ret;
	private int code; // 状态码

	public VideoInfoModule getRet() {
		return ret;
	}

	public void setRet(VideoInfoModule ret) {
		this.ret = ret;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "VideoInfoRetModule [ret=" + ret + ", code=" + code + "]";
	}

}
