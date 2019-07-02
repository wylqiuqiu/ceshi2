package com.company.ssm.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import net.sf.json.JSONObject;

public class ContentValue {
	
	private static final Logger logger = Logger.getLogger(ContentValue.class);

	public static boolean getIps(String ip) {
		List<String> list = new ArrayList<String>();
		String[] ipsStr=null;
		try {
			Properties prop = PropertiesLoaderUtils.loadAllProperties("ips.properties");
			 ipsStr = prop.getProperty("ips").split(",");
			 list=Arrays.asList(ipsStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (list.contains(ip)) {
			logger.debug("得到的ip"+ip+"符合规定");
			return true;
		}
		logger.debug("得到的ip"+ip+"不符合规定");
		return false;
	}

	public static JSONObject getMessage(boolean b) {
		JSONObject obj = new JSONObject();
		if (b) {
			obj.put("status", 0);
			obj.put("message", "success");
		} else {
			obj.put("status", 1);
			obj.put("message", "error");
		}
		return obj;
	}

}
