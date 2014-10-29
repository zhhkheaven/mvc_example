package com.example.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public  class SessionCounter implements HttpSessionListener {
	static private int activeSessions;

	public static int getActiveSession() {
		return activeSessions;
	}

	public void sessionCreated(HttpSessionEvent event) {
		activeSessions++;
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		activeSessions--;
	}
}
