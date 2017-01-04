package com.netease.vcloud.upload.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.upload.param.GetUploadHostParam;
import com.netease.vcloud.upload.param.InitUploadVideoParam;
import com.netease.vcloud.upload.param.QueryOffsetParam;
import com.netease.vcloud.upload.param.QueryVideoIDorWatermarkIDParam;
import com.netease.vcloud.upload.param.UploadVideoFragmentParam;
import com.netease.vcloud.util.FileUtil;


/**
* <p>Title: QueryOffsetDemo</p>
* <p>Description: 利用断点续传查询offset的Demo</p>
* <p>Company: newNet</p>
* @date       2016-7-21
* @author zhangxufeng
*/
public class QueryOffsetDemo {

	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(QueryOffsetDemo.class);	
	
	public static void main(String[] args) throws VcloudException, IOException {
		 /* 输入个人信息 */
		 /* 开发者平台分配的appkey 和 appSecret */
		 String appKey = "...";		  // 此处需要用户填写自己的appKey
	     String appSecret = "...";    // 此处需要用户填写自己的appSecret    	    
	     
	     Credentials credentials;
	     credentials = new BasicCredentials(appKey, appSecret);
	     VcloudClient vclient = new VcloudClient(credentials);
	     
	    
	     /*请输入上传文件路径*/
	     String filePath = "e:\\1.mp4";
	     
	     if(!FileUtil.doesFileExist(filePath)){
	    	 logger.error("[UploadVideoDemo] the path is wrong");
	    	 return ;
	     }
	     
	     Map<String, Object> initParamMap = new HashMap<String, Object>();

	     /*输入上传文件的相关信息 */
	     /* 上传文件的原始名称（包含后缀名） 此参数必填*/
	     initParamMap.put("originFileName", FileUtil.getFileName(filePath));

	     /* 用户命名的上传文件名称  此参数非必填*/
	     initParamMap.put("userFileName", "for_love.mp4");

	     /* 视频所属的类别ID（不填写为默认分类）此参数非必填*/
	     initParamMap.put("typeId", new Long(1056));

	     /* 频所需转码模板ID（不填写为默认模板） 此参数非必填*/
	     //initParamMap.put("presetId", new Long(30599));

	     /* 转码成功后回调客户端的URL地址（需标准http格式）  此参数非必填*/
	     initParamMap.put("callbackUrl", null);

	     /* 上传视频的描述信息  此参数非必填*/
	     initParamMap.put("description", "love.mp4");
	     
	     /* 上传视频的视频水印Id 此参数非必填*/
	     initParamMap.put("watermarkId", null);	   
	     
	     /*视频上传初始化*/
	  
	     /*视频上传初始化返回结果的封装类*/
	     InitUploadVideoParam initUploadVideoParam = vclient.initUploadVideo(initParamMap);
	     
	     if(initUploadVideoParam.getCode() != 200){
	    	 logger.error("[UploadVideoDemo] fail to init upload params. " + initUploadVideoParam.getMsg());
	    	 return ;
	     }
	     /*获取上传加速节点地址*/	   
	     /*获取上传加速节点地址返回结果的封装类*/
	     GetUploadHostParam getUploadHostParam = vclient.getUploadHost(initUploadVideoParam.getRet().getBucket());
	     
	     if(null == getUploadHostParam){
	    	 logger.error("[UploadVideoDemo] fail to get uploadHost");
	    	 return ; 
	     }
	     /*分片上传视频*/	    
	     
	     /*当前分片在整个对象中的起始偏移量    此参数必填*/
	     Long offset = new Long(0);
	     /*上传上下文         此参数必填*/
		 String context = null;
		 /*上传文件的输出流        此参数必填*/
		 InputStream in = null;
		 
		 try {			 
			 in = FileUtil.getFileInputStream(filePath);
			 /*上传文件剩余大小*/
			 Long remainderSize = FileUtil.getFileLength(filePath);		 
			 /*分片上传视频*/
			 while(remainderSize > 0){		
				
				 UploadVideoFragmentParam uploadVideoParam = vclient.uploadVideoFragment(initUploadVideoParam, getUploadHostParam, offset, context, in, remainderSize);
//				 UploadVideoFragmentParam uploadVideoParam = vclient.uploadVideoFragment(initUploadVideoParam.getRet().getBucket(), getUploadHostParam.getUpload().get(0), initUploadVideoParam.getRet().getObject(),
//						 offset, context, in, remainderSize, initUploadVideoParam.getRet().getxNosToken());
				 context = uploadVideoParam.getContext();			
				 
				 //QueryOffsetParam queryOffsetParam  = vclient.getPartOffset(initUploadVideoParam, getUploadHostParam, uploadVideoParam);
				 QueryOffsetParam queryOffsetParam  = vclient.getPartOffset(getUploadHostParam.getUpload().get(0), initUploadVideoParam.getRet().getBucket(), initUploadVideoParam.getRet().getObject(), context, initUploadVideoParam.getRet().getxNosToken());

				 // 使用断点续传查询offset，文件全部上传之后，再通过getPartOffset()是无法查询到offset的，即无法通过 remainderSize  = FileUtil.getFileLength(filePath) - offset 将remainderSize设置为0
				 
				 offset = queryOffsetParam.getOffset();
				 if(null != offset){
					 remainderSize  = FileUtil.getFileLength(filePath) - offset;
				 }else{
					 remainderSize = new Long(0);
				 }				
			 }
			 
			 /* 查询上传视屏的vid*/
			 List<String> objectNamesList = new ArrayList<String>();
			 objectNamesList.add(initUploadVideoParam.getRet().getObject());			
			
			 /*查询上传视屏返回结果的封装类*/
			 QueryVideoIDorWatermarkIDParam queryVideoIDParam = vclient.queryVideoID(objectNamesList);
			 logger.info("[UploadVideoDemo] video id :" + queryVideoIDParam.getRet().getList().get(0).getVid());

		 } catch (Exception e) {
			 if(null != in){
				 try {
					in.close();
				} catch (IOException e1) {
					 logger.error("[UploadVideoDemo] fail to close inputStream " + e1.getMessage());					
				}
			 }
		 }
	}
}
