package com.utils;
/**
 * 状�?�工具类״̬
 * @author 99266
 *
 */
public class ReturnResult {
	private int status;
	private String message;
	/**
	 * 返回失败状�?�״�?
	 * @param result
	 * @return
	 */
	public ReturnResult getFail(Object result) {
		this.status = -1;
		this.message = result.toString();
		return this;
	}
	/**
	 * 返回成功状�?�״�?
	 * @param result
	 * @return
	 */
	public ReturnResult getSuccess(Object result) {
		this.status = 1;
		this.message = result.toString();
		return this;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
