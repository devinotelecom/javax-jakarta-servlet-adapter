package com.devinotele.servletbridge;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

public class HttpSessionBindingEventAdapter extends HttpSessionBindingEvent {

	private final jakarta.servlet.http.HttpSessionBindingEvent jakartaEvent;

	public HttpSessionBindingEventAdapter(HttpSession session, String name, jakarta.servlet.http.HttpSessionBindingEvent jakartaEvent) {
		super(session, name);
		this.jakartaEvent = jakartaEvent;
	}

	@Override
	public HttpSession getSession() {
		return new HttpSessionAdapter(jakartaEvent.getSession());
	}

	@Override
	public String getName() {
		return jakartaEvent.getName();
	}

	@Override
	public Object getValue() {
		return jakartaEvent.getValue();
	}

	@Override
	public String toString() {
		return jakartaEvent.toString();
	}
}
