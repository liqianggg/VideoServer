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
import com.netease.vcloud.upload.module.VideoInfoRetModule;
import com.netease.vcloud.upload.param.QueryVideoInfoParam;
import com.netease.vcloud.util.HttpClientBuilder;
import com.netease.vcloud.util.HttpPostBuilder;

/**
 * 
 * <p>Company: NewNet</p>
 * @date       2016-7-19
 * @author zhangxufeng
 */
public class QueryVideoInfoUtil {
	public static final Logger logger = Logger.getLogger(QueryVideoInfoUtil.class);
	
	private QueryVideoInfoParam queryVideoInfoParam;
	
	
	public QueryVideoInfoUtil(QueryVideoInfoParam queryVideoInfoParam) {
		super();
		this.queryVideoInfoParam = queryVideoInfoParam;
	}

	/*private int vid;

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public QueryVideoInfoUtil(int vid) {
		this.vid = vid;
	}*/
	
	
	public QueryVideoInfoParam getQueryVideoInfoParam() {
		return queryVideoInfoParam;
	}

	public void setQueryVideoInfoParam(QueryVideoInfoParam queryVideoInfoParam) {
		this.queryVideoInfoParam = queryVideoInfoParam;
	}

	public VideoInfoRetModule queryVideoInfo() throws IOException, VcloudException{
		/* 接口 */
		String url = Config.getGetSingleVideoURL();
		/* 设置请求的参数 */
		StringEntity params = new StringEntity(JSON.toJSONString(queryVideoInfoParam),"UTF-8");			
		VideoInfoRetModule videoInfoRetModule = getVideoInfo(url,params,VideoInfoRetModule.class);
		return videoInfoRetModule;
	}
	
	private <T> T getVideoInfo(String url, StringEntity params, Class <T> clazz)throws IOException, VcloudException{
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
			logger.error("[QueryVideoInfoUtil] json parse exception : "	+ e + ",msg : " + e.getMessage());
			throw new VcloudException("[QueryVideoInfoUtil] json parse exception", e);			
		}		

		return object;
	}
}
