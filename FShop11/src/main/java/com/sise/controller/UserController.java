package com.sise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.entity.User;
import com.sise.service.UserService;
@SessionAttributes(value="usr")
@Controller
public class UserController {
	@Autowired
	UserService userService;

	// 注册用户
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView insertUser(User user) {
		ModelAndView mv = new ModelAndView();
		String uid = user.getuId();
		if (countByUid(uid) < 1) {//用户未注册，可以用
			userService.insertUser(user);
			System.out.println(user.getuId()+"注册成功");
			mv.addObject("user", user);
			mv.setViewName("success");
		}
			
		else
			System.out.println(uid+"用户已存在");
		return mv;
	}

	// 查询用户是否存在
	public int countByUid(String uid) {
		return userService.countByUid(uid);
	}
	
	//修改用户信息
	public void updateUser(User user) {
		userService.updataUser(user);
	}
	
	//删除用户
	public void deleteUser(int id) {
		userService.deleteUserByid(id);
	}
	
	//登录
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView loginUser(String uid,String psw) {
		ModelAndView mv = new ModelAndView();
		if(userService.loginUser(uid, psw)>0) {
			User user = userService.getUserByUid(uid);
			String kind = user.getKind();
			String statu = user.getStatus();
			if(statu.equals("normal")) {
				if(kind.equals("admin"))
					mv.setViewName("admin/index");
				else if(kind.equals("customer"))
					mv.setViewName("index");
				else if(kind.equals("seller"))
					mv.setViewName("seller");
			}
			mv.addObject("usr", user.getuId());
			System.out.println(user.getuId()+",login");
		}
		else
		{
			mv.addObject("msg","你的密码不正确！");
			mv.setViewName("falselogion");
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("show_ajax_user")
		public String showAllUser(User seller) {
		PageHelper.startPage(0,2);//第几页，一个多少条数据（1，5）
		List<User> userlist=userService.getUserAll();
		PageInfo<User> pageInfo = new PageInfo<User>(userlist);
			return pageInfo.toString() ;
		}
}
