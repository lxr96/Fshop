package com.sise.service;

import java.util.List;

import com.sise.entity.User;

public interface UserService {
	// 查询byId
	public User getUserById(int id);

	// 查询byUid
	public User getUserByUid(String uid);
	
	// 查询所有用户
	List<User> getUserAll();

	// 注册用户
	void insertUser(User user);

	// 更新用户信息
	void updataUser(User user);

	// 删除byId
	void deleteUserByid(int id);

	// 查询用户是否存在
	int countByUid(String uid);
	
	//登录
	int loginUser(String uid, String psw);
	
	//带分页的userList
	
}
