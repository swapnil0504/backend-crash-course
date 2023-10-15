package in.hopscotch.util;

import org.springframework.stereotype.Service;

import in.hopscotch.request.SampleRequestBody;


@Service
public class Helper {
	
	public String validateSampleRequestBody(SampleRequestBody sampleRequestBody) {
		if(sampleRequestBody.getId() == null || sampleRequestBody.getName() == null) {
			System.out.println("Maandatory fields are missing in request body");
			return "Maandatory fields are missing in request body";
		}
		return null;
	}

}
