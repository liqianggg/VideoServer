package com.netease.vcloud.upload.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.netease.vcloud.VcloudException;
import com.netease.vcloud.config.Config;
import com.netease.vcloud.upload.module.VideoTranscodeModule;
import com.netease.vcloud.upload.param.VideoTranscodeParam;
import com.netease.vcloud.util.HttpClientBuilder;
import com.netease.vcloud.util.HttpPostBuilder;

/**
 * 
 * <p>Company: NewNet</p>
 * @date       2016-7-19
 * @author zhangxufeng
 */
public class VideoTranscodeUtil {
	public static final Logger logger = Logger.getLogger(VideoTranscodeUtil.class);
	
	private VideoTranscodeParam videoTranscodeParam;

	/*public VideoTranscodeParam getVideoTranscodeParam() {
		return videoTranscodeParam;
	}

	public void setVideoTranscodeParam(VideoTranscodeParam videoTranscodeParam) {
		this.videoTranscodeParam = videoTranscodeParam;
	}*/
	

	public VideoTranscodeUtil() {
		super();
	}

	public VideoTranscodeUtil(VideoTranscodeParam videoTranscodeParam) {
		super();
		this.videoTranscodeParam = videoTranscodeParam;
	}
	
	
	public VideoTranscodeModule videoTranscode() throws IOException, VcloudException{
		/* 接口 */
		String url = Config.getMultiVideoTranscodingWithoutPresetURL();
		/* 设置请求的参数 */
		StringEntity params = new StringEntity(JSON.toJSONString(videoTranscodeParam),"UTF-8");			
		VideoTranscodeModule videoTranscodeModule = setVideoTrancode(url,params,VideoTranscodeModule.class);
		return videoTranscodeModule;
	}
	
	private <T> T setVideoTrancode(String url, StringEntity params, Class <T> clazz)throws IOException, VcloudException{
		HttpClient httpClient = HttpClientBuilder.getHttpClient();
		HttpPost httpPost = HttpPostBuilder.getHttpPost(url);		
		
		// 设置请求的参数		
		httpPost.setEntity(params);		
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		String stringBody = EntityUtils.toString(response.getEntity(), "utf-8");		
		//logger.info("[UploadUtil] : json stringBody" + stringBody);

		// 得到Json数据
		T object = null;
		try {
			 object =  JSON.parseObject(stringBody, clazz);			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[videoTranscodeModule] json parse exception : "	+ e + ",msg : " + e.getMessage());
			throw new VcloudException("[videoTranscodeModule] json parse exception", e);			
		}		

		return object;
	}
	
}
