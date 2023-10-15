package in.hopscotch.exception;

public class BusinessFlowException extends Exception {
	
	private Integer code;
	
	public BusinessFlowException(String msg, Integer code) {
		super(msg);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	

}
