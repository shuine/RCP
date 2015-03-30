package com.crp.app.utils;

/**
 * 数据测试类
 * @author shihx1
 *
 */
public class DateTestUtils {
	
	private static DateTestUtils dateTestUtils;
	DateTestUtils(){}
	
	public static DateTestUtils getInstance(){
		if(dateTestUtils==null)
			dateTestUtils = new DateTestUtils();
		return dateTestUtils;
	}
	
}
