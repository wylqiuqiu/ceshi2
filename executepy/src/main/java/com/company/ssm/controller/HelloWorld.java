package com.company.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
	@RequestMapping("/say")
	@ResponseBody
	public String hello() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello world";
	}
	
	
	@RequestMapping("/tomain")
	public String toMain(){
		System.out.println("tomain------>");
		return "main";
	}
	
	@RequestMapping("")
	public void getJson(){
		
		
	}

	

}
