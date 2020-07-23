package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.pojo.User;

/**
 * Ա��ҵ���ʵ����
 * @author 99266
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper mapper;
	
	/**
	 * ��ѯ�����û���Ϣ
	 */
	public List<User> getAllUser(Map<String, Object> map) {
		return mapper.getAllUser(map);
	}
	/**
	 * ɾ���û�
	 */
	public int delUser(Integer uId) {
		return mapper.delUser(uId);
	}
	/**
	 * ��ѯָ���û���Ϣ
	 */
	public User getUserById(Integer uId) {
		return mapper.getUserById(uId);
	}
	/**
	 * �޸�ָ���û���Ϣ
	 */
	public int updateUser(User user) {
		return mapper.updateUser(user);
	}
	/**
	 * ����û���Ϣ
	 */
	public int addUser(User user) {
		return mapper.addUser(user);
	}

}
