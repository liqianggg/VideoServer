package com.netease.vcloud.upload.module;

import java.math.BigInteger;

/**
 * <p>Title: VideoInfoModule</p>
 * <p>Description: 根据视频ID输入参数的封装类</p>
 * <p>Company: NewNet</p>
 * @date       2016-7-19 
 * @author zhangxufeng
 *
 */
public class VideoInfoModule {

	private String videoName;// 视频的名称
	private BigInteger status;// 视频的状态，10表示初始，20表示失败，30表示处理中，40表示成功，50表示屏蔽
	private String description;// 视频的描述信息
	private BigInteger completeTime;// 转码完成时间
	private BigInteger duration;// 视频播放时长（单位：秒）
	private BigInteger typeId;// 视频所属分类ID
	private String typeName;// 视频所属分类名称
	private String snapshotUrl;// 视频封面截图URL地址
	private String origUrl;// 原始视频的播放地址
	private String downloadOrigUrl;// 原始视频的下载地址
	private BigInteger initialSize;// 原始视频文件大小（单位：字节）
	private String sdMp4Url;// 标清Mp4视频格式文件播放地址
	private String downloadSdMp4Url;// 标清Mp4视频格式文件下载地址
	private BigInteger sdMp4Size;// 标清Mp4视频格式文件的大小（单位：字节）
	private String hdMp4Url;// 高清Mp4视频格式文件播放地址
	private String downloadHdMp4Url;// 高清Mp4视频格式文件下载地址
	private BigInteger hdMp4Size;// 高清Mp4视频格式文件的大小（单位：字节）
	private String shdMp4Url;// 超清Mp4视频格式文件播放地址
	private String downloadShdMp4Url;// 超清Mp4视频格式文件下载地址
	private BigInteger shdMp4Size;// 超清Mp4视频格式文件的大小（单位：字节）
	private String sdFlvUrl;// 标清Flv视频格式文件播放地址
	private String downloadSdFlvUrl;// 标清Flv视频格式文件下载地址
	private BigInteger sdFlvSize;// 标清Flv视频格式文件的大小（单位：字节）
	private String hdFlvUrl;// 高清Flv视频格式文件播放地址
	private String downloadHdFlvUrl;// 高清Flv视频格式文件下载地址
	private BigInteger hdFlvSize;// 高清Flv视频格式文件的大小（单位：字节）
	private String shdFlvUrl;// 超清Flv视频格式文件播放地址
	private String downloadShdFlvUrl;// 超清Flv视频格式文件下载地址
	private BigInteger shdFlvSize;// 超清Flv视频格式文件的大小（单位：字节）
	private BigInteger createTime;// 视频上传时间（单位：毫秒）
	private BigInteger updateTime;// 视频更新时间（单位：毫秒）
	private String msg;// 错误信息


	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public BigInteger getStatus() {
		return status;
	}

	public void setStatus(BigInteger status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigInteger getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(BigInteger completeTime) {
		this.completeTime = completeTime;
	}

	public BigInteger getDuration() {
		return duration;
	}

	public void setDuration(BigInteger duration) {
		this.duration = duration;
	}

	public BigInteger getTypeId() {
		return typeId;
	}

	public void setTypeId(BigInteger typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getSnapshotUrl() {
		return snapshotUrl;
	}

	public void setSnapshotUrl(String snapshotUrl) {
		this.snapshotUrl = snapshotUrl;
	}

	public String getOrigUrl() {
		return origUrl;
	}

	public void setOrigUrl(String origUrl) {
		this.origUrl = origUrl;
	}

	public String getDownloadOrigUrl() {
		return downloadOrigUrl;
	}

	public void setDownloadOrigUrl(String downloadOrigUrl) {
		this.downloadOrigUrl = downloadOrigUrl;
	}

	public BigInteger getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(BigInteger initialSize) {
		this.initialSize = initialSize;
	}

	public String getSdMp4Url() {
		return sdMp4Url;
	}

	public void setSdMp4Url(String sdMp4Url) {
		this.sdMp4Url = sdMp4Url;
	}

	public String getDownloadSdMp4Url() {
		return downloadSdMp4Url;
	}

	public void setDownloadSdMp4Url(String downloadSdMp4Url) {
		this.downloadSdMp4Url = downloadSdMp4Url;
	}

	public BigInteger getSdMp4Size() {
		return sdMp4Size;
	}

	public void setSdMp4Size(BigInteger sdMp4Size) {
		this.sdMp4Size = sdMp4Size;
	}

	public String getHdMp4Url() {
		return hdMp4Url;
	}

	public void setHdMp4Url(String hdMp4Url) {
		this.hdMp4Url = hdMp4Url;
	}

	public String getDownloadHdMp4Url() {
		return downloadHdMp4Url;
	}

	public void setDownloadHdMp4Url(String downloadHdMp4Url) {
		this.downloadHdMp4Url = downloadHdMp4Url;
	}

	public BigInteger getHdMp4Size() {
		return hdMp4Size;
	}

	public void setHdMp4Size(BigInteger hdMp4Size) {
		this.hdMp4Size = hdMp4Size;
	}

	public String getShdMp4Url() {
		return shdMp4Url;
	}

	public void setShdMp4Url(String shdMp4Url) {
		this.shdMp4Url = shdMp4Url;
	}

	public String getDownloadShdMp4Url() {
		return downloadShdMp4Url;
	}

	public void setDownloadShdMp4Url(String downloadShdMp4Url) {
		this.downloadShdMp4Url = downloadShdMp4Url;
	}

	public BigInteger getShdMp4Size() {
		return shdMp4Size;
	}

	public void setShdMp4Size(BigInteger shdMp4Size) {
		this.shdMp4Size = shdMp4Size;
	}

	public String getSdFlvUrl() {
		return sdFlvUrl;
	}

	public void setSdFlvUrl(String sdFlvUrl) {
		this.sdFlvUrl = sdFlvUrl;
	}

	public String getDownloadSdFlvUrl() {
		return downloadSdFlvUrl;
	}

	public void setDownloadSdFlvUrl(String downloadSdFlvUrl) {
		this.downloadSdFlvUrl = downloadSdFlvUrl;
	}

	public BigInteger getSdFlvSize() {
		return sdFlvSize;
	}

	public void setSdFlvSize(BigInteger sdFlvSize) {
		this.sdFlvSize = sdFlvSize;
	}

	public String getHdFlvUrl() {
		return hdFlvUrl;
	}

	public void setHdFlvUrl(String hdFlvUrl) {
		this.hdFlvUrl = hdFlvUrl;
	}

	public String getDownloadHdFlvUrl() {
		return downloadHdFlvUrl;
	}

	public void setDownloadHdFlvUrl(String downloadHdFlvUrl) {
		this.downloadHdFlvUrl = downloadHdFlvUrl;
	}

	public BigInteger getHdFlvSize() {
		return hdFlvSize;
	}

	public void setHdFlvSize(BigInteger hdFlvSize) {
		this.hdFlvSize = hdFlvSize;
	}

	public String getShdFlvUrl() {
		return shdFlvUrl;
	}

	public void setShdFlvUrl(String shdFlvUrl) {
		this.shdFlvUrl = shdFlvUrl;
	}

	public String getDownloadShdFlvUrl() {
		return downloadShdFlvUrl;
	}

	public void setDownloadShdFlvUrl(String downloadShdFlvUrl) {
		this.downloadShdFlvUrl = downloadShdFlvUrl;
	}

	public BigInteger getShdFlvSize() {
		return shdFlvSize;
	}

	public void setShdFlvSize(BigInteger shdFlvSize) {
		this.shdFlvSize = shdFlvSize;
	}

	public BigInteger getCreateTime() {
		return createTime;
	}

	public void setCreateTime(BigInteger createTime) {
		this.createTime = createTime;
	}

	public BigInteger getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(BigInteger updateTime) {
		this.updateTime = updateTime;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "VideoInfoModule ["  + "videoName=" + videoName + ", status=" + status + ", description="
				+ description + ", completeTime=" + completeTime + ", duration=" + duration + ", typeId=" + typeId
				+ ", typeName=" + typeName + ", snapshotUrl=" + snapshotUrl + ", origUrl=" + origUrl
				+ ", downloadOrigUrl=" + downloadOrigUrl + ", initialSize=" + initialSize + ", sdMp4Url=" + sdMp4Url
				+ ", downloadSdMp4Url=" + downloadSdMp4Url + ", sdMp4Size=" + sdMp4Size + ", hdMp4Url=" + hdMp4Url
				+ ", downloadHdMp4Url=" + downloadHdMp4Url + ", hdMp4Size=" + hdMp4Size + ", shdMp4Url=" + shdMp4Url
				+ ", downloadShdMp4Url=" + downloadShdMp4Url + ", shdMp4Size=" + shdMp4Size + ", sdFlvUrl=" + sdFlvUrl
				+ ", downloadSdFlvUrl=" + downloadSdFlvUrl + ", sdFlvSize=" + sdFlvSize + ", hdFlvUrl=" + hdFlvUrl
				+ ", downloadHdFlvUrl=" + downloadHdFlvUrl + ", hdFlvSize=" + hdFlvSize + ", shdFlvUrl=" + shdFlvUrl
				+ ", downloadShdFlvUrl=" + downloadShdFlvUrl + ", shdFlvSize=" + shdFlvSize + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", msg=" + msg + "]";
	}

}
