package cn.blank.utils;

import java.awt.geom.GeneralPath;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 获取主机地址ַ
 * @author Administrator
 *
 */
public class WebSiztUrlUtils {

	public static String getHostAddr(String url){
		//Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?(\\.(com|cn|net|org|biz|info|cc|tv|tw)|so)+",Pattern.CASE_INSENSITIVE);  
		Pattern p =  Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");
		Matcher matcher = p.matcher(url);  
		matcher.find();  
		return matcher.group();
	}
	

}
