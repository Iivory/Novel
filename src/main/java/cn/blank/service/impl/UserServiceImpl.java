package cn.blank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blank.dao.mapper.UserMapper;
import cn.blank.pojo.User;
import cn.blank.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserMapper userMapper;

	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(1);
	}

}
