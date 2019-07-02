package com.company.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.ssm.utils.ExecutePython;

import net.sf.json.JSONObject;

import com.company.ssm.utils.ContentValue;

@Controller
public class ExecuteHello {

	private final Logger logger = Logger.getLogger(ExecuteHello.class);

	private JSONObject messageTrue = ContentValue.getMessage(true);
	private JSONObject messageFalse = ContentValue.getMessage(false);

	@RequestMapping("/hello")
	@ResponseBody
	public String helloSay(HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		String host = request.getRemoteHost();
		System.out.println(ip + "  == " + host);
		logger.debug("----->");
		return "sucess";
	}

	@RequestMapping("/jatopy")
	@ResponseBody
	public JSONObject execute(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String ip = request.getRemoteHost();
		boolean flag = ContentValue.getIps(ip);
		if (!flag) {
			logger.debug("ip不符合规定直接返回");
			return messageFalse;
		}
		String path = request.getParameter("path");
		String theme_id = request.getParameter("theme_id");
		String temp_id = request.getParameter("temp_id");
		try {
			// theme_id temp_id
			ExecutePython.executeFucntion(path, theme_id, temp_id);
			return messageTrue;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常为"+e);
			return messageFalse;
		}
	}

}
