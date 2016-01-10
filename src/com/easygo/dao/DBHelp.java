package com.easygo.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.easygo.dao.Config;
public class DBHelp {
	private Connection connection = null;
    public DBHelp() 
    {
		// TODO Auto-generated constructor stub
	    try {
			Class.forName(Config.DRIVER);
			this.connection = DriverManager.getConnection(Config.URL,Config.USER,Config.PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库获取连接出错");
		}
    }
    public Connection getConnection()
    {
    	return this.connection;
    }    
    public void close()
    {
        try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库关闭出错");
		}	
    }
}
