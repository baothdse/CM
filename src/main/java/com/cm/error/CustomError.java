package com.cm.error;

public class CustomError {
	  private String errorCode;
	  private String message;
  
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CustomError(String errorCode, String message) {
	super();
	this.errorCode = errorCode;
	this.message = message;
}

}
