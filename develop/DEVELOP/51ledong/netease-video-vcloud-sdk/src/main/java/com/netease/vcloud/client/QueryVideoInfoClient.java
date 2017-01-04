package com.netease.vcloud.client;

import java.util.Map;

import org.apache.log4j.Logger;

import com.netease.vcloud.ClientConfiguration;
import com.netease.vcloud.VcloudException;
import com.netease.vcloud.auth.BasicCredentials;
import com.netease.vcloud.auth.Credentials;
import com.netease.vcloud.config.Common;
import com.netease.vcloud.config.Config;
import com.netease.vcloud.upload.module.VideoInfoRetModule;
import com.netease.vcloud.upload.service.QueryVideoInfoService;
import com.netease.vcloud.upload.service.impl.QueryVideoInfoServiceImpl;

/**
 * <p>
 * Title: QueryVideoInfoClient
 * </p>
 * <p>
 * Description: 提供给用户进行视频信息操作的视频云客户端
 * </p>
 * <p>
 * Company: newNet
 * </p>
 * 
 * @date 2016-7-19
 * @author zhangxufeng
 *
 */
public class QueryVideoInfoClient {

	public static final Logger logger = Logger.getLogger(QueryVideoInfoClient.class);

	String appKey = Common.appKey;
	String appSecret = Common.appSecret;

	/** 客户端配置类 */
	private ClientConfiguration clientConfiguration;

	private Credentials credentials;

	public QueryVideoInfoClient() {
		this.clientConfiguration = new ClientConfiguration();
		credentials = new BasicCredentials(appKey, appSecret);
		init();
	}

	/**
	 * 
	 * <p>
	 * Title: init
	 * </p>
	 * <p>
	 * Description: 利用访问服务的凭据类和客户端配置类初始化配置信息
	 * </p>
	 */
	public void init() {
		Config.setConnectionTimeout(clientConfiguration.getConnectionTimeout());
		Config.setSocketTimeout(clientConfiguration.getSocketTimeout());
		Config.setAppKey(credentials.getAppKey());
		Config.setAppSecret(credentials.getAppSecret());
	}

	public VideoInfoRetModule queryVideoInfo(Map<String, Object> initParamMap) throws VcloudException {
		QueryVideoInfoService queryVideoInfoService = new QueryVideoInfoServiceImpl();
		VideoInfoRetModule videoInfoRetModule = queryVideoInfoService.queryVideoInfo(initParamMap);
		return videoInfoRetModule;
	}
}
