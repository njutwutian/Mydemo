package com.easygo.bll;

import com.easygo.dao.RouteInfoDAO;
import com.easygo.model.RouteInfoModel;

public class RouteInfoBll {
     public RouteInfoModel getIdByRouteInfo(RouteInfoModel routeInfoModel)
     {
    	 return new RouteInfoDAO().getIdByRouteInfo(routeInfoModel);
     }
}
