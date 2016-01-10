package com.easygo.model;

public class SharedRouteModel {
	   //SharedRoute±Ì µÃÂ
       int id;
	   int sharerId;
       int routeId;
       String startPointString;
       String endPointString;
       String sharerName;
	   String shareRouteDesc;
       int showTimes;
       int up;
       int down;   
       public String getSharerName() {
    	   return sharerName;
       }
       public void setSharerName(String sharerName) {
    	   this.sharerName = sharerName;
       }
       public String getShareRouteDesc() {
    	   return shareRouteDesc;
       }
       public void setShareRouteDesc(String shareRouteDesc) {
    	   this.shareRouteDesc = shareRouteDesc;
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
       public int getId() {
    	   return id;
       }
       public void setId(int id) {
    	   this.id = id;
       }
       public int getSharerId() {
    	   return sharerId;
       }
       public void setSharerId(int shareId) {
    	   this.sharerId = shareId;
       }
       public int getRouteId() {
    	   return routeId;
       }
       public void setRouteId(int routeId) {
    	   this.routeId = routeId;
       }
       public int getShowTimes() {
    	   return showTimes;
       }
       public void setShowTimes(int showTimes) {
    	   this.showTimes = showTimes;
       }
       public int getUp() {
    	   return up;
       }
       public void setUp(int up) {
    	   this.up = up;
       }
       public int getDown() {
    	   return down;
       }
       public void setDown(int down) {
    	   this.down = down;
       }
}
