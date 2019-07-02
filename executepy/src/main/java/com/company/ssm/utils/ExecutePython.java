package com.company.ssm.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.log4j.Logger;


public class ExecutePython {

	
	private static final Logger logger = Logger.getLogger(ExecutePython.class);
	
	public static void executeFucntion(String path,String hotel_id,String room_id){
		if (null == path || path.equals("")) {
			path="/opt/www/html/cloud/public/apk/parse/service/parse/parse.py";
		}
		logger.debug(path+"--"+hotel_id+"  "+room_id);
		try {
			logger.debug("start-------------->");
			
			String[] args1 = new String[] {"python",path,hotel_id,room_id};
			Process pr = Runtime.getRuntime().exec(args1);

			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
//				这一块是执行过python后是否有返回    并且打印出来
				logger.debug("python return----->"+line);
			}
			in.close();
			pr.waitFor();
			logger.debug("end----------------->");
			logger.debug(new Date().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
