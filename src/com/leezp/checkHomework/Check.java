package com.leezp.checkHomework;

import java.io.File;
import java.util.List;

import com.leezp.checkHomework.bean.People;
import com.leezp.checkHomework.dao.GetTestInfo;
import com.leezp.checkHomework.dao.JsonResolve;

public class Check {

	public static void main(String[] args) {
		List<People> peoples = null;
		GetTestInfo getTestInfo = new GetTestInfo();
		JsonResolve jsonResolve = new JsonResolve();
		
		//获取配置文件中的json字符串
		String data = getTestInfo.getTestFileName();
		
		System.out.println(data);
		
		if(data != null) {
			//将json字符串解析成对象
			peoples = jsonResolve.getTestInfo(data);
			
			
			if(peoples != null) {
				StringBuilder testInfo = new StringBuilder();
				testInfo.append("\r\n"+People.testName+"未交成员名单：\r\n");
				//用于判断是否为第一个未交成员，如果是，则不需再该名字前加“、”，否则则需在该名字前加“、”
				boolean first = true;
				for(People people:peoples) {
					File file = new File(People.path+people.toString());
					if (!file.exists()) {
						if (first) {
							first = false;
							testInfo.append(people.getPersonName());
						} else {
							testInfo.append("、"+people.getPersonName());
						}
					}
					//file.isDirectory() 判断该文件是否是文件夹
				}
				getTestInfo.writeUnpaidTest(testInfo.toString());
			}
		}
	}
	
}
