package com.sise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.dao.UserMapper;
import com.sise.entity.User;
import com.sise.entity.UserExample;
import com.sise.entity.UserExample.Criteria;
import com.sise.service.UserService;

/**
	 * @author:lxrong
	 * @description:实现UserService方法
	 * @createTime:2018年12月28日 下午2:46:32
*/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	public User getUserByUid(String uid) {
		UserExample userExample = new UserExample();
		Criteria userCriteria = userExample.createCriteria();
		userCriteria.andUIdEqualTo(uid);
		return userMapper.selectByExample(userExample).get(0);
	}

	public List<User> getUserAll() {
		UserExample userExample = new UserExample();
		Criteria userCriteria = userExample.createCriteria();
		userCriteria.andUIdIsNotNull(); // where u_id is not null
		return userMapper.selectByExample(userExample);
	}

	public void insertUser(User user) {
		userMapper.insert(user);
	}

	public void updataUser(User user) {
		UserExample userExample = new UserExample();
		Criteria userCriteria = userExample.createCriteria();
		userCriteria.andUIdEqualTo(user.getuId());// where u_id = user.getuId()
		userMapper.updateByExampleSelective(user, userExample);
	}

	public void deleteUserByid(int id) {
		userMapper.deleteByPrimaryKey(id);
	}

	// 查询用户是否存在
	public int countByUid(String uid) {
		UserExample userExample = new UserExample();
		Criteria userCriteria = userExample.createCriteria();
		userCriteria.andUIdEqualTo(uid);
		return userMapper.countByExample(userExample);

	}

	public int loginUser(String uid, String psw) {
		UserExample userExample = new UserExample();
		Criteria userCriteria = userExample.createCriteria();
		userCriteria.andUIdEqualTo(uid);
		userCriteria.andPwdEqualTo(psw);
		return userMapper.countByExample(userExample);
	}

}
