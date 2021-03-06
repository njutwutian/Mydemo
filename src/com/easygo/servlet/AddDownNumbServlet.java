package com.easygo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easygo.bll.SharedRouteBll;
import com.easygo.model.RouteInfoModel;
import com.easygo.model.SharedRouteModel;

public class AddDownNumbServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddDownNumbServlet() {
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
	    	response.setContentType("text/html;charset=UTF-8");
    	    request.setCharacterEncoding("UTF-8");
		    int sharedRouteId = Integer.parseInt(request.getParameter("sharedrouteid"));
	        int downNumb = Integer.parseInt(request.getParameter("downnumb"));
	        System.out.println(downNumb);
	        String startPointString = new String(request.getParameter("startpoint").getBytes("ISO-8859-1"),"utf-8");;
	        String endPointString = new String(request.getParameter("endpoint").getBytes("ISO-8859-1"),"utf-8");;
			SharedRouteModel sharedRouteModel = new SharedRouteModel();
			sharedRouteModel.setId(sharedRouteId);
			sharedRouteModel.setDown(downNumb+1);
	        RouteInfoModel routeInfoModel = new RouteInfoModel();
	        routeInfoModel.setStartPointString(startPointString);
	        routeInfoModel.setEndPointString(endPointString);
			if (new SharedRouteBll().addDownNumbBll(sharedRouteModel)) {
		          List<SharedRouteModel> sharedRouteModelList = new SharedRouteBll().getSharedRouteListByRouteInfoBll(routeInfoModel);
		          request.setAttribute("startpoint",startPointString);
		          request.setAttribute("endpoint",endPointString);
		          request.setAttribute("sharedroutemodellist", sharedRouteModelList);
		          request.getRequestDispatcher("../index.jsp").forward(request, response);
			}else {
				response.setContentType("text/html");
				  response.setCharacterEncoding("utf-8");
				  PrintWriter out = response.getWriter();
				  out.println("{\"data\":\"�ɹ�\"}");
				  out.flush();
				  out.close();
				System.out.println("false");
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
