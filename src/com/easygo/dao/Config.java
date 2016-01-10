package com.easygo.dao;

public interface Config {
	 /* 数据库链接所需常量 
    驱动名
    数据库路径
    用户名
    密码
 */
	
 public static final String DRIVER = "com.mysql.jdbc.Driver";
 
 public static final String URL = "jdbc:mysql://localhost:3306/easygo?characterEncoding=utf-8";
 
 public static final String USER = "root";
 
 public static final String PASSWORD = "root";
}
