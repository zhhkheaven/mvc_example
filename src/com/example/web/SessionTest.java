package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTest extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("test session attributes(get)<br>");
		HttpSession session = request.getSession();

		if (session.isNew()) {
			out.println("This is a new session.<br>");
			out.println(session.getId());
		} else {
			out.println("Welcome back!");
			out.println(session.getId());
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("test session(post) <br>");
			
			HttpSession session = request.getSession(false);
			if (session == null){
					out.println("no session was aviable");
					out.println("making one....<br>");
					session = request.getSession();
					out.println(session.getId());
			} else {
				out.println("there was a session");
			}
	}
}
