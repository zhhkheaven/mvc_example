package com.example.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.OS;
import org.omg.CORBA.PUBLIC_MEMBER;

public class CodeReturn extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// every function means;
		String types = request.getParameter("types");
		InputStream is = null;
		OutputStream os = null;
		if (types.equals("txt")) {
			response.setContentType("text/html");
			ServletContext ctx = getServletContext();
			is = ctx.getResourceAsStream("/test.txt");
		} else if (types.equals("jar")) {
			response.setContentType("application/jar");
			ServletContext ctx = getServletContext();
			is = ctx.getResourceAsStream("/test.jar");
		} else if (types.equals("unknow")) {
			response.sendRedirect("http://www.binaryw.com");
		} else if (types.equals("error.html")) {
			// redirect
			response.sendRedirect("/mvc_example/error.html");
		} else if (types.equals("test-error.html")) {
			response.sendRedirect("test/error.html");
		}
		if (types.equals("jar") || types.equals("txt")) {
			int read = 0;
			byte[] bytes = new byte[1024];
			os = response.getOutputStream();
			while ((read = is.read(bytes)) != -1) {
				os.write(bytes, 0, read);
			}
			os.flush();
			os.close();
			is.close();
			read = 0;
		}

		/*
		 * ServletContext ctx = getServletContext(); InputStream is =
		 * ctx.getResourceAsStream("/test.jar");
		 * 
		 * int read = 0; byte[] bytes = new byte[1024]; OutputStream os =
		 * response.getOutputStream(); while((read = is.read(bytes)) != -1){
		 * os.write(bytes,0,read); } os.flush(); os.close();
		 */
	}

}
