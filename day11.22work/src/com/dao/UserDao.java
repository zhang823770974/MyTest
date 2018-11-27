package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;

public class UserDao {
	static{
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 把注册信息加到数据库
	 */
	public int addUser(User user){
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			//2.建立连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/registerbase", "root", "zhang");
			//3.把数据加到数据库中
			pst=conn.prepareStatement("insert into oneregister (userName,userPwd,userAge,userSexy,fileName) values(?,?,?,?,?) ");
			//把？的值设置进去
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getUserPwd());
			pst.setString(3, user.getUserAge());
			pst.setString(4, user.getUserSexy());
			pst.setString(5, user.getFileName());
			//返回插入数据受影响行数
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				//关闭连接
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
		
	}
	/*
	 * 验证登陆账号和密码是否正确(与数据库的信息比对)
	 */
	public User doLogin(String userName,String userPwd){
		
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			//建立连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/registerbase", "root", "zhang");
			//查询数据库中是否有相同的用户名和密码
			pst=conn.prepareStatement("select * from oneregister where userName=? and userPwd=?");
			pst.setString(1, userName);
			pst.setString(2, userPwd);
			//产生单个结果集
			ResultSet rs=pst.executeQuery();
			User user=null;
			while(rs.next()){
				user=new User();
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPwd(rs.getString(3));
				user.setUserAge(rs.getString(4));
				user.setUserSexy(rs.getString(5));
				user.setFileName(rs.getString(6));
			}
			return user;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				//关闭连接
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}
	public String queryUser(String userName,String userPwd){
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			//建立连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/registerbase", "root", "zhang");
			//查询fileName
			pst=conn.prepareStatement("select fileName from oneregister where userName=? and userPwd=?");
			pst.setString(1, userName);
			pst.setString(2, userPwd);
			ResultSet rs=pst.executeQuery();
			User user=new User();
			String fileName=null;
			while(rs.next()){
				fileName=user.setFileName(rs.getString(6));
				}
			return 	fileName;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				//关闭连接
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}
	
}
