package com.sise.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sise.entity.User;
import com.sise.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestController {

	@Autowired
	UserService userService;
	
	
	//用户查重复
	public void queryExists() {
		//System.out.println(userService.queryExists("123"));
		System.out.println(userService.getUserAll());
		System.out.println(userService.countByUid("123"));
	}
	
	//模拟注册
	
	public void regedit() {
		User user = new User();
		user.setuId("lxr2");
		user.setPwd("123");
		user.setSex("male");
		user.setKind("customer");
		if(userService.countByUid(user.getuId())<1) {
			userService.insertUser(user);
			System.out.println(user.getuId()+"注册成功");
		}
		else
			System.out.println(user.getuId()+"用户名已存在");
	}
	
	//模拟更新用户信息
	
	public void update() {
		User user = new User();
		user.setuId("lxr2");
		user.setPwd("321");
		user.setName("gg");
		userService.updataUser(user);
	}
	
	//模拟删除用户
	public void delete() {
		userService.deleteUserByid(5);
	}
	@Test
	//模拟用户登录
	public void signIn() {
		System.out.println(userService.loginUser("lxr", "123"));
		User user = userService.getUserByUid("lxr");
		System.out.println(user.getKind());;
	}
}
