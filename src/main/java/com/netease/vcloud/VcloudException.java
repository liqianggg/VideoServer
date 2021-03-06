package com.netease.vcloud;


/**
* <p>Title: VcloudException</p>
* <p>Description: Vcloud自定义的异常类</p>
* <p>Company: NewNet</p>
* @date       2016-7-19
* @author zhangxufeng
*/
public class VcloudException extends Exception {

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	public VcloudException() {
		super();		
	}

	public VcloudException(String message, Throwable cause) {
		super(message, cause);		
	}

	public VcloudException(String message) {
		super(message);		
	}

	public VcloudException(Throwable cause) {
		super(cause);	
	}

	
}
