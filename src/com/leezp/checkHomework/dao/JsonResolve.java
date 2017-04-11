package com.leezp.checkHomework.dao;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.leezp.checkHomework.bean.People;

public class JsonResolve {

	public JsonResolve() {	}
	
	public List<People> getTestInfo(String testInfo) {
		
		List<People> peoples = new ArrayList<People>();
		
		try {
			//将Json字符串解析成Json对象
			 JSONObject json = JSONObject.fromObject(testInfo);
			 
			 String testName = json.getString("TestName");
			 People.testName = testName;
			 String path = json.getString("TestPath");
			 People.path = path;
			 String savePath = json.getString("SaveUnPaid");
			 People.savePath = savePath;
			 
			 JSONArray persons = json.getJSONArray("Person");
			 for(int i=0;i<persons.size();++i) {
				 JSONObject person = persons.getJSONObject(i);
				 People people = new People();
				 people.setPersonId(person.getString("PersonId"));
				 people.setPersonName(person.getString("PersonName"));
				 peoples.add(people);
			 }
			 return peoples;
		} catch (JSONException e) {
			System.err.println("JSON数据无法解析！");
			e.printStackTrace();
		}
		return null;
	}
}
