package com.example.web;

import java.awt.Event;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		Object value = event.getValue();

		System.out.println("Attribute added: " + name + ": " + value);
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		Object value = event.getValue();

		System.out.println("Attribute added: " + name + ": " + value);
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		Object value = event.getValue();

		System.out.println("Attribute added: " + name + ": " + value);
	}

}
