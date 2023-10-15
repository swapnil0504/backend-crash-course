package in.hopscotch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FirstController  {
	
	
	@PostMapping("/msg")
	public String showPostMsg(@RequestBody String requestBody ) {
		System.out.println("Request body :"+ requestBody);
		return "Hi "+requestBody+ " from Post request";
	}
	
	@GetMapping
	public String showMsg() {
		System.out.println("Hi How are you  ?, I am fine thank you.");
		return "Hi How are you  ?";
		/*
		 * 
		 * 
		 * server.getData();
		 * 
		 * reo.getDate();
		 * 
		 * 
		 * 
		 * eventpush.push(JSON, CUSUMERER)
		 * 
		 * eventpush.push(JSON, CUSUMERER)
		 */
	}
	
	
	@GetMapping("/hello")
	public String showMsg1() {
		System.out.println("Hi How are you  ?");
		return "Hello How are you  ?";
	}

}
