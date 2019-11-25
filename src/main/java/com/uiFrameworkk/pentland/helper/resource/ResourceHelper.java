package com.uiFrameworkk.pentland.helper.resource;

public class ResourceHelper {
	
	public static String getResourcePath(String path) {
		String basePath = System.getProperty("user.dir");
		System.out.println(basePath + path);
		return basePath + path;
		
	}
//	WHen we print the path it give us the whole path - 
//	our project location ---
//	public static void main(String[] args) {
//		String path = ResourceHelper.getResourcePath("src\\main\\resources\\configfile\\log4j.properties");
//		System.out.println(path);
//	}

}
