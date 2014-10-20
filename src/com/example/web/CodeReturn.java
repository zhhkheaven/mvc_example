package com.example.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeReturn extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			//every function means;
		 	response.setContentType("application/jar");
		 	ServletContext ctx = getServletContext();
		 	InputStream is = ctx.getResourceAsStream("/test.jar");
		 	
		 	int read = 0;
		 	byte[] bytes = new byte[1024];
		 	OutputStream os = response.getOutputStream();
		 	while((read = is.read(bytes)) != -1){
		 		os.write(bytes,0,read);
		 	}
		 	os.flush();
		 	os.close();
	}

}
