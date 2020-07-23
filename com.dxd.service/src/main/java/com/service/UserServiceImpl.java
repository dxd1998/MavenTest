package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.pojo.User;

/**
 * 员工业务层实现类
 * @author 99266
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper mapper;
	
	/**
	 * 查询所有用户信息
	 */
	public List<User> getAllUser(Map<String, Object> map) {
		return mapper.getAllUser(map);
	}
	/**
	 * 删除用户
	 */
	public int delUser(Integer uId) {
		return mapper.delUser(uId);
	}
	/**
	 * 查询指定用户信息
	 */
	public User getUserById(Integer uId) {
		return mapper.getUserById(uId);
	}
	/**
	 * 修改指定用户信息
	 */
	public int updateUser(User user) {
		return mapper.updateUser(user);
	}
	/**
	 * 添加用户信息
	 */
	public int addUser(User user) {
		return mapper.addUser(user);
	}

}
