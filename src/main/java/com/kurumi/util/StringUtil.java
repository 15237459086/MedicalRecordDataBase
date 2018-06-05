package com.kurumi.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * String工具类
 *
 * 记录一些常用的针对字符串的通用处理函数
 *
 */
public class StringUtil extends StringUtils {

  public static String meaningStr(String str){
	  if(str == null){
		  return null;
	  }else{
		  if(str.trim().length() >0){
			  return str.trim();
		  }
		  return null;
	  }
  }
  
  /**
	 * 判断List集合是否为空
	 * 
	 * @param list
	 *            集合数据
	 * @return true：为空 false：不为空
	 */
	public static <T> boolean isNullOfList(List<T> list) {
		return list==null || list.isEmpty();
	}
  

}
