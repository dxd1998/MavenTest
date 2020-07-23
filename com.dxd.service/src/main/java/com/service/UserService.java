package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.User;

/**
 * Ա��ҵ���ӿ�
 * @author 99266
 *
 */
public interface UserService {
	/**
	 * ��ѯ�����û���Ϣ
	 * @return
	 */
	public List<User> getAllUser(Map<String,Object> map);
	/**
	 * ɾ��Ա����Ϣ
	 * @param uId
	 * @return
	 */
	public int delUser(Integer uId);
	/**
	 * ��ѯָ��Ա��
	 * @param uId
	 * @return
	 */
	public User getUserById(Integer uId);
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	/**
	 * ���Ա����Ϣ
	 * @param user
	 * @return
	 */
	public int addUser(User user);
}
