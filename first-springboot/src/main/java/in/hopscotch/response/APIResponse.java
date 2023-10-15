package in.hopscotch.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APIResponse {
	
	
	private boolean success;
	
	private Integer code;
	
	private String msg;
	
	@JsonProperty("error_msg")
	private String errorMsg;
	
	private Object data;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	

}
