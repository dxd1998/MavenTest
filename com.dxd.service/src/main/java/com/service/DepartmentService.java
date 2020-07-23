package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.Department;

/**
 * ����ҵ���ӿ�
 * @author 99266
 *
 */
public interface DepartmentService {
	/**
	 * �õ����в���
	 * @return
	 */
	public List<Department> getAllDepartment();
	/**
	 * ɾ��Ա��������Ϣ
	 * @param uId
	 * @return
	 */
	public int delUserDepartment(Integer uId);
	/**
	 * �޸�Ա������
	 * @param map
	 * @return
	 */
	public int updateUserDepartment(Map<String,Object> map);
	/**
	 * ����û�������Ϣ
	 * @param map
	 * @return
	 */
	public int addUserDepartment(Map<String,Object> map);
}
