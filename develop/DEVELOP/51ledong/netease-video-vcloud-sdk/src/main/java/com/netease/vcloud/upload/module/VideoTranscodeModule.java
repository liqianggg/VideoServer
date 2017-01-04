package com.netease.vcloud.upload.module;

import com.netease.vcloud.upload.param.VideoTranscodeIDRet;
/**
 * 
 * @author zhangxufeng
 *
 */
public class VideoTranscodeModule {

	private VideoTranscodeIDRet ret;
	private int code;

	

	public VideoTranscodeIDRet getRet() {
		return ret;
	}

	public void setRet(VideoTranscodeIDRet ret) {
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
		return "VideoTranscodeModule [ret=" + ret + ", code=" + code + "]";
	}

}
