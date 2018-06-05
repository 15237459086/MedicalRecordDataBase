package com.kurumi.pojo;

/**
 * 自定义请求响应结果
 * @author lyh
 *
 */
public class RespondResult {

	//请求成功
	public static String successCode = "1";
	
	//请求重复
	public static String repeatCode = "2";
	
	//请求失败
	public static String errorCode = "-1";
	
	private boolean isSuccess;
	
	private String stateCode;
	
	private String stateMessage;
	
	private Object data;

	public RespondResult(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public RespondResult(boolean isSuccess, Object data) {
		this.isSuccess = isSuccess;
		this.data = data;
	}

	public RespondResult(boolean isSuccess, String stateCode,
			String stateMessage, Object data) {
		this.isSuccess = isSuccess;
		this.stateCode = stateCode;
		this.stateMessage = stateMessage;
		this.data = data;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public String getStateCode() {
		return stateCode;
	}

	public String getStateMessage() {
		return stateMessage;
	}

	public Object getData() {
		return data;
	}

	
	
	
}
