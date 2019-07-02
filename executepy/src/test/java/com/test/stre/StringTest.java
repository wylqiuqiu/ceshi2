package com.test.stre;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.junit.Test;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.longs.Long2IntAVLTreeMap;
import it.unimi.dsi.fastutil.longs.Long2IntSortedMap;

public class StringTest {

	@Test
	public void testArr() throws IOException {
		List<String> list = new ArrayList<String>();
		Properties prop = PropertiesLoaderUtils.loadAllProperties("ips.properties");
		String ips = prop.getProperty("ips");
		String[] ip = ips.split(",");
		for (int i = 0; i < ip.length; i++) {
			if (ip[i].equals(ip)) {

			}
			System.out.println(ip[i]);
		}
		list = Arrays.asList(ip);
		System.out.println(list.contains("127.0.0.1"));
	}

	@Test
	public void testa() {
		Long2IntSortedMap m = new Long2IntAVLTreeMap();
		IntList list = new IntArrayList();
		list.add(45);
		list.add(456);
		list.add(145);
		for (Integer i : list) {
			System.out.println(i);
		}
	}

	static List<Integer> list1 = new ArrayList<Integer>();
	public static void main(String[] args) {
		List<Integer> list2 = new ArrayList<Integer>();
		list1.add(0);
		list2.add(0);
		func(list1, list2);
		System.out.println("------"+list1 + "\r\n" + list2);
	}

	static void func(List<Integer> list1, List<Integer> list2) {
		list1 = new ArrayList<Integer>();
		list1.add(1);
		list2.add(1);
		list2 = new ArrayList<Integer>();
		list1.add(2);
		list2.add(2);
		System.out.println(list1 + "\r\n" + list2);
	}
	
	
	
	@Test
	public void gerateTime(){
		Date d = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String string = formate.format(d);
		String signaturenoce=UUID.randomUUID().toString();
		System.out.println(signaturenoce);
		System.out.println(string);
		
		
		
	}
	

}
