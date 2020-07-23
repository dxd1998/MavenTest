package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Department;
import com.pojo.User;
import com.service.DepartmentService;
import com.service.UserService;
import com.utils.ReturnResult;

/**
 * 员工控制器
 * @author 99266
 *
 */
@Controller
@RequestMapping("user/")
public class UserController {
	
	public UserService us;
	
	public DepartmentService ds;
	
	public UserController(UserService us,DepartmentService ds) {
		this.us = us;
		this.ds = ds;
	}
	/**
	 * 查询所有用户
	 * @param model
	 * @param uName
	 * @param dId
	 * @return
	 */
	@RequestMapping("list")
	public String getAllUser(Model model
			,@RequestParam(value="uName",required=false)String uName
			,@RequestParam(value="dId",required=false)String dId) {
		//判断
		Map<String,Object> map = new HashMap<String,Object>();
		if(uName != null && !uName.equals("")) {
			map.put("uName", uName);
		}else {
			map.put("uName", "");
		}
		if(dId != null && !dId.equals("")) {
			map.put("dId", dId);
		}else {
			map.put("dId","");
		}
		System.out.println(map);
		//得到所有员工
		List<User> userList = us.getAllUser(map);
		//得到所有部门信息
		List<Department> departmentList = ds.getAllDepartment();
		
		//循环测试
		for(User us : userList) {
			System.out.println(us.getuId()+"\t"+us.getuName()+"\t"+us.getDepartment().getdName());
		}
		System.out.println();
		System.out.println();
		for(Department de : departmentList) {
			System.out.println(de.getdName());
		}
		model.addAttribute("userList",userList);
		model.addAttribute("departmentList",departmentList);
		
		return "ceshi";
	}
	/**
	 * 删除指定用户信息
	 * @param uId
	 * @return
	 */
	@RequestMapping("delUser/")
	@ResponseBody
	public ReturnResult delUser(String uId) {
		ReturnResult result = new ReturnResult();
		//删除该用户所有部门信息
		int departmentCount = ds.delUserDepartment(Integer.parseInt(uId));
		//删除该用户
		int userCount = us.delUser(Integer.parseInt(uId));
		
		System.out.println(departmentCount+"部门返回值");
		System.out.println(userCount+"员工返回值");
		if(userCount > 0) {
			result.getSuccess("删除该用户成功!");
		}else {
			result.getFail("系统出现异常!");
		}
		return result;
	}
	/**
	 * 回显需要修改的用户
	 * @param uId
	 * @param model
	 * @return
	 */
	@RequestMapping("showUser")
	public String showUser(String uId,Model model) {
		//得到该用户信息
		User user = us.getUserById(Integer.parseInt(uId));
		//得到所有部门信息
		List<Department> departmentList = ds.getAllDepartment();
		System.out.println(user.getuId()+"\t"+user.getuName()+"\t"+user.getDepartment().getdName());
		//存储
		model.addAttribute("user",user);
		model.addAttribute("departmentList",departmentList);
		return "ceshi";
	}
	/**
	 * 保存修改
	 * @param user
	 * @param dId
	 * @return
	 */
	@RequestMapping("saveUpdate")
	@ResponseBody
	public ReturnResult updateUser(User user,String dId) {
		ReturnResult result = new ReturnResult();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uId", user.getuId());
		map.put("dId", dId);
		//修改用户部门信息
		int updateDe = ds.updateUserDepartment(map);
		//修改用户信息
		int updateUser = us.updateUser(user);
		System.out.println(updateDe+"修改部门");
		System.out.println(updateUser+"修改用户");
		if(updateUser > 0) {
			result.getSuccess("修改用户成功!");
		}else {
			result.getFail("系统出现异常!");
		}
		return result;
	}
	/**
	 * 新增员工
	 * @param user
	 * @param dId
	 * @return
	 */
	@RequestMapping("addUser")
	@ResponseBody
	public ReturnResult addUser(User user,String dId) {
		ReturnResult result = new ReturnResult();
		//添加用户
		int addUser = us.addUser(user);
		//添加用户部门
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uId", user.getuId());
		map.put("dId", dId);
		int addDepartment = ds.addUserDepartment(map);
		System.out.println(addUser+"添加用户");
		System.out.println(addDepartment+"添加部门");
		
		if(addDepartment > 0) {
			result.getSuccess("新增员工成功!");
		}else {
			result.getFail("系统出现异常!");
		}
		return result;
		
	}
	/**
	 * 添加员工页面
	 * @param model
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd(Model model) {
		//得到所有部门信息
		List<Department> departmentList = ds.getAllDepartment();
		
		//添加
		model.addAttribute("departmentList",departmentList);
		return "ceshi";
	}
	
}
