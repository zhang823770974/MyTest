package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String userName=req.getParameter("userName");
		String userPwd=req.getParameter("userPwd");
		
		UserDao userDao=new UserDao();
		User user=userDao.doLogin(userName, userPwd);
		
		if(user!=null){
			//获取一次会话
			HttpSession hs=req.getSession();
			hs.setAttribute("user", user);
			req.getRequestDispatcher("/showview.jsp").forward(req, resp);

			
		}else{
			req.setAttribute("tip", "用户名或者密码错误,请重新输入！");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
		
	}
	
	
}
