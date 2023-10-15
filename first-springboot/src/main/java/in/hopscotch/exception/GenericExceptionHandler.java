package in.hopscotch.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.hopscotch.response.APIResponse;

@ControllerAdvice
public class GenericExceptionHandler {
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<APIResponse> handleThrowable() {
		APIResponse apiResponse = new APIResponse();
		HttpStatus statusCode = HttpStatus.OK;
		
		apiResponse.setSuccess(false);
		apiResponse.setCode(500);
		apiResponse.setErrorMsg("There is error in this API call");
		return new ResponseEntity(apiResponse, statusCode);
	}
	
	
	@ExceptionHandler(BusinessFlowException.class)
	public ResponseEntity<APIResponse> handleThrowable(BusinessFlowException swapnilCustomException) {
		APIResponse apiResponse = new APIResponse();
		HttpStatus statusCode = HttpStatus.OK;
		
		apiResponse.setSuccess(false);
		apiResponse.setCode(swapnilCustomException.getCode());
		apiResponse.setErrorMsg(swapnilCustomException.getMessage());
		return new ResponseEntity(apiResponse, statusCode);
	}

}
