package com.netease.vcloud.upload.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.config.Config;
import com.netease.vcloud.upload.param.DeleteVideoParam;
import com.netease.vcloud.upload.param.GetUploadHostParam;
import com.netease.vcloud.upload.param.InitUploadVideoParam;
import com.netease.vcloud.upload.param.QueryVideoIDorWatermarkIDParam;
import com.netease.vcloud.upload.param.QueryVideoInfoParam;
import com.netease.vcloud.upload.param.UploadVideoFragmentParam;
import com.netease.vcloud.upload.service.GetUploadHostService;
import com.netease.vcloud.upload.service.InitUploadVideoService;
import com.netease.vcloud.upload.service.QueryVideoIDorWatermarkIDService;
import com.netease.vcloud.upload.service.UploadVideoFragmentService;
import com.netease.vcloud.upload.service.UploadVideoService;
import com.netease.vcloud.upload.util.DeleteVideoUtil;
import com.netease.vcloud.util.FileUtil;



/**
* <p>Title: UploadVideoServiceImpl</p>
* <p>Description: 简单的视频上传的实现类</p>
* <p>Company: NewNet</p>
* @date       2016-7-19
* @author zhangxufeng
*/
public class UploadVideoServiceImpl implements UploadVideoService {
	
	/** 日志实例*/
	public static final Logger logger = Logger.getLogger(UploadVideoServiceImpl.class);	
	
	/* 
	* <p>Title: uploadVideo</p>
	* <p>Description: </p>
	* @param filePath
	* @param initParamMap
	* @return
	* @throws VcloudException
	* @throws IOException
	* @see com.netease.vcloud.upload.util.service.impl.UploadVideoService#uploadVideo(java.lang.String, java.util.Map)
	*/
	public QueryVideoIDorWatermarkIDParam uploadVideo(String filePath, Map<String, Object> initParamMap) throws VcloudException, IOException{


		if(FileUtil.doesFileExist(filePath)){

			if(!checkInitParamMap(initParamMap)){			
				logger.info("[UploadVideoService] the init param originFileName is lost.");
				throw new VcloudException("[UploadVideoService] the init param originFileName is lost.");
			}
			/*视频上传初始化*/
			InitUploadVideoService initUploadVideoService = new InitUploadVideoServiceImpl();
			/*视频上传初始化返回结果的封装类*/
			InitUploadVideoParam initUploadVideoParam = initUploadVideoService.initUploadVideo(initParamMap);


			if(initUploadVideoParam.getCode() != 200){
				logger.info("[UploadVideoService] fail to init upload params. " + "return code " + initUploadVideoParam.getCode() + " return message " + initUploadVideoParam.getMsg());
				throw new VcloudException("[UploadVideoService] fail to init upload params. " + "return code " + initUploadVideoParam.getCode() + " return message " + initUploadVideoParam.getMsg());
			}
			/*获取上传加速节点地址*/
		     GetUploadHostService getUploadHostService = new GetUploadHostServiceImpl();
		     /*获取上传加速节点地址返回结果的封装类*/
		     GetUploadHostParam getUploadHostParam = getUploadHostService.getUploadHost(initUploadVideoParam.getRet().getBucket());
		     
		     if(null == getUploadHostParam){
		    	 logger.info("[UploadVideoService] fail to get uploadHost.");
		    	 throw new VcloudException("[UploadVideoService] fail to get uploadHost.");
		     }
		     /*分片上传视频*/
		     UploadVideoFragmentService uploadVideoService = new UploadVideoFragmentServiceImpl();
		     
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
					 
					 UploadVideoFragmentParam uploadVideoParam = uploadVideoService.uploadVideo(initUploadVideoParam, getUploadHostParam, offset, context, in, remainderSize);				 
					 context = uploadVideoParam.getContext();
					 offset = uploadVideoParam.getOffset();
					 remainderSize  = FileUtil.getFileLength(filePath) - offset;
				 }
				 
				
				 
				 /* 查询上传视屏的vid*/
				 List<String> objectNamesList = new ArrayList<String>();
				 objectNamesList.add(initUploadVideoParam.getRet().getObject());			
				 QueryVideoIDorWatermarkIDService queryVideoIDService = new QueryVideoIDorWatermarkIDServiceImpl();
				 /*查询上传视屏返回结果的封装类*/
				 QueryVideoIDorWatermarkIDParam queryVideoIDParam = queryVideoIDService.queryVideoID(objectNamesList);
				// logger.info("[UploadDemo] upload video successfully and the vid is " + queryVideoIDParam.getRet().getList().get(0).getVid());
				 return queryVideoIDParam;

			 } catch (Exception e) {
				 if(null != in){
					 try {
						in.close();
					} catch (IOException e1) {
						 //logger.error("[UploadDemo] fail to close inputStream " + e1.getMessage());
						 throw new VcloudException(e1);
					}
				 }
			 }
		}
		return null;
	}
	
	/**
	 * 
	* <p>Title: checkInitParamMap</p>
	* <p>Description: 判断视频初始化参数集合中必填参数是否缺失</p>
	* @param initParamMap  视频初始化参数集合
	* @return 如果必填参数缺失，则返回false, 否则返回true
	 */
	private  boolean checkInitParamMap(Map<String, Object> initParamMap){
		String originFileName =  (String) initParamMap.get("originFileName");
		if(null == originFileName || "".equals(originFileName.trim())){
			return false;
		}
		return true;
	}

	@Override
	public String deleteVideo(Map<String, Object> initParamMap) throws VcloudException, IOException {
		// TODO Auto-generated method stub
		String urlTranscode = Config.getDeleteSingleTransCodeVideoURL(); // 删除单个转码后的视频
		String url = Config.getDeleteSingleVideoURL(); // 删除单个转码后的视频
		DeleteVideoParam deleteVideoParam = new DeleteVideoParam(initParamMap);
		DeleteVideoUtil deleteVideoUtil = new DeleteVideoUtil(deleteVideoParam);
		deleteVideoUtil.deleteTranscodeVideo(urlTranscode);
		QueryVideoInfoParam queryVideoInfoParam = new QueryVideoInfoParam(initParamMap);
		deleteVideoUtil.deleteVideo(url, queryVideoInfoParam);
		return "0";
	}

}
