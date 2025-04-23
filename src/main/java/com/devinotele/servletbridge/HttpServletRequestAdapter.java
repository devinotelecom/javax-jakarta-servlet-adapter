package com.devinotele.servletbridge;

import lombok.RequiredArgsConstructor;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 @see javax.servlet.http.HttpServletRequestWrapper
 @see jakarta.servlet.http.HttpServletRequestWrapper
 */
@RequiredArgsConstructor
public class HttpServletRequestAdapter implements HttpServletRequest, IJakarta<jakarta.servlet.http.HttpServletRequest> {
	private final jakarta.servlet.http.HttpServletRequest jakartaRequest;

	@Override
	public jakarta.servlet.http.HttpServletRequest unwrap () { return jakartaRequest; }

	@Override
	public String getAuthType() { return jakartaRequest.getAuthType(); }

	@Override
	public javax.servlet.http.Cookie[] getCookies() {
		jakarta.servlet.http.Cookie[] jakartaCookies = jakartaRequest.getCookies();
		if (jakartaCookies == null){
			return null;
		}
		javax.servlet.http.Cookie[] javaxCookies = new javax.servlet.http.Cookie[jakartaCookies.length];
		for (int i = 0; i < jakartaCookies.length; i++){
			jakarta.servlet.http.Cookie jakartaCookie = jakartaCookies[i];
			javaxCookies[i] = new javax.servlet.http.Cookie(jakartaCookie.getName(), jakartaCookie.getValue());
		}
		return javaxCookies;
	}

	@Override
	public long getDateHeader(String name) {
		return jakartaRequest.getDateHeader(name);
	}

	@Override
	public String getHeader(String name) {
		return jakartaRequest.getHeader(name);
	}

	@Override
	public Enumeration<String> getHeaders(String name) {
		return jakartaRequest.getHeaders(name);
	}

	@Override
	public Enumeration<String> getHeaderNames() {
		return jakartaRequest.getHeaderNames();
	}

	@Override
	public int getIntHeader(String name) {
		return jakartaRequest.getIntHeader(name);
	}

	@Override
	public String getMethod() {
		return jakartaRequest.getMethod();
	}

	@Override
	public String getPathInfo() {
		return jakartaRequest.getPathInfo();
	}

	@Override
	public String getPathTranslated() {
		return jakartaRequest.getPathTranslated();
	}

	@Override
	public String getContextPath() {
		return jakartaRequest.getContextPath();
	}

	@Override
	public String getQueryString() {
		return jakartaRequest.getQueryString();
	}

	@Override
	public String getRemoteUser() {
		return jakartaRequest.getRemoteUser();
	}

	@Override
	public boolean isUserInRole(String role) {
		return jakartaRequest.isUserInRole(role);
	}

	@Override
	public Principal getUserPrincipal() {
		return jakartaRequest.getUserPrincipal();
	}

	@Override
	public String getRequestedSessionId() {
		return jakartaRequest.getRequestedSessionId();
	}

	@Override
	public String getRequestURI() {
		return jakartaRequest.getRequestURI();
	}

	@Override
	public StringBuffer getRequestURL() {
		return jakartaRequest.getRequestURL();
	}

	@Override
	public String getServletPath() {
		return jakartaRequest.getServletPath();
	}

	@Override
	public javax.servlet.http.HttpSession getSession(boolean create) {
		return new HttpSessionAdapter(jakartaRequest.getSession(create));
	}

	@Override
	public javax.servlet.http.HttpSession getSession() {
		return new HttpSessionAdapter(jakartaRequest.getSession());
	}

	@Override
	public String changeSessionId() {
		return jakartaRequest.changeSessionId();
	}

	@Override
	public boolean isRequestedSessionIdValid() {
		return jakartaRequest.isRequestedSessionIdValid();
	}

	@Override
	public boolean isRequestedSessionIdFromCookie() {
		return jakartaRequest.isRequestedSessionIdFromCookie();
	}

	@Override
	public boolean isRequestedSessionIdFromURL() {
		return jakartaRequest.isRequestedSessionIdFromURL();
	}

	@Override  @Deprecated
	public boolean isRequestedSessionIdFromUrl() {
		return jakartaRequest.isRequestedSessionIdFromURL();
	}

	@Override
	public boolean authenticate (javax.servlet.http.HttpServletResponse response) throws IOException, javax.servlet.ServletException {
		jakarta.servlet.http.HttpServletResponse jakartaResponse = IJakarta.unwrap(response);
		try {
			return jakartaRequest.authenticate(jakartaResponse);
		} catch (jakarta.servlet.ServletException e){
			throw new javax.servlet.ServletException(e);
		}
	}

	@Override
	public void login(String username, String password) throws javax.servlet.ServletException {
		try {
			jakartaRequest.login(username, password);
		} catch (jakarta.servlet.ServletException e){
			throw new javax.servlet.ServletException(e);
		}
	}

	@Override
	public void logout() throws javax.servlet.ServletException {
		try {
			jakartaRequest.logout();
		} catch (jakarta.servlet.ServletException e){
			throw new javax.servlet.ServletException(e);
		}
	}

	@Override
	public Collection<javax.servlet.http.Part> getParts() throws IOException, javax.servlet.ServletException {
		Collection<jakarta.servlet.http.Part> jakartaParts;
		try {
			jakartaParts = jakartaRequest.getParts();
		} catch (jakarta.servlet.ServletException e){
			throw new javax.servlet.ServletException(e);
		}
		Collection<javax.servlet.http.Part> javaxParts = new ArrayList<>();
		for (jakarta.servlet.http.Part jakartaPart : jakartaParts){
			javaxParts.add(new PartAdapter(jakartaPart));
		}
		return javaxParts;
	}

	@Override
	public javax.servlet.http.Part getPart(String name) throws IOException, javax.servlet.ServletException {
		jakarta.servlet.http.Part jakartaPart;
		try {
			jakartaPart = jakartaRequest.getPart(name);
		} catch (jakarta.servlet.ServletException e){
			throw new javax.servlet.ServletException(e);
		}
		return new PartAdapter(jakartaPart);
	}

	@Override
	public <T extends javax.servlet.http.HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, javax.servlet.ServletException {
		return null;// jakartaRequest.upgrade(handlerClass);
	}

	@Override
	public Object getAttribute(String name) {
		return jakartaRequest.getAttribute(name);
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		return jakartaRequest.getAttributeNames();
	}

	@Override
	public String getCharacterEncoding() {
		return jakartaRequest.getCharacterEncoding();
	}

	@Override
	public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
		jakartaRequest.setCharacterEncoding(env);
	}

	@Override
	public int getContentLength() {
		return jakartaRequest.getContentLength();
	}

	@Override
	public long getContentLengthLong() {
		return jakartaRequest.getContentLengthLong();
	}

	@Override
	public String getContentType() {
		return jakartaRequest.getContentType();
	}

	@Override
	public javax.servlet.ServletInputStream getInputStream() throws IOException {
		return new ServletInputStreamAdapter(jakartaRequest.getInputStream());
	}

	@Override
	public String getParameter(String name) {
		return jakartaRequest.getParameter(name);
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return jakartaRequest.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String name) {
		return jakartaRequest.getParameterValues(name);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return jakartaRequest.getParameterMap();
	}

	@Override
	public String getProtocol() {
		return jakartaRequest.getProtocol();
	}

	@Override
	public String getScheme() {
		return jakartaRequest.getScheme();
	}

	@Override
	public String getServerName() {
		return jakartaRequest.getServerName();
	}

	@Override
	public int getServerPort() {
		return jakartaRequest.getServerPort();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return jakartaRequest.getReader();
	}

	@Override
	public String getRemoteAddr() {
		return jakartaRequest.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		return jakartaRequest.getRemoteHost();
	}

	@Override
	public void setAttribute(String name, Object o) {
		jakartaRequest.setAttribute(name, o);
	}

	@Override
	public void removeAttribute(String name) {
		jakartaRequest.removeAttribute(name);
	}

	@Override
	public Locale getLocale() {
		return jakartaRequest.getLocale();
	}

	@Override
	public Enumeration<Locale> getLocales() {
		return jakartaRequest.getLocales();
	}

	@Override
	public boolean isSecure() {
		return jakartaRequest.isSecure();
	}

	@Override
	public javax.servlet.RequestDispatcher getRequestDispatcher(String path) {
		return new RequestDispatcherAdapter(jakartaRequest.getRequestDispatcher(path));
	}

	@Override
	public String getRealPath(String path) {
		return jakartaRequest.getServletContext().getRealPath(path);
	}

	@Override
	public int getRemotePort() {
		return jakartaRequest.getRemotePort();
	}

	@Override
	public String getLocalName() {
		return jakartaRequest.getLocalName();
	}

	@Override
	public String getLocalAddr() {
		return jakartaRequest.getLocalAddr();
	}

	@Override
	public int getLocalPort() {
		return jakartaRequest.getLocalPort();
	}

	@Override
	public ServletContext getServletContext() {
		return new ServletContextAdapter(jakartaRequest.getServletContext());
	}

	@Override
	public AsyncContext startAsync() throws IllegalStateException {
		return new AsyncContextAdapter(jakartaRequest.startAsync());
	}

	@Override
	public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
		return null;//new JakartaToJavaxAsyncContextAdapter(jakartaRequest.startAsync(
			//new JakartaToJavaxRequestAdapter((jakarta.servlet.http.HttpServletRequest) servletRequest),
			//new JakartaToJavaxResponseAdapter((jakarta.servlet.http.HttpServletResponse) servletResponse)
		//));
	}

	@Override
	public AsyncContext getAsyncContext() {
		return new AsyncContextAdapter(jakartaRequest.getAsyncContext());
	}

	@Override
	public boolean isAsyncStarted() {
		return jakartaRequest.isAsyncStarted();
	}

	@Override
	public boolean isAsyncSupported() {
		return jakartaRequest.isAsyncSupported();
	}

	@Override
	public DispatcherType getDispatcherType() {
		jakarta.servlet.DispatcherType jakartaDispatcherType = jakartaRequest.getDispatcherType();
		return DispatcherType.valueOf(jakartaDispatcherType.name());
	}
}