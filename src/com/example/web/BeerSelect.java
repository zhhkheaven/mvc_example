package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;

public class BeerSelect  extends HttpServlet{
	//Post function
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		System.out.println("This method is doPost!");
		String c = request.getParameter("color");
		String [] sizes = request.getParameterValues("sizes");
		//Header
		int forwards =request.getIntHeader("Max-Forwards");
		//remote host
		String host = request.getRemoteHost();
		//RemotePort
		int rPort = request.getRemotePort();
		//LocalPort 
		int lPort = request.getLocalPort();
		//Server PORT 
		int sPort = request.getServerPort(); 
		//cookies 
		Cookie [] cookies = request.getCookies(); 
		System.out.println("lport:");
		System.out.println(lPort);
		System.out.println("sPort:");
		System.out.println(sPort);
		System.out.println("rPort:");
		System.out.println(rPort);
		System.out.println("host:");
		System.out.println(host);
		/*
		System.out.println("cookies:");
		for(int i=0;i<cookies.length;i++){
			System.out.println(cookies[i].getName());
			System.out.println(cookies[i].getValue());
		}
		*/
		System.out.println("forwards:");
		System.out.println(forwards);
		System.out.println("sizes values:");
		for(int i=0;i<sizes.length;i++)
			System.out.println(sizes[i]);
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
	//Get function
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		System.out.println("This method is doGet!");
		String c = request.getParameter("color");
		String [] sizes = request.getParameterValues("sizes");
		//Header
		int forwards =request.getIntHeader("Max-Forwards");
		//remote host
		String host = request.getRemoteHost();
		//RemotePort
		int rPort = request.getRemotePort();
		//LocalPort 
		int lPort = request.getLocalPort();
		//Server PORT 
		int sPort = request.getServerPort(); 
		//cookies 
		//Cookie [] cookies = request.getCookies(); 
		System.out.println("lport:");
		System.out.println(lPort);
		System.out.println("sPort:");
		System.out.println(sPort);
		System.out.println("rPort:");
		System.out.println(rPort);
		System.out.println("host:");
		System.out.println(host);
		System.out.println("cookies:");
		//System.out.println(cookies.length);
		/*
		if(cookies.length != 0){
			for(int i=0;i<cookies.length;i++){
				System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue());
			}	
		}
		*/
		System.out.println("forwards:");
		System.out.println(forwards);
		System.out.println("sizes values:");
		for(int i=0;i<sizes.length;i++)
			System.out.println(sizes[i]);
		PrintWriter out = response.getWriter();
		out.print("select color is "+c);
	}

}
