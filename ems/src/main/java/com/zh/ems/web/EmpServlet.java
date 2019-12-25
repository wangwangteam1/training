package com.zh.ems.web;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.ems.pojo.Emp;
import com.zh.ems.service.IEmpService;
import com.zh.ems.service.impl.Empservice;

@SuppressWarnings("serial")
//@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//接受请求参数
		String cmd=req.getParameter("cmd");
		
		if("login".equals(cmd)) {
			System.out.println("收到登陆命令");
			login(req,resp);
		}else if("register".equals(cmd)) {
			register(req,resp);
		}
	}
	

	/**
	 * 注册功能
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nickname=req.getParameter("nickname");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		double salary=Double.parseDouble(req.getParameter("salary"));
		
		/**
		 * 判断昵称是否已经被使用
		 */
		//获取到服务对象
		IEmpService service=new Empservice();
		//调用判断用户名是否存在的方法
		// 1表示存在, 非1表示不存在
		int flag=service.findEmpBynickname(nickname);
		
		if(flag==1) {
			//将提示信息放入请求域
			req.setAttribute("nicknameMsg","该昵称已存在,请更换一个");
			//请求转发
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
			
			return;
		}else {
			//把数据封装到实体对象中
			Emp emp=new Emp(1, nickname, password, gender, salary);
			//调用注册方法
			service.registerEmp(emp);
			resp.getWriter().write("注册成功, 3s后跳转到登录页面");
			resp.setHeader("refresh", "3;url=/ems/login.jsp");
		}
		
		//将数据封装到emp实体对象
		Emp emp=new Emp(1, nickname, password, gender, salary);
		

	}


	/**
	 * 处理登录功能的方法
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		/**
		 * 1,获取用户输入的昵称和密码
		 * 2,去数据库查找是否正好有对应昵称和密码
		 * 3,若存在，允许登录
		 * 4,不存在，tell用户[账号或密码有误，请检查后登陆，或者是点击[注册]]
		 */
		//1,获取昵称密码
		String nickname=req.getParameter("nickname");
		String password=req.getParameter("password");
		System.out.println(nickname);
		System.out.println(password);
		//2,查找昵称和密码
		IEmpService service=new Empservice();
		Emp emp=service.findEmpByNicknameAndPassword(nickname, password);
		if(emp!=null) {
			resp.getWriter().write("登陸成功"+emp);
			return;
		}else {
			resp.getWriter().write("错误");
		}
	}
}
