package com.easygo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easygo.bll.RouteInfoBll;
import com.easygo.bll.SharedRouteBll;
import com.easygo.common.Common;
import com.easygo.model.RouteInfoModel;
import com.easygo.model.SharedRouteModel;

public class InsertSharedRouteServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InsertSharedRouteServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
        System.out.println("==========InsertSharedRouteServlet dopost===============");
       // String routeIdString = request.getParameter("routeid");
        String startPoint = new String(request.getParameter("startpoint").getBytes("ISO-8859-1"),"utf-8");
        String endPoint = new String(request.getParameter("endpoint").getBytes("ISO-8859-1"),"utf-8");
        RouteInfoModel routeInfoModel = new RouteInfoModel();
        routeInfoModel.setStartPointString(startPoint);
        routeInfoModel.setEndPointString(endPoint);
        int routeId = new RouteInfoBll().getIdByRouteInfo(routeInfoModel).getId(); 
        String shareRouteDescString = new String(request.getParameter("shareroutedesc").getBytes("ISO-8859-1"),"utf-8");
        //System.out.println(routeIdString);
        System.out.println(shareRouteDescString);
        System.out.println(request.getSession().getAttribute("id").toString());
        SharedRouteModel sharedRouteModel = new SharedRouteModel();
        sharedRouteModel.setSharerId(new Common().convertObjToInt(request.getSession().getAttribute("id")));
        sharedRouteModel.setRouteId(routeId);
        sharedRouteModel.setShareRouteDesc(shareRouteDescString);
        if (new SharedRouteBll().insertShareRouteDescBll(sharedRouteModel)) {
        	  response.setContentType("text/html");
			  response.setCharacterEncoding("utf-8");
			  PrintWriter out = response.getWriter();
			  out.println("{\"data\":\"插入成功\"}");
			  out.flush();
			  out.close();
		}else {
			  response.setContentType("text/html");
			  response.setCharacterEncoding("utf-8");
			  PrintWriter out = response.getWriter();
			  out.println("{\"data\":\"插入失败\"}");
			  out.flush();
			  out.close();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
