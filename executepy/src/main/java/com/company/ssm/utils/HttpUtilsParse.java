package com.company.ssm.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public class HttpUtilsParse {
	
	
	public static String parseToStr(HttpServletRequest request) {
		BufferedReader rd;
		String line = null;
		final StringBuffer buffer = new StringBuffer();
		try {
			rd = new BufferedReader(new InputStreamReader(request.getInputStream()));
			while ((line = rd.readLine()) != null) {
				buffer.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

}
