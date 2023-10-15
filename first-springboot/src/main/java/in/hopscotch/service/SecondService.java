package in.hopscotch.service;

import org.springframework.stereotype.Service;

import in.hopscotch.request.SampleRequestBody;

@Service
public class SecondService {
	
	
	public String processRequest(SampleRequestBody sampleRequestBody) {
		String msg = "Hi "+sampleRequestBody.getName() + " your id is "+  sampleRequestBody.getId();
		return msg;
	}
}
