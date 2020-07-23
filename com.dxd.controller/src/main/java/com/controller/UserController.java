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
 * Ա��������
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
	 * ��ѯ�����û�
	 * @param model
	 * @param uName
	 * @param dId
	 * @return
	 */
	@RequestMapping("list")
	public String getAllUser(Model model
			,@RequestParam(value="uName",required=false)String uName
			,@RequestParam(value="dId",required=false)String dId) {
		//�ж�
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
		//�õ�����Ա��
		List<User> userList = us.getAllUser(map);
		//�õ����в�����Ϣ
		List<Department> departmentList = ds.getAllDepartment();
		
		//ѭ������
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
	 * ɾ��ָ���û���Ϣ
	 * @param uId
	 * @return
	 */
	@RequestMapping("delUser/")
	@ResponseBody
	public ReturnResult delUser(String uId) {
		ReturnResult result = new ReturnResult();
		//ɾ�����û����в�����Ϣ
		int departmentCount = ds.delUserDepartment(Integer.parseInt(uId));
		//ɾ�����û�
		int userCount = us.delUser(Integer.parseInt(uId));
		
		System.out.println(departmentCount+"���ŷ���ֵ");
		System.out.println(userCount+"Ա������ֵ");
		if(userCount > 0) {
			result.getSuccess("ɾ�����û��ɹ�!");
		}else {
			result.getFail("ϵͳ�����쳣!");
		}
		return result;
	}
	/**
	 * ������Ҫ�޸ĵ��û�
	 * @param uId
	 * @param model
	 * @return
	 */
	@RequestMapping("showUser")
	public String showUser(String uId,Model model) {
		//�õ����û���Ϣ
		User user = us.getUserById(Integer.parseInt(uId));
		//�õ����в�����Ϣ
		List<Department> departmentList = ds.getAllDepartment();
		System.out.println(user.getuId()+"\t"+user.getuName()+"\t"+user.getDepartment().getdName());
		//�洢
		model.addAttribute("user",user);
		model.addAttribute("departmentList",departmentList);
		return "ceshi";
	}
	/**
	 * �����޸�
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
		//�޸��û�������Ϣ
		int updateDe = ds.updateUserDepartment(map);
		//�޸��û���Ϣ
		int updateUser = us.updateUser(user);
		System.out.println(updateDe+"�޸Ĳ���");
		System.out.println(updateUser+"�޸��û�");
		if(updateUser > 0) {
			result.getSuccess("�޸��û��ɹ�!");
		}else {
			result.getFail("ϵͳ�����쳣!");
		}
		return result;
	}
	/**
	 * ����Ա��
	 * @param user
	 * @param dId
	 * @return
	 */
	@RequestMapping("addUser")
	@ResponseBody
	public ReturnResult addUser(User user,String dId) {
		ReturnResult result = new ReturnResult();
		//����û�
		int addUser = us.addUser(user);
		//����û�����
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uId", user.getuId());
		map.put("dId", dId);
		int addDepartment = ds.addUserDepartment(map);
		System.out.println(addUser+"����û�");
		System.out.println(addDepartment+"��Ӳ���");
		
		if(addDepartment > 0) {
			result.getSuccess("����Ա���ɹ�!");
		}else {
			result.getFail("ϵͳ�����쳣!");
		}
		return result;
		
	}
	/**
	 * ���Ա��ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd(Model model) {
		//�õ����в�����Ϣ
		List<Department> departmentList = ds.getAllDepartment();
		
		//���
		model.addAttribute("departmentList",departmentList);
		return "ceshi";
	}
	
}
