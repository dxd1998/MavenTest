package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DepartmentMapper;
import com.pojo.Department;

/**
 *部门业务层实现类
 * @author 99266
 *
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper mapper;
	
	/**
	 * 查询所有部门
	 */
	public List<Department> getAllDepartment() {
		return mapper.getAllDepartment();
	}
	/**
	 * 删除员工部门
	 */
	public int delUserDepartment(Integer uId) {
		return mapper.delUserDepartment(uId);
	}
	/**
	 * 修改员工部门
	 */
	public int updateUserDepartment(Map<String, Object> map) {
		return mapper.updateUserDepartment(map);
	}
	/**
	 * 添加员工部门
	 */
	public int addUserDepartment(Map<String, Object> map) {
		return mapper.addUserDepartment(map);
	}

}
