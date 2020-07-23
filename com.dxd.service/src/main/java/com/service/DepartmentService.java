package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.Department;

/**
 * 部门业务层接口
 * @author 99266
 *
 */
public interface DepartmentService {
	/**
	 * 得到所有部门
	 * @return
	 */
	public List<Department> getAllDepartment();
	/**
	 * 删除员工部门信息
	 * @param uId
	 * @return
	 */
	public int delUserDepartment(Integer uId);
	/**
	 * 修改员工部门
	 * @param map
	 * @return
	 */
	public int updateUserDepartment(Map<String,Object> map);
	/**
	 * 添加用户部门信息
	 * @param map
	 * @return
	 */
	public int addUserDepartment(Map<String,Object> map);
}
