package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.UserDao;
import com.model.User;

@MultipartConfig
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码集
		req.setCharacterEncoding("utf-8");
		//1.获取参数
		String userName=req.getParameter("userName");
		String userPwd=req.getParameter("userPwd");
		String userAge=req.getParameter("userAge");
		String userSexy=req.getParameter("userSexy");
		
		Part partName=req.getPart("fileName");
		String header=partName.getHeader("content-disposition");
		String fileName=header.substring(header.indexOf("filename")+10, header.length()-1);
		partName.write(req.getServletContext().getRealPath("/")+File.separator+"uploadimg"+File.separator+fileName);
		//filePart.write(fileName);
		//2.把获取的参数传到User对象中
		User user=new User(userName,userPwd,userAge,userSexy,"uploadimg"+File.separator+fileName);
		UserDao userDao=new UserDao();
		
		int rows=userDao.addUser(user);
		if(rows==0){
			System.out.println("添加失败");
			//重新添加
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
		}else{
			System.out.println("添加成功");
			req.setAttribute("tip", "请输入注册的用户名密码");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

}
