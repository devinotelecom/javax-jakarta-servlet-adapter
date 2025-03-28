package com.devinotele.servletbridge;

import jakarta.servlet.ServletException;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

public class HttpServletRequestWrapperAdapter extends HttpServletRequestWrapper {

	private final jakarta.servlet.http.HttpServletRequestWrapper jakartaWrapper;

	public HttpServletRequestWrapperAdapter(HttpServletRequest request, jakarta.servlet.http.HttpServletRequestWrapper jakartaWrapper) {
		super(request);
		this.jakartaWrapper = jakartaWrapper;
	}

	@Override
	public Object getAttribute(String name) {
		return jakartaWrapper.getAttribute(name);
	}

	@Override
	public String getCharacterEncoding() {
		return jakartaWrapper.getCharacterEncoding();
	}

	@Override
	public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
		jakartaWrapper.setCharacterEncoding(env);
	}

	@Override
	public int getContentLength() {
		return jakartaWrapper.getContentLength();
	}

	@Override
	public long getContentLengthLong() {
		return jakartaWrapper.getContentLengthLong();
	}

	@Override
	public String getContentType() {
		return jakartaWrapper.getContentType();
	}

	@Override
	public ServletInputStreamAdapter getInputStream() throws IOException {
		return new ServletInputStreamAdapter(jakartaWrapper.getInputStream());
	}

	@Override
	public String getParameter(String name) {
		return jakartaWrapper.getParameter(name);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return jakartaWrapper.getParameterMap();
	}

	@Override
	public String[] getParameterValues(String name) {
		return jakartaWrapper.getParameterValues(name);
	}

	@Override
	public String getProtocol() {
		return jakartaWrapper.getProtocol();
	}

	@Override
	public String getScheme() {
		return jakartaWrapper.getScheme();
	}

	@Override
	public String getServerName() {
		return jakartaWrapper.getServerName();
	}

	@Override
	public int getServerPort() {
		return jakartaWrapper.getServerPort();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return jakartaWrapper.getReader();
	}

	@Override
	public String getRemoteAddr() {
		return jakartaWrapper.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		return jakartaWrapper.getRemoteHost();
	}

	@Override
	public void setAttribute(String name, Object o) {
		jakartaWrapper.setAttribute(name, o);
	}

	@Override
	public void removeAttribute(String name) {
		jakartaWrapper.removeAttribute(name);
	}

	@Override
	public Locale getLocale() {
		return jakartaWrapper.getLocale();
	}

	@Override
	public boolean isSecure() {
		return jakartaWrapper.isSecure();
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		return new RequestDispatcherAdapter(jakartaWrapper.getRequestDispatcher(path));
	}

	@Override
	public int getRemotePort() {
		return jakartaWrapper.getRemotePort();
	}

	@Override
	public String getLocalName() {
		return jakartaWrapper.getLocalName();
	}

	@Override
	public String getLocalAddr() {
		return jakartaWrapper.getLocalAddr();
	}

	@Override
	public int getLocalPort() {
		return jakartaWrapper.getLocalPort();
	}

	@Override
	public ServletContextAdapter getServletContext() {
		return new ServletContextAdapter(jakartaWrapper.getServletContext());
	}

	@Override
	public boolean isAsyncStarted() {
		return jakartaWrapper.isAsyncStarted();
	}

	@Override
	public boolean isAsyncSupported() {
		return jakartaWrapper.isAsyncSupported();
	}

	@Override
	public DispatcherType getDispatcherType() {
		return DispatcherType.valueOf(jakartaWrapper.getDispatcherType().name());
	}

	@Override
	public String getAuthType() {
		return jakartaWrapper.getAuthType();
	}

	@Override
	public long getDateHeader(String name) {
		return jakartaWrapper.getDateHeader(name);
	}

	@Override
	public String getHeader(String name) {
		return jakartaWrapper.getHeader(name);
	}

	@Override
	public int getIntHeader(String name) {
		return jakartaWrapper.getIntHeader(name);
	}

	@Override
	public String getMethod() {
		return jakartaWrapper.getMethod();
	}

	@Override
	public String getPathInfo() {
		return jakartaWrapper.getPathInfo();
	}

	@Override
	public String getPathTranslated() {
		return jakartaWrapper.getPathTranslated();
	}

	@Override
	public String getContextPath() {
		return jakartaWrapper.getContextPath();
	}

	@Override
	public String getQueryString() {
		return jakartaWrapper.getQueryString();
	}

	@Override
	public String getRemoteUser() {
		return jakartaWrapper.getRemoteUser();
	}

	@Override
	public boolean isUserInRole(String role) {
		return jakartaWrapper.isUserInRole(role);
	}

	@Override
	public Principal getUserPrincipal() {
		return jakartaWrapper.getUserPrincipal();
	}

	@Override
	public String getRequestedSessionId() {
		return jakartaWrapper.getRequestedSessionId();
	}

	@Override
	public String getRequestURI() {
		return jakartaWrapper.getRequestURI();
	}

	@Override
	public StringBuffer getRequestURL() {
		return jakartaWrapper.getRequestURL();
	}

	@Override
	public String getServletPath() {
		return jakartaWrapper.getServletPath();
	}

	@Override
	public HttpSession getSession(boolean create) {
		jakarta.servlet.http.HttpSession jakartaSession = jakartaWrapper.getSession(create);
		return jakartaSession != null ? new HttpSessionAdapter(jakartaSession) : null;
	}

	@Override
	public HttpSession getSession() {
		return new HttpSessionAdapter(jakartaWrapper.getSession());
	}

	@Override
	public String changeSessionId() {
		return jakartaWrapper.changeSessionId();
	}

	@Override
	public boolean isRequestedSessionIdValid() {
		return jakartaWrapper.isRequestedSessionIdValid();
	}

	@Override
	public boolean isRequestedSessionIdFromCookie() {
		return jakartaWrapper.isRequestedSessionIdFromCookie();
	}

	@Override
	public boolean isRequestedSessionIdFromURL() {
		return jakartaWrapper.isRequestedSessionIdFromURL();
	}

	@Override
	public boolean isRequestedSessionIdFromUrl() {
		return jakartaWrapper.isRequestedSessionIdFromURL();
	}

	@Override
	public void login(String username, String password) throws ServletExceptionAdapter {
		try {
			jakartaWrapper.login(username, password);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void logout() throws ServletExceptionAdapter {
		try {
			jakartaWrapper.logout();
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Part getPart(String name) throws IOException, ServletExceptionAdapter {
		try {
			return new PartAdapter(jakartaWrapper.getPart(name));
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletExceptionAdapter {
		throw new UnsupportedOperationException("Upgrade not supported in wrapper");
	}
}
