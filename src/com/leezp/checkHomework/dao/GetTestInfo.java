package com.leezp.checkHomework.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.leezp.checkHomework.bean.People;

public class GetTestInfo {

	public GetTestInfo() { }
	
	public String getTestFileName() {
		File directory = new File("");
		//获取配置文件的路径
		String path = directory.getAbsolutePath()+"\\res\\test_source.txt";
		try {
			//将编码设置为UTF-8，通过该编码形式进行读取文件
			String encoding="UTF-8";
			File file = new File(path);
			//判断配置文件是否存在
			if (file.exists() && file.isFile()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
				BufferedReader bReader = new BufferedReader(read);
				String line = null;
				StringBuilder testInfo = new StringBuilder();
				//通过StringBuilder来获取配置文件中的内容
				while((line = bReader.readLine()) != null) {
					line = line.trim();
					testInfo.append(line);
				}
				bReader.close();
				return testInfo.toString();
			} else {
				System.err.println("配置文件不存在！");
			}
		} catch (Exception e) {
			System.err.println("配置文件的格式有问题，无法读取其中内容！");
			e.printStackTrace();
		}
		return null;
	}
	
	//将读取的未交人员名单写入指定的目录文件中
	public boolean writeUnpaidTest(String info) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(People.savePath, true)));
			out.write(info);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
