package com.example.web;

import java.awt.Event;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		ServletContext sc = event.getServletContext();
		String dogBreed = sc.getInitParameter("breed");
		Dog d = new Dog(dogBreed);
		sc.setAttribute("dog", d);
		
		

	}

}
