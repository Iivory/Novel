package cn.blank.spider.impl;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import cn.blank.pojo.Chapter;
import cn.blank.spider.BaseChapterSpider;
import cn.blank.utils.RegulationUtils;
import cn.blank.utils.WebSiztUrlUtils;

@Component("chapterSpider")
public class ChapterSpiderImpl extends BaseSpiderImpl implements BaseChapterSpider {

	public Chapter getChapter(String url) {
		String content = crwal(url).replaceAll("&nbsp;", " ").replaceAll("<br />", "line").replaceAll("<br/>", "line");
		if(StringUtil.isBlank(content))throw new RuntimeException("获取章节失败");
		Document doc = Jsoup.parse(content);
		doc.setBaseUri(url);
		Map<String, String> rule = RegulationUtils.getRule(WebSiztUrlUtils.getHostAddr(url));
		Elements title = doc.select(rule.get("novel-chapter-title"));
		Chapter chapter = new Chapter();
		chapter.setTitle(title.text());
		Elements contents = doc.select(rule.get("novel-content"));
		chapter.setContent(contents.text().replace("line", "\n"));
		Elements prevous = doc.select(rule.get("novel-prevous"));
		chapter.setPrevous(prevous.first().absUrl("href"));
		Elements next = doc.select(rule.get("novel-next"));
		chapter.setNext(next.first().absUrl("href"));
		
		return chapter;
	}

}
