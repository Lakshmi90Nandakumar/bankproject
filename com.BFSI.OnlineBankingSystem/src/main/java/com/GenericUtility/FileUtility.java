package com.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	public String readDataFromPropertyFile(String key) throws Throwable {

			FileInputStream fis = new FileInputStream(IpathConstant.FILEPATH);
			Properties p = new Properties();
			p.load(fis);
			String value = p.getProperty(key);
			return value;
			}

}
