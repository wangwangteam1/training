package com.zh.ems.service.impl;

import com.zh.ems.dao.IEmpDao;
import com.zh.ems.dao.impl.EmpDao;
import com.zh.ems.pojo.Emp;
import com.zh.ems.service.IEmpService;

/**
 * 服务接口的实现
 * @author Bubble
 *
 */
public class Empservice implements IEmpService {
	// 获取到专门处理持久层方面的对象
	private IEmpDao empDao = new EmpDao();
	public Emp findEmpByNicknameAndPassword(String nickname, String password) {
		// 调用dao中的方法
		return empDao.findEmpByNicknameAndPassword(nickname, password);
	}
	
	public int findEmpBynickname(String nickname) {
		// 调用dao中的方法
		return empDao.findEmpBynickname(nickname);
	}

	@Override
	public void registerEmp(Emp emp) {
		empDao.registerEmp(emp);
	}
}
