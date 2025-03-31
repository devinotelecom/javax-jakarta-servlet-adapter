package com.devinotele.servletbridge;

import jakarta.servlet.http.HttpSession;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class HttpSessionBindingListenerAdapter implements HttpSessionBindingListener {

	private final jakarta.servlet.http.HttpSessionBindingListener jakartaListener;

	public HttpSessionBindingListenerAdapter(jakarta.servlet.http.HttpSessionBindingListener jakartaListener) {
		this.jakartaListener = jakartaListener;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		jakarta.servlet.http.HttpSessionBindingEvent jakartaEvent =
			new jakarta.servlet.http.HttpSessionBindingEvent(
				(HttpSession) new HttpSessionAdapter((HttpSession) event.getSession()),
				event.getName(),
				event.getValue()
			);
		jakartaListener.valueBound(jakartaEvent);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		jakarta.servlet.http.HttpSessionBindingEvent jakartaEvent =
			new jakarta.servlet.http.HttpSessionBindingEvent(
				(HttpSession) new HttpSessionAdapter((HttpSession) event.getSession()),
				event.getName(),
				event.getValue()
			);
		jakartaListener.valueUnbound(jakartaEvent);
	}
}
