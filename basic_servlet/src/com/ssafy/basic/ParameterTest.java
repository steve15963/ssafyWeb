package com.ssafy.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

/**
 * Servlet implementation class ParameterTest
 */
@WebServlet("/param")
public class ParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String [] fruit = request.getParameterValues("fruit");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Hello servlet!!!");
		out.println("안녕 서블릿!!!");
		out.println(username + "님 비번은 "+ userpwd +"이고 좋아하는 과일은" + Arrays.toString(fruit) +"입니다.");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
//		String username = request.getParameter("username");
//		String userpwd = request.getParameter("userpwd");
//		String [] fruit = request.getParameterValues("fruit");
//		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<body>");
//		out.println("Hello servlet!!!");
//		out.println("안녕 서블릿!!!");
//		out.println(username + "님 비번은 "+ userpwd +"이고 좋아하는 과일은" + Arrays.toString(fruit) +"입니다.");
//		out.println("</body>");
//		out.println("</html>");
	}

}
