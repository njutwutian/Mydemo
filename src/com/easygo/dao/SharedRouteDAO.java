package com.easygo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.easygo.model.SharedRouteModel;
import com.easygo.model.RouteInfoModel;
public class SharedRouteDAO {
	 Connection connection = null;
     public  List<SharedRouteModel> getSharedRouteListByRouteInfo(RouteInfoModel routeInfoModel)
     {
//    	   int id;
//  	   int shareId;
//         int routeId;
//         String startPointString;
//         String endPointString;
//         int type;
//         String routeDesc;
//         int showTimes;
//         int up;
//         int down;
//select tb1.id,tb1.sharerid,tb1.routeid,tb2.startpoint,tb2.endpoint,tb2.type,tb1.routedesc,tb1.showtimes,tb1.up,tb1.down from sharedroute as tb1 join routeinfo as tb2 on tb1.routeid = tb2.id where tb2.startpoint = '南京工业大学' and tb2.endpoint = '新街口' and tb2.type = 1 order by tb1.createtime desc;
    	 String sqlString = "select tb1.id,tb1.sharerid,tb1.routeid,tb2.startpoint,tb2.endpoint,tb3.username,tb1.shareroutedesc,tb1.showtimes,tb1.up,tb1.down from sharedroute as tb1 join routeinfo as tb2 on tb1.routeid = tb2.id join user as tb3 on tb1.sharerid = tb3.id where tb2.startpoint = ? and tb2.endpoint = ? order by tb1.createtime desc;";
    	 List<SharedRouteModel> sharedRouteModelList = new ArrayList<SharedRouteModel>();
    	 DBHelp dbHelp = new DBHelp();
    	  // 	 System.out.println("==============="+dbHelp.toString());
    	   	 connection = dbHelp.getConnection();
    	   	 try {
    				PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
    				preparedStatement.setString(1,routeInfoModel.getStartPointString());
    				preparedStatement.setString(2, routeInfoModel.getEndPointString());
    				ResultSet resultSet = preparedStatement.executeQuery();
    				while (resultSet.next()) {
    					SharedRouteModel sharedRouteModel = new SharedRouteModel();
    					sharedRouteModel.setId(resultSet.getInt(1));
    					sharedRouteModel.setSharerId(resultSet.getInt(2));
    					sharedRouteModel.setRouteId(resultSet.getInt(3));
    					sharedRouteModel.setStartPointString(resultSet.getString(4));
    					sharedRouteModel.setEndPointString(resultSet.getString(5));
    					sharedRouteModel.setSharerName(resultSet.getString(6));
    					sharedRouteModel.setShareRouteDesc(resultSet.getString(7));
    					sharedRouteModel.setShowTimes(resultSet.getInt(8));
    					sharedRouteModel.setUp(resultSet.getInt(9));
    					sharedRouteModel.setDown(resultSet.getInt(10));
    					//System.out.println(sharedRouteModel.getShareRouteDesc());
    					sharedRouteModelList.add(sharedRouteModel);
    				}
    				resultSet.close();
    				preparedStatement.close();
    				
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    				System.out.println("getSharedRouteListByRouteInfo方法执行SQL出错");
    			}finally
    			{
    				dbHelp.close();
    			}
//    	        for (int i = 0; i < sharedRouteModelList.size(); i++) {
//    				System.out.println(sharedRouteModelList.get(i).getShareRouteDesc());
//    			}
    	        //System.out.println("=========dbhelp===========");
    	     	return sharedRouteModelList;
     }
     public boolean insertSharedRoute(SharedRouteModel sharedRouteModel)
     {
    	 int flag = 0 ;
    	 String sqlString = "insert into sharedroute (sharerid,routeid,shareroutedesc) values (?,?,?)";
    	 DBHelp dbHelp = new DBHelp();
         // 	 System.out.println("==============="+dbHelp.toString());
          	 connection = dbHelp.getConnection();
          	 try {
       			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
       			preparedStatement.setInt(1,sharedRouteModel.getSharerId());
       			preparedStatement.setInt(2,sharedRouteModel.getRouteId());
       			preparedStatement.setString(3,sharedRouteModel.getShareRouteDesc());
       			flag = preparedStatement.executeUpdate();
       			preparedStatement.close();
          	 } catch (SQLException e) {
       			// TODO Auto-generated catch block
       			e.printStackTrace();
       			System.out.println("insertRouteInfo方法执行SQL出错");
       		}finally
       		{
       			dbHelp.close();
       		}
          	if (flag>0) {
				return true;
			}
            else {
				return false;
			}
     }
     public boolean updateUpNumb(SharedRouteModel sharedRouteModel)
     {
    	 int flag = 0 ;
    	 String sqlString = "update sharedroute set up = ? where id = ?";
    	 DBHelp dbHelp = new DBHelp();
    	 connection = dbHelp.getConnection();
    	 try {
    		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, sharedRouteModel.getUp());
			preparedStatement.setInt(2, sharedRouteModel.getId());
			flag = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("updateupnumb function error");
		}finally
		{
			dbHelp.close();
		}
    	 if (flag>0) {
    		 return true;			
		}else {
			return false;
		}
      }
     public boolean updateDownNumb(SharedRouteModel sharedRouteModel)
     {
    	 int flag = 0 ;
    	 String sqlString = "update sharedroute set down = ? where id = ?";
    	 DBHelp dbHelp = new DBHelp();
    	 connection = dbHelp.getConnection();
    	 try {
    		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, sharedRouteModel.getDown());
			preparedStatement.setInt(2, sharedRouteModel.getId());
			flag = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("updatedownnumb function error");
		}finally
		{
			dbHelp.close();
		}
    	 if (flag>0) {
    		 return true;			
		}else {
			return false;
		}
      }
     
     
     
     
     
     
     
     
}
