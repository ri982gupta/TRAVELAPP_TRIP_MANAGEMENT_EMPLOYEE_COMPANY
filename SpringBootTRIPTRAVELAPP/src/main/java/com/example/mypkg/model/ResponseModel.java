package com.example.mypkg.model;

import com.example.mypkg.utils.Constants;

//public class ResponseModel {
//	
//	private String status = Constants.FAIL;
//	private Object data;
//	
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public Object getData() {
//		return data;
//	}
//	public void setData(Object data) {
//		this.data = data;
//	}
//
//}


public class ResponseModel {

    private boolean success;
    private String message;
    private String status = Constants.FAIL;
    private Object data;

    public ResponseModel() {
    }

    public ResponseModel(boolean success, String message, String status, Object data) {
        this.success = success;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}