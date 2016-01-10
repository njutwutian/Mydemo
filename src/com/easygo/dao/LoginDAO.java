package com.easygo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.easygo.model.UserModel;
import com.easygo.dao.DBHelp;


public class LoginDAO {
	Connection connection = null;
     public boolean checkLogin(UserModel userModel)
     {
    	 //select username, password from user where username = '' and password = '';
    	 boolean flag = false;
    	 if (userModel==null) {
			return false;
		 }
    	 String sqlString = "select username, password from user where username = ? and password = ?";
    	 System.out.println("=======dbHelp init========");
    	 DBHelp dbHelp = new DBHelp();
    	 System.out.println("==============="+dbHelp.toString());
    	 connection = dbHelp.getConnection();
    	 try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
			preparedStatement.setString(1,userModel.getNameString());
			preparedStatement.setString(2,userModel.getPasswordString());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				flag = true;
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("CheckLogin方法执行SQL出错");
		}finally
		{
			dbHelp.close();
		}
    	 return flag;
     }
     public UserModel getIdByUserModel(UserModel userModel)
     {
    	 String sqlString = "select id , username, password from user where username = ? and password = ?";
    	 System.out.println("=======dbHelp init========");
    	 DBHelp dbHelp = new DBHelp();
    	 System.out.println("==============="+dbHelp.toString());
    	 connection = dbHelp.getConnection();
    	 try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
			preparedStatement.setString(1,userModel.getNameString());
			preparedStatement.setString(2,userModel.getPasswordString());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userModel.setId(resultSet.getInt(1));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("CheckLogin方法执行SQL出错");
		}finally
		{
			dbHelp.close();
		}
    	 return userModel;
     }
}
