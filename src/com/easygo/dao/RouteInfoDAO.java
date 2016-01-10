package com.easygo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.easygo.model.RouteInfoModel;
import com.easygo.dao.DBHelp;
public class RouteInfoDAO {
	Connection connection = null;
    public RouteInfoModel getRouteInfoById(int id)
    {
   	 // select id,startpoint,endpoint,type from routeinfo;
     RouteInfoModel routeInfoModel = new RouteInfoModel();
   	 String sqlString = "select id,startpoint,endpoint,type from routeinfo where id = ?;";
  // 	 System.out.println("=======dbHelp init========");
   	 DBHelp dbHelp = new DBHelp();
  // 	 System.out.println("==============="+dbHelp.toString());
   	 connection = dbHelp.getConnection();
   	 try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				routeInfoModel.setId(resultSet.getInt(1));
				routeInfoModel.setStartPointString(resultSet.getString(2));
				routeInfoModel.setEndPointString(resultSet.getString(3));
				routeInfoModel.setType(resultSet.getInt(4));
			}
			resultSet.close();
			preparedStatement.close();
		   	 return routeInfoModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getRouteInfoById方法执行SQL出错");
			return null;
		}finally
		{
			dbHelp.close();
		}
    }
    public RouteInfoModel getIdByRouteInfo(RouteInfoModel routeInfoModel)
    {
       	 String sqlString = "select id,startpoint,endpoint,type from routeinfo where startpoint = ? and endpoint = ?;";
      // 	 System.out.println("=======dbHelp init========");
       	 DBHelp dbHelp = new DBHelp();
      // 	 System.out.println("==============="+dbHelp.toString());
       	 connection = dbHelp.getConnection();
       	 try {
    			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
    			preparedStatement.setString(1,routeInfoModel.getStartPointString());
    			preparedStatement.setString(2, routeInfoModel.getEndPointString());
    			ResultSet resultSet = preparedStatement.executeQuery();
    			if (resultSet.next()) {
    				routeInfoModel.setId(resultSet.getInt(1));
    			}
    			resultSet.close();
    			preparedStatement.close();
    			return routeInfoModel;
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			System.out.println("getRouteInfoById方法执行SQL出错");
    			return null;
    		}finally
    		{
    			dbHelp.close();
    		}
    }
    public boolean insertRouteInfo(RouteInfoModel routeInfoModel)
    {
    	int flag = 0;
    	String sqlString ="insert into routeinfo (startpoint,endpoint,type) values(?,?,?);";
//    	 System.out.println("=======dbHelp init========");
      	 DBHelp dbHelp = new DBHelp();
     // 	 System.out.println("==============="+dbHelp.toString());
      	 connection = dbHelp.getConnection();
      	 try {
   			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
   			preparedStatement.setString(1,routeInfoModel.getStartPointString());
   			preparedStatement.setString(2, routeInfoModel.getEndPointString());
   			preparedStatement.setInt(3, routeInfoModel.getType());
   			flag = preparedStatement.executeUpdate();
   			preparedStatement.close();
            if (flag>0) {
				return true;
			}
            else {
				return false;
			}
      	 } catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   			System.out.println("insertRouteInfo方法执行SQL出错");
   			return false;
   		}finally
   		{
   			dbHelp.close();
   		}
    }
}
