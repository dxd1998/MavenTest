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
		//ɾ��Ա��
		//uc.delUser("18");
		//��ѯԱ��
		//uc.getAllUser(null, null, null);
		//��ѯָ��Ա��
		//uc.showUser("2", null);
		//�޸�Ա��
		/*
		 * User user = new User(); user.setuId(2); user.setuName("���Ĳ���");
		 * user.setuAge(17); user.setuSex("Ů"); uc.updateUser(user, "5");
		 */
		//���Ա����Ϣ
		User user = new User();
		user.setuName("������");
		user.setuAge(22);
		user.setuSex("��");
		uc.addUser(user, "2");
		
	}

}
