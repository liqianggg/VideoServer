package com.netease.vcloud.upload.param;

/**
 * 
 * @author zhangxufeng
 * @date 2016-7-20
 *
 */
public class VideoTranscodeIDRet {

	private Integer passCount;// 转码忽略的数量，即已经存在该转码格式视频
	private Integer failCount; // 转码失败的数量
	private Integer successCount; // 转码成功的数量

	public Integer getPassCount() {
		return passCount;
	}

	public void setPassCount(Integer passCount) {
		this.passCount = passCount;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

	public Integer getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}

	@Override
	public String toString() {
		return "VideoTranscodeIDRet [passCount=" + passCount + ", failCount=" + failCount + ", successCount="
				+ successCount + "]";
	}

}
