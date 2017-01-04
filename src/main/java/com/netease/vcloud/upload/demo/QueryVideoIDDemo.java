package com.netease.vcloud.upload.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.client.VcloudClient;
import com.netease.vcloud.upload.param.QueryVideoIDorWatermarkIDParam;

/**
* <p>Title: QueryVideoIDDemo</p>
* <p>Description: 上传完成后查询视频主ID的Demo</p>
* <p>Company: newNet</p>
* @date       2016-7-21
* @author zhangxufeng
*/
public class QueryVideoIDDemo {

	
	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(QueryVideoIDDemo.class);

	public static void main(String[] args) {

		/* 输入个人信息 */
		/* 开发者平台分配的appkey 和 appSecret */
		 String appKey = "...";		  // 此处需要用户填写自己的appKey
	     String appSecret = "...";    // 此处需要用户填写自己的appSecret    	    

		Credentials credentials;
		credentials = new BasicCredentials(appKey, appSecret);
		VcloudClient vclient = new VcloudClient(credentials);

		/* 请输入 查询文件的对象名     参数必填*/
		List<String> objectNamesList = new ArrayList<String>();
		objectNamesList.add("33cf71b1-86ac-4555-a071-d70db07b9685.mp4");
		objectNamesList.add("14e36114-13f8-48f4-b7a2-90b1b76c531c.mp4");

		try{
			/*上传完成后查询视频主ID返回结果的封装类*/
			QueryVideoIDorWatermarkIDParam queryVideoIDParam = vclient.queryVideoID(objectNamesList);

			if(queryVideoIDParam.getCode() == 200){
				logger.info("[InitUploadVideoDemo] query videoID successfully. " + queryVideoIDParam.getRet().getList().toString());
			}else{
				logger.info("[InitUploadVideoDemo] fail to query videoID. " + "return code " + queryVideoIDParam.getCode() + " return message " + queryVideoIDParam.getMsg());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}	

	}
}
