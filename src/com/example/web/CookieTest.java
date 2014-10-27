package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.Cookies;

public class CookieTest extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		//一般在servlet 中写一个方法就可以了  
		//doPost(request, response);
		//get 方法 是等幂的  post方法是非等幂的  get 方法不会对服务器上的数据造成改变
		//post 会对服务器上的数据造成改变
		System.out.println("doGet!");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		//这里当cookies 不是null的时候才会打印 正常第一次提交是不会生成cookies的
		if(cookies != null){
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if (cookie.getName().equals("username")) {
					String name = cookie.getValue();
					out.println("<br><strong>" + name + "</strong>");
					break;
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 当浏览器拒绝cookie 的时候会报空指针异常
		System.out.println("DOPOST");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		String name = request.getParameter("username");
		Cookie cookie = new Cookie("username", name);
		cookie.setMaxAge(30 * 60);
		//这里面的addCookie 在第二次请求的时候才会 显示上次设定的cookie是多少 
		response.addCookie(cookie);
		if(cookies != null ){
		RequestDispatcher view = request
				.getRequestDispatcher("cookieresult.jsp");
		view.forward(request, response);
		}else{
			System.out.println("This is the first connection");
			out.println("This is the first submit so the cookies is null,your next visit will not see this page!");
		}
	}
}
