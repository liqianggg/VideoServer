package com.netease.vcloud.upload.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.netease.vcloud.VcloudException;
import com.netease.vcloud.config.Config;
import com.netease.vcloud.upload.param.DeleteVideoParam;
import com.netease.vcloud.upload.param.QueryVideoInfoParam;
import com.netease.vcloud.util.HttpClientBuilder;
import com.netease.vcloud.util.HttpPostBuilder;

public class DeleteVideoUtil {

	private DeleteVideoParam deleteVideoParam;

	
	
	public DeleteVideoUtil() {
		super();
	}

	public DeleteVideoUtil(DeleteVideoParam deleteVideoParam) {
		super();
		this.deleteVideoParam = deleteVideoParam;
	}

	public DeleteVideoParam getDeleteVideoParam() {
		return deleteVideoParam;
	}

	public void setDeleteVideoParam(DeleteVideoParam deleteVideoParam) {
		this.deleteVideoParam = deleteVideoParam;
	}
	
	
	public String deleteTranscodeVideo(String url) throws IOException, VcloudException{
		
		/* 接口 */
		//String url = Config.getDeleteSingleTransCodeVideoURL();
		/* 设置请求的参数 */
		StringEntity params = new StringEntity(JSON.toJSONString(deleteVideoParam),"UTF-8");			
		
		return deleteVideo(url,params);
	}
	
public String deleteVideo(String url,QueryVideoInfoParam queryVideoInfoParam) throws IOException, VcloudException{
		
		/* 接口 */
		//String url = Config.getDeleteSingleTransCodeVideoURL();
		/* 设置请求的参数 */
		StringEntity params = new StringEntity(JSON.toJSONString(queryVideoInfoParam),"UTF-8");			
		
		return deleteVideo(url,params);
	}
	
	public String deleteVideo(String url, StringEntity params) throws VcloudException, IOException{
		
		
		HttpClient httpClient = HttpClientBuilder.getHttpClient();
		HttpPost httpPost = HttpPostBuilder.getHttpPost(url);		
		
		// 设置请求的参数		
		httpPost.setEntity(params);		
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		String stringBody = EntityUtils.toString(response.getEntity(), "utf-8");		
		
		return stringBody;
	}
}
