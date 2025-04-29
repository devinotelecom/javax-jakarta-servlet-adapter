package com.devinotele.servletbridge;

import lombok.RequiredArgsConstructor;
import lombok.val;

import javax.servlet.http.HttpSessionBindingListener;

@RequiredArgsConstructor
public class HttpSessionBindingListenerAdapter implements HttpSessionBindingListener, IJakarta<jakarta.servlet.http.HttpSessionBindingListener> {
	private final jakarta.servlet.http.HttpSessionBindingListener jakartaListener;

	@Override
	public jakarta.servlet.http.HttpSessionBindingListener unwrap () {
		return jakartaListener;
	}

	@Override
	public void valueBound (javax.servlet.http.HttpSessionBindingEvent event) {
		val jakartaEvent = new jakarta.servlet.http.HttpSessionBindingEvent(
				IJakarta.unwrap(event.getSession(), jakarta.servlet.http.HttpSession.class),
				event.getName(),
				event.getValue()
			);
		jakartaListener.valueBound(jakartaEvent);
	}

	@Override
	public void valueUnbound (javax.servlet.http.HttpSessionBindingEvent event) {
		val jakartaEvent = new jakarta.servlet.http.HttpSessionBindingEvent(
				IJakarta.unwrap(event.getSession(), jakarta.servlet.http.HttpSession.class),
				event.getName(),
				event.getValue()
			);
		jakartaListener.valueUnbound(jakartaEvent);
	}
}