package com.devinotele.servletbridge;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

public class HttpSessionAdapter implements HttpSession {

	private final jakarta.servlet.http.HttpSession jakartaSession;

	public HttpSessionAdapter(jakarta.servlet.http.HttpSession jakartaSession) {
		this.jakartaSession = jakartaSession;
	}

	@Override
	public long getCreationTime() {
		return jakartaSession.getCreationTime();
	}

	@Override
	public String getId() {
		return jakartaSession.getId();
	}

	@Override
	public long getLastAccessedTime() {
		return jakartaSession.getLastAccessedTime();
	}

	@Override
	public ServletContext getServletContext() {
		return null;
	}

	@Override
	public int getMaxInactiveInterval() {
		return jakartaSession.getMaxInactiveInterval();
	}

	@Override
	public HttpSessionContext getSessionContext() {
		return null;
	}

	@Override
	public void setMaxInactiveInterval(int interval) {
		jakartaSession.setMaxInactiveInterval(interval);
	}

	@Override
	public Object getAttribute(String name) {
		return jakartaSession.getAttribute(name);
	}

	@Override
	public Object getValue(String name) {
		return null;
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		return jakartaSession.getAttributeNames();
	}

	@Override
	public String[] getValueNames() {
		return new String[0];
	}

	@Override
	public void setAttribute(String name, Object value) {
		jakartaSession.setAttribute(name, value);
	}

	@Override
	public void putValue(String name, Object value) {

	}

	@Override
	public void removeAttribute(String name) {
		jakartaSession.removeAttribute(name);
	}

	@Override
	public void removeValue(String name) {

	}

	@Override
	public void invalidate() {
		jakartaSession.invalidate();
	}

	@Override
	public boolean isNew() {
		return jakartaSession.isNew();
	}
}