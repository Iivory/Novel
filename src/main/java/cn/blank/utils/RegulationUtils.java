package cn.blank.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.spi.XmlReader;

import org.apache.log4j.lf5.util.Resource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 匹配规则获取
 * @author Administrator
 *
 */
public class RegulationUtils {
	
	private static final Map<String,Map<String,String>> webSitesMap = new HashMap<String,Map<String,String>>();

	private RegulationUtils(){}
	
	static{
		init();
	}

	private static void init() {
		SAXReader reader = new SAXReader();
		try {
			String path = RegulationUtils.class.getResource("/rule/regulation.xml").getPath();
			Document doc = reader.read(new File(path));
			Element root = doc.getRootElement();
			List<Element> eles = root.elements("website");
			String key = null;
			for(Element ele:eles){
				List<Element> data = ele.elements();
				Map<String,String> rule = new HashMap<String, String>();
					for(Element el:data){
						String name = el.getName();
						String value = el.getText().trim();
						if(name=="uri"){
							key =value;
						}
						rule.put(name, value);
					}
					webSitesMap.put(key, rule);		
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Map<String,String> getRule(String uri){
		return webSitesMap.get(uri);
	}
	
}
