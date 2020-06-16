package com.atguigu.dubbo.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.dubbo.bean.Order;
import com.atguigu.dubbo.bean.User;
import com.atguigu.dubbo.bean.service.UserService;

public class MainApplication {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
		
		applicationContext.start();
		
		UserService userService = (UserService) applicationContext.getBean("userService");
		 System.out.println(userService);
		 
		User user = new User();
		user.setUserName("zhangsan");
		
		Order order = userService.buyNewMovie(user);
        
        System.out.println(order); // 显示调用结果
		
	}

}
