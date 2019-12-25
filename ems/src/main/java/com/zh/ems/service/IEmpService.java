package com.zh.ems.service;

import com.zh.ems.pojo.Emp;

/**
 * 服务接口
 *
 */
public interface IEmpService {
	/**
	 * 通过昵称和密码查找emp对象
	 *
	 */
	Emp findEmpByNicknameAndPassword(String nickname, String password);

	/**
	 *
	 */
	int findEmpBynickname(String nickname);
	/**
	 * 注册员工信息
	 * 
	 * @param emp
	 */
	void registerEmp(Emp emp);
}
