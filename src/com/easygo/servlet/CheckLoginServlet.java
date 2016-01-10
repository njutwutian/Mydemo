package com.easygo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.easygo.model.UserModel;
import com.easygo.bll.LoginBll;

public class CheckLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckLoginServlet() {
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
        System.out.println("==========================");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		System.out.println("=============DOPOST=============");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserModel userModel = new UserModel();
		userModel.setNameString(username);
		userModel.setPasswordString(password);
		if (new LoginBll().checkLoginBll(userModel)) {
			  userModel.setId(new LoginBll().getIdByUserModelBll(userModel).getId());
		      //将用户ID账号放入SESSION
			  request.getSession().setAttribute("id",userModel.getId());
		      request.getSession().setAttribute("username", userModel.getNameString());
		      
			  response.setContentType("text/html");
			  response.setCharacterEncoding("UTF-8");
			  PrintWriter out = response.getWriter();
			  out.println("{\"data\":\"登录成功\",\"flag\":\"1\"}");
			  out.flush();
			  out.close();
		}
		else {
		  response.setContentType("text/html");
		  response.setCharacterEncoding("UTF-8");
		  PrintWriter out = response.getWriter();
		  out.println("{\"data\":\"用户名密码错误\",\"flag\":\"0\"}");
		  out.flush();
		  out.close();
		}
		//request.getRequestDispatcher("../index.jsp").forward(request, response);
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
