package com.controller;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.User;
import com.service.DepartmentService;
import com.service.UserService;

public class testController {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	ApplicationContext context = null;
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void test() {
		UserController uc = new UserController((UserService)context.getBean("userService"),(DepartmentService)context.getBean("departmentService"));
		//删除员工
		//uc.delUser("18");
		//查询员工
		//uc.getAllUser(null, null, null);
		//查询指定员工
		//uc.showUser("2", null);
		//修改员工
		/*
		 * User user = new User(); user.setuId(2); user.setuName("李四测试");
		 * user.setuAge(17); user.setuSex("女"); uc.updateUser(user, "5");
		 */
		//添加员工信息
		User user = new User();
		user.setuName("二蛋啊");
		user.setuAge(22);
		user.setuSex("男");
		uc.addUser(user, "2");
		
	}

}
