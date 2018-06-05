package cn.blank.dao.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.blank.pojo.Novel;
import cn.blank.pojo.User;

public interface UserMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int insertSelective(User user);
    
    void batchInsert(List<Novel> novels);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);
}