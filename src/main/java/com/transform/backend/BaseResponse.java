package com.transform.backend;

public class BaseResponse{
	 private String status;
	 private Integer code;
	
	public String getStatus() {
		return status;
	}
	
	public void setSatus(String status) {
		this.status = status;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
}