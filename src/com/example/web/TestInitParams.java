package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.ContextConfig;
import org.apache.tomcat.util.descriptor.web.ContextResource;

public class TestInitParams extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("test init parameters<br>");
		//The getServletConfig() will not get The parameter name of context
		java.util.Enumeration e = getServletConfig().getInitParameterNames();
		while (e.hasMoreElements()) {
			out.println("<br>param name = " + e.nextElement() + "<br>");
		}
		out.println("main email is "
				+ getServletConfig().getInitParameter("mainEmail"));
		out.println("<br>");
		out.println("admin email is "
				+ getServletConfig().getInitParameter("adminEmail"));
		out.println("<br>");
		out.println("<a href='http://127.0.0.1:8080/mvc_example/'>index.html</a>");
		out.println("<br>below view you can see the value of context:");
		ServletContext context = getServletContext();
		out.println(context.getInitParameter("contextEmail"));
		out.println("<br>context parameter names:");
		//The context parameter type is Enumeration 
		out.println(context.getInitParameterNames().nextElement());
		out.println("<br>server info:");
		out.println(context.getServerInfo());
		out.println("<br>major version:");
		out.println(context.getMajorVersion());
	}
}
