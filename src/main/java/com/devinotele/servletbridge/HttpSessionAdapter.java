package com.devinotele.servletbridge;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpSessionAdapter implements HttpSession, IJakarta<jakarta.servlet.http.HttpSession> {
	private final jakarta.servlet.http.HttpSession jakartaSession;

	public static @Nullable HttpSessionAdapter of (jakarta.servlet.http.@Nullable HttpSession jakartaSession) {
		return jakartaSession == null ? null
				: new HttpSessionAdapter(jakartaSession);
	}

	@Override public jakarta.servlet.http.HttpSession unwrap (){ return jakartaSession; }

	@Override
	public long getCreationTime() {
		return jakartaSession.getCreationTime();
	}

	@Override public String getId (){ return jakartaSession.getId(); }

	@Override
	public long getLastAccessedTime() {
		return jakartaSession.getLastAccessedTime();
	}

	@Override
	public ServletContext getServletContext() {
		return new ServletContextAdapter(jakartaSession.getServletContext());
	}

	@Override
	public int getMaxInactiveInterval() {
		return jakartaSession.getMaxInactiveInterval();
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
	public Object getValue (String name) {
		return jakartaSession.getAttribute(name);
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
		setAttribute(name, value);
	}

	@Override
	public void removeAttribute(String name) {
		jakartaSession.removeAttribute(name);
	}

	@Override
	public void removeValue(String name) {
		removeAttribute(name);
	}

	@Override
	public void invalidate() {
		jakartaSession.invalidate();
	}

	@Override public boolean isNew (){ return jakartaSession.isNew(); }
}