package com.easygo.bll;

import java.util.List;

import com.easygo.dao.SharedRouteDAO;
import com.easygo.model.RouteInfoModel;
import com.easygo.model.SharedRouteModel;

public class SharedRouteBll {
	public List<SharedRouteModel> getSharedRouteListByRouteInfoBll(RouteInfoModel routeInfoModel){
		return new SharedRouteDAO().getSharedRouteListByRouteInfo(routeInfoModel);
	}
	public boolean insertShareRouteDescBll(SharedRouteModel sharedRouteModel){
		return new SharedRouteDAO().insertSharedRoute(sharedRouteModel);
	}
	public boolean addUpNumbBll(SharedRouteModel sharedRouteModel){
		return new SharedRouteDAO().updateUpNumb(sharedRouteModel);
	}
	public boolean addDownNumbBll(SharedRouteModel sharedRouteModel){
		return new SharedRouteDAO().updateDownNumb(sharedRouteModel);
	}
}
