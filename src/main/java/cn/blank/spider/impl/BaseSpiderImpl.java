package cn.blank.spider.impl;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import cn.blank.spider.BaseSpider;
import cn.blank.utils.RegulationUtils;
import cn.blank.utils.WebSiztUrlUtils;
/**
 * 原始爬虫类实现
 * @author Administrator
 *
 */
public class BaseSpiderImpl implements BaseSpider {
	
	/**
	 * 爬取数据
	 */
	public String crwal(String url) {
		
		CloseableHttpClient client = null;
		HttpGet get = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String content = null;
		
		try {
			//执行请求
			client = HttpClientBuilder.create().build();
			Map<String,String> rule = RegulationUtils.getRule(WebSiztUrlUtils.getHostAddr(url));
			get = new HttpGet(url);
			response = client.execute(get);
			entity = response.getEntity();
			//获取数据
			content = EntityUtils.toString(entity,rule.get("charset"));
			EntityUtils.consume(entity);
			
		} catch (Exception e) {
			throw new RuntimeException("爬取数据出错"+e.getMessage());
		}finally {
			if(client!=null){
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return content;
	}

}
