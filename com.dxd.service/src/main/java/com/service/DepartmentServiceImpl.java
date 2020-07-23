package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DepartmentMapper;
import com.pojo.Department;

/**
 *����ҵ���ʵ����
 * @author 99266
 *
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper mapper;
	
	/**
	 * ��ѯ���в���
	 */
	public List<Department> getAllDepartment() {
		return mapper.getAllDepartment();
	}
	/**
	 * ɾ��Ա������
	 */
	public int delUserDepartment(Integer uId) {
		return mapper.delUserDepartment(uId);
	}
	/**
	 * �޸�Ա������
	 */
	public int updateUserDepartment(Map<String, Object> map) {
		return mapper.updateUserDepartment(map);
	}
	/**
	 * ���Ա������
	 */
	public int addUserDepartment(Map<String, Object> map) {
		return mapper.addUserDepartment(map);
	}

}
