package com.ssafy.ws.step3.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.ws.step3.dto.Book;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public MainServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	proccess(request, response);
    }

    private void proccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// parameter book data read -> Book객체 생성 -> 응답
    	response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if(action.equals("regist")) 
			doRegister(request, response);
//		if(action.equals("list")) 
//			doList(request, response);
	}

//    private void doList(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		
//	}

	//data valid check, business method 호출, 일정 scope에 데이터저장, view select
	private void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
		
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()) {
			String name = params.nextElement();
			String value = request.getParameter(name);
			System.out.println(name+" : "+value);
		}
		//String [] values = request.getParmeterVakyes("checkbox");
		
		Book book = new Book();
		//Book book = new Book(isbn, title, author, price, desc);
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setAuthor(author);
		book.setDesc(desc);
		book.setPrice(price);
		
		//service호출->dao호출->db에 insert
//		PrintWriter out = response.getWriter();
//		out.println(book.toString());
		// request scope에 book데이터 저장
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("regist_result.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		proccess(request, response);
	}

}
