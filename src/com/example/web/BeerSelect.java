package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;

public class BeerSelect  extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		String c = request.getParameter("color");
		BeerExpert be = new BeerExpert();
		List result = be.getBrands(c);
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("Beer Selection Advice<br>");
//		Iterator it = result.iterator();
//		while(it.hasNext()){
//			out.print("<br>try: "+it.next());
//		}
		
		//out.println("<br>Got beer color "+ c);
		request.setAttribute("styles",result);
	    System.out.println(result);
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request,response);
	}

}
