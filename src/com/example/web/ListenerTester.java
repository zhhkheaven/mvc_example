package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListenerTester extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("test context attributes set by Listener<br>");
		out.println("<br>");
		Dog dog = (Dog) getServletContext().getAttribute("dog");
		out.println("Dog's breed is :"+ dog.getBreed());
		out.println("<a href='http://127.0.0.1:8080/mvc_example/'>index.html</a>");
		
	}
}
