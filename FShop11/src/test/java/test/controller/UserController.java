package test.controller;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.entity.User;
import com.sise.service.UserService;
import com.sise.vo.UserListVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserController {

	@Autowired
	UserService userService;
	@Test
	public void show() {
//		System.out.println(userService.getUserAll());
		PageHelper.startPage(2,5);//第几页，一个多少条数据（1，5）
		List<User> userList=userService.getUserAll();
		
		List<UserListVO> userListVOList = new ArrayList<UserListVO>();
		for(User userItem : userList) {
//			System.out.println(userItem.getId());
			UserListVO userListVO = assembleUserListVO(userItem);
			userListVOList.add(userListVO);	
		}
		PageInfo pageInfo = new PageInfo(userList);
		pageInfo.setList(userListVOList);
		System.out.println(pageInfo);

//		PageInfo<User> pageInfo = new PageInfo<User>(userList);
//		System.out.println(pageInfo.getList());
	}
	
	public void show1() {
//		System.out.println(userService.getUserAll());
		PageHelper.startPage(1,3);//第几页，一个多少条数据（1，5）
		List<User> userList=userService.getUserAll();
		PageInfo pageInfo = new PageInfo(userList);
		System.out.println(pageInfo);

//		PageInfo<User> pageInfo = new PageInfo<User>(userList);
//		System.out.println(pageInfo.getList());
	}
	//用户查重复
	public void queryExists() {
		//System.out.println(userService.queryExists("123"));
		PageHelper.startPage(1,5);//第几页，一个多少条数据（1，5）
		List<User> userlist=userService.getUserAll();
		PageInfo<User> pageInfo = new PageInfo<User>(userlist);
		System.out.println(pageInfo);
//		System.out.println(userService.getUserAll());
//		System.out.println(userService.countByUid("123"));
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
		user.setuId("lxr1");
		user.setPwd("321");
		user.setName("gg");
		userService.updataUser(user);
	}
	
	//模拟删除用户
	public void delete() {
		userService.deleteUserByid(5);
	}
	
	//模拟用户登录
	public void signIn() {
		System.out.println(userService.loginUser("lxr", "123"));
		User user = userService.getUserByUid("lxr");
		System.out.println(user.getKind());;
	}
	
	private UserListVO assembleUserListVO(User user) {
		UserListVO userListVO = new UserListVO();
		userListVO.setId(user.getId());
		userListVO.setuId(user.getuId());
		userListVO.setKind(user.getKind());
		userListVO.setStatus(user.getStatus());
		userListVO.setCreateTime(user.getCreateTime());
		return userListVO;
		
	}
}
