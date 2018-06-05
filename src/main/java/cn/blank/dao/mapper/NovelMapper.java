package cn.blank.dao.mapper;

import cn.blank.pojo.Novel;
import java.util.List;


public interface NovelMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Novel record);

    int insertSelective(Novel record);

    Novel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Novel record);

    int updateByPrimaryKey(Novel record);
    
    void batchInsert(List<Novel> novels);

	int selectCountByKeywords(String keywords);

	List<Novel> getNovelsByKeywords(String keywords, int start, int end);
}