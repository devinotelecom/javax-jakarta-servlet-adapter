package com.devinotele.servletbridge;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

public class HttpSessionBindingEventAdapter extends HttpSessionBindingEvent implements IJakarta<jakarta.servlet.http.HttpSessionBindingEvent> {
	private final jakarta.servlet.http.HttpSessionBindingEvent jakartaEvent;

	public HttpSessionBindingEventAdapter (javax.servlet.http.HttpSession session, String name, jakarta.servlet.http.HttpSessionBindingEvent jakartaEvent) {
		super(session, name);
		this.jakartaEvent = jakartaEvent;
	}//new

	@Override
	public jakarta.servlet.http.HttpSessionBindingEvent unwrap () {
		return jakartaEvent;
	}

	@Override
	public HttpSession getSession() {
		return HttpSessionAdapter.of(jakartaEvent.getSession());
	}

	@Override public String getName (){ return jakartaEvent.getName(); }

	@Override
	public Object getValue() {
		return jakartaEvent.getValue();
	}

	@Override
	public String toString() {
		return jakartaEvent.toString();
	}
}