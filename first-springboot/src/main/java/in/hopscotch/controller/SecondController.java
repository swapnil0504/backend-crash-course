package in.hopscotch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.hopscotch.exception.BusinessFlowException;
import in.hopscotch.request.SampleRequestBody;
import in.hopscotch.response.APIResponse;
import in.hopscotch.service.SecondService;
import in.hopscotch.util.ErrorCodeConstant;
import in.hopscotch.util.Helper;

@RestController
public class SecondController {
	
	/*
	 * Helper helper = new Helper();
	 */
	@Autowired
	Helper helper;
	
	
	/*
	 * SecondService secondService = new SecondService();
	 */
	@Autowired
	SecondService secondService;
	
	
	
	@PostMapping("/accept-json")
	public ResponseEntity<APIResponse> acceptJSON(@RequestBody SampleRequestBody sampleRequestBody ) throws BusinessFlowException {
		if(sampleRequestBody.getId()==null) {
			//throw new BusinessFlowException("Id is mandaroty", ErrorCodeConstant.MANDATORY_ERROR_CODE);
			throw new BusinessFlowException("Required data is not populated", ErrorCodeConstant.CODE_2);
		}
		APIResponse apiResponse = new APIResponse();
		HttpStatus statusCode = HttpStatus.OK;
		String msg = helper.validateSampleRequestBody(sampleRequestBody);
		if(msg == null) {
			//throw new RuntimeException("New Runtime Exceptin");
			msg = secondService.processRequest(sampleRequestBody);
		} else {
			statusCode = HttpStatus.BAD_REQUEST;
		}
		
		//apiResponse.setMsg(msg);
		apiResponse.setSuccess(true);
		apiResponse.setCode(200);
		Map<String, String> data = new HashMap<String, String>();
		data.put("msg", msg);
		apiResponse.setData(data);
		
		return new ResponseEntity(apiResponse, statusCode);
	}

}
