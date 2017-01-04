package com.netease.vcloud.upload.param;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author zhangxufeng
 * @date 2016-7-20
 *
 */
public class VideoTranscodeParam {

	private List<Integer> vids; // 入参视频vid
	private int sdMp4;
	private int hdMp4;
	private int shdMp4;
	private int sdFlv;
	private int hdFlv;
	private int shdFlv;
	private int sdHls;
	private int hdHls;
	private int shdHls;

	
	public VideoTranscodeParam() {
		super();
	}

	public VideoTranscodeParam(Map<String, Object> initParamMap) {
		super();
		this.vids = (List<Integer>) initParamMap.get("vids");
		this.sdMp4 = (Integer) initParamMap.get("sdMp4");
		this.hdMp4 = (Integer) initParamMap.get("hdMp4");
		this.shdMp4 = (Integer) initParamMap.get("shdMp4");
		this.sdFlv = (Integer) initParamMap.get("sdFlv");
		this.hdFlv = (Integer) initParamMap.get("hdFlv");
		this.shdFlv = (Integer) initParamMap.get("shdFlv");
		this.sdHls = (Integer) initParamMap.get("sdHls");
		this.hdHls = (Integer) initParamMap.get("sdHls");
		this.shdHls = (Integer) initParamMap.get("sdHls");
	}

	public VideoTranscodeParam(List<Integer> vids, int sdMp4, int hdMp4, int shdMp4, int sdFlv, int hdFlv, int shdFlv,
			int sdHls, int hdHls, int shdHls) {
		super();
		this.vids = vids;
		this.sdMp4 = sdMp4;
		this.hdMp4 = hdMp4;
		this.shdMp4 = shdMp4;
		this.sdFlv = sdFlv;
		this.hdFlv = hdFlv;
		this.shdFlv = shdFlv;
		this.sdHls = sdHls;
		this.hdHls = hdHls;
		this.shdHls = shdHls;
	}

	public List<Integer> getVids() {
		return vids;
	}

	public void setVids(List<Integer> vids) {
		this.vids = vids;
	}

	public int getSdMp4() {
		return sdMp4;
	}

	public void setSdMp4(int sdMp4) {
		this.sdMp4 = sdMp4;
	}

	public int getHdMp4() {
		return hdMp4;
	}

	public void setHdMp4(int hdMp4) {
		this.hdMp4 = hdMp4;
	}

	public int getShdMp4() {
		return shdMp4;
	}

	public void setShdMp4(int shdMp4) {
		this.shdMp4 = shdMp4;
	}

	public int getSdFlv() {
		return sdFlv;
	}

	public void setSdFlv(int sdFlv) {
		this.sdFlv = sdFlv;
	}

	public int getHdFlv() {
		return hdFlv;
	}

	public void setHdFlv(int hdFlv) {
		this.hdFlv = hdFlv;
	}

	public int getShdFlv() {
		return shdFlv;
	}

	public void setShdFlv(int shdFlv) {
		this.shdFlv = shdFlv;
	}

	public int getSdHls() {
		return sdHls;
	}

	public void setSdHls(int sdHls) {
		this.sdHls = sdHls;
	}

	public int getHdHls() {
		return hdHls;
	}

	public void setHdHls(int hdHls) {
		this.hdHls = hdHls;
	}

	public int getShdHls() {
		return shdHls;
	}

	public void setShdHls(int shdHls) {
		this.shdHls = shdHls;
	}

	@Override
	public String toString() {
		return "VideoTranscodeParam [vids=" + vids + ", sdMp4=" + sdMp4 + ", hdMp4=" + hdMp4 + ", shdMp4=" + shdMp4
				+ ", sdFlv=" + sdFlv + ", hdFlv=" + hdFlv + ", shdFlv=" + shdFlv + ", sdHls=" + sdHls + ", hdHls="
				+ hdHls + ", shdHls=" + shdHls + "]";
	}

}
