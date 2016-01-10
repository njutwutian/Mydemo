package com.easygo.model;

public class RouteInfoModel {
	   //RouteInfo±Ì µÃÂ
       int id = 0;
       String startPointString = " ";
       String endPointString =" ";
       int type = -1;
	   public int getId() {
		    return id;
	   }
	   public void setId(int id) {
		    this.id = id;
	   }
	   public String getStartPointString() {
		    return startPointString;
	   }
	   public void setStartPointString(String startPointString) {
	    	this.startPointString = startPointString;
	   }
	   public String getEndPointString() {
		    return endPointString;
	   }
	   public void setEndPointString(String endPointString) {
		    this.endPointString = endPointString;
	   }
	   public int getType() {
		    return type;
	   }
	   public void setType(int type) {
		    this.type = type;
	   }
       
}
