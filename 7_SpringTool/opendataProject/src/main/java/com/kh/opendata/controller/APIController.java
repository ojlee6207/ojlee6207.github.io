package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	
	public static final String serviceKey= "DVulpeocmyzMzFtlDOrAN2uGcUWKiO9jDB6XFmKgO3eYgnxzSairA9ZMwYjooZOscis5i60h4wj3yeXt94xMkw%3D%3D";
	
	@ResponseBody
	@RequestMapping(value="air.do", produces="application/json;charset=UTF-8")
	public String AirpollutionCheck (String location) throws IOException {
		/*
		 * URL 사용시 접근 법
		String url ="https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		// 요청시 전달 데이터 (Request Parameter)
		url += "?serviceKey=" + serviceKey;	
		url += "&returnType=json";
		url	+= "&sidoName="+URLEncoder.encode(location,"UTF-8");
		url += "&numOfRows=30";
		
		URL reqUrl = new URL(url);
		HttpURLConnection urlConn = (HttpURLConnection)reqUrl.openConnection();
		
		BufferedReader buf = new BufferedReader( new InputStreamReader( urlConn.getInputStream() ));
		
		String resText="";
		String line;
		while((line = buf.readLine()) != null) {
			resText += line;
		}
		
		buf.close();
		urlConn.disconnect();
		
		System.out.println(resText);
		
		return resText;
		*/
		
		// XML 방식 접근
		String url ="https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		// 요청시 전달 데이터 (Request Parameter)
		url += "?serviceKey=" + serviceKey;	
		url += "&returnType=xml";
		url	+= "&sidoName="+URLEncoder.encode(location,"UTF-8");
		url += "&numOfRows=30";
		
		URL reqUrl = new URL(url);
		HttpURLConnection urlConn = (HttpURLConnection)reqUrl.openConnection();
		
		BufferedReader buf = new BufferedReader( new InputStreamReader( urlConn.getInputStream() ));
		
		String resText="";
		String line;
		while((line = buf.readLine()) != null) {
			resText += line;
		}
		
		buf.close();
		urlConn.disconnect();
		
		System.out.println(resText);
		
		return resText;

	}
	
}