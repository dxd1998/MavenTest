package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.User;

/**
 * Ա���ӿ�
 * @author 99266
 *
 */
public interface UserMapper {
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
