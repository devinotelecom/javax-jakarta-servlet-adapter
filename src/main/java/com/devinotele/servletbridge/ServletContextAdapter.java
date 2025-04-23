package com.devinotele.servletbridge;

import lombok.RequiredArgsConstructor;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.descriptor.JspConfigDescriptor;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class ServletContextAdapter implements ServletContext, IJakarta<jakarta.servlet.ServletContext> {
	private final jakarta.servlet.ServletContext jakartaContext;

	@Override public jakarta.servlet.ServletContext unwrap () { return jakartaContext; }

	@Override
	public String getContextPath() {
		return jakartaContext.getContextPath();
	}

	@Override
	public ServletContext getContext(String uripath) {
		return new ServletContextAdapter(jakartaContext.getContext(uripath));
	}

	@Override
	public int getMajorVersion() {
		return jakartaContext.getMajorVersion();
	}

	@Override
	public int getMinorVersion() {
		return jakartaContext.getMinorVersion();
	}

	@Override
	public int getEffectiveMajorVersion() {
		return jakartaContext.getEffectiveMajorVersion();
	}

	@Override
	public int getEffectiveMinorVersion() {
		return jakartaContext.getEffectiveMinorVersion();
	}

	@Override
	public String getMimeType(String file) {
		return jakartaContext.getMimeType(file);
	}

	@Override
	public Set<String> getResourcePaths(String path) {
		return jakartaContext.getResourcePaths(path);
	}

	@Override
	public URL getResource(String path) throws MalformedURLException {
		return jakartaContext.getResource(path);
	}

	@Override
	public InputStream getResourceAsStream(String path) {
		return jakartaContext.getResourceAsStream(path);
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		return new RequestDispatcherAdapter(jakartaContext.getRequestDispatcher(path));
	}

	@Override
	public RequestDispatcher getNamedDispatcher(String name) {
		return new RequestDispatcherAdapter(jakartaContext.getNamedDispatcher(name));
	}

	@Override  @Deprecated
	public Servlet getServlet(String name) throws ServletException {
		return null;//нет такого метода
	}

	@Override
	public Enumeration<Servlet> getServlets() {
		return null;//нет такого метода
	}

	@Override  @Deprecated
	public Enumeration<String> getServletNames() {
		return null;//нет такого метода
	}

	@Override
	public void log(String msg) {
		jakartaContext.log(msg);
	}

	@Override  @Deprecated
	public void log(Exception exception, String msg) {
		jakartaContext.log(msg, exception);
	}

	@Override
	public void log(String message, Throwable throwable) {
		jakartaContext.log(message, throwable);
	}

	@Override
	public String getRealPath(String path) {
		return jakartaContext.getRealPath(path);
	}

	@Override
	public String getServerInfo() {
		return jakartaContext.getServerInfo();
	}

	@Override
	public String getInitParameter(String name) {
		return jakartaContext.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return jakartaContext.getInitParameterNames();
	}

	@Override
	public boolean setInitParameter(String name, String value) {
		return jakartaContext.setInitParameter(name, value);
	}

	@Override
	public Object getAttribute(String name) {
		return jakartaContext.getAttribute(name);
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		return jakartaContext.getAttributeNames();
	}

	@Override
	public void setAttribute(String name, Object object) {
		jakartaContext.setAttribute(name, object);
	}

	@Override
	public void removeAttribute(String name) {
		jakartaContext.removeAttribute(name);
	}

	@Override
	public String getServletContextName() {
		return jakartaContext.getServletContextName();
	}

	@Override
	public ServletRegistration.Dynamic addServlet(String servletName, String className) {
		return new ServletRegistrationDynamicAdapter(jakartaContext.addServlet(servletName, className));
	}

	@Override
	public ServletRegistration.Dynamic addServlet(String servletName, Servlet servlet) {
		return null;//ServletRegistrationDynamicAdapter(jakartaContext.addServlet(servletName, servlet));
	}

	@Override
	public ServletRegistration.Dynamic addServlet(String servletName, Class<? extends Servlet> servletClass) {
		return null;//ServletRegistrationDynamicAdapter(jakartaContext.addServlet(servletName, servletClass));
	}

	@Override
	public ServletRegistration.Dynamic addJspFile(String servletName, String jspFile) {
		return new ServletRegistrationDynamicAdapter(jakartaContext.addJspFile(servletName, jspFile));
	}

	@Override
	public <T extends Servlet> T createServlet(Class<T> clazz) throws ServletException {
		return null;//new ServletAdapter(jakartaContext.createServlet(clazz));
	}

	@Override
	public ServletRegistration getServletRegistration(String servletName) {
		return new ServletRegistrationAdapter(jakartaContext.getServletRegistration(servletName));
	}

	@Override
	public Map<String, ? extends ServletRegistration> getServletRegistrations() {
		Map<String, ? extends jakarta.servlet.ServletRegistration> jakartaRegistrations = jakartaContext.getServletRegistrations();
		Map<String, ServletRegistration> javaxRegistrations = new HashMap<>();

		for (Map.Entry<String, ? extends jakarta.servlet.ServletRegistration> entry : jakartaRegistrations.entrySet()) {
			String key = entry.getKey();
			jakarta.servlet.ServletRegistration jakartaRegistration = entry.getValue();
			ServletRegistration javaxRegistration = new ServletRegistrationAdapter(jakartaRegistration);
			javaxRegistrations.put(key, javaxRegistration);
		}

		return javaxRegistrations;
	}

	@Override
	public FilterRegistration.Dynamic addFilter(String filterName, String className) {
		return new FilterRegistrationDynamicAdapter(jakartaContext.addFilter(filterName, className));
	}

	@Override
	public FilterRegistration.Dynamic addFilter(String filterName, Filter filter) {
		return null;//jakartaContext.addFilter(filterName, filter);
	}

	@Override
	public FilterRegistration.Dynamic addFilter(String filterName, Class<? extends Filter> filterClass) {
		return null;//jakartaContext.addFilter(filterName, filterClass);
	}

	@Override
	public <T extends Filter> T createFilter(Class<T> clazz) throws ServletException {
		return null;// jakartaContext.createFilter(clazz);
	}

	@Override
	public FilterRegistration getFilterRegistration(String filterName) {
		return new FilterRegistrationAdapter(jakartaContext.getFilterRegistration(filterName));
	}

	@Override
	public Map<String, ? extends FilterRegistration> getFilterRegistrations() {
		Map<String, ? extends jakarta.servlet.FilterRegistration> jakartaRegistrations = jakartaContext.getFilterRegistrations();
		Map<String, FilterRegistration> javaxRegistrations = new HashMap<>();

		for (Map.Entry<String, ? extends jakarta.servlet.FilterRegistration> entry : jakartaRegistrations.entrySet()) {
			String key = entry.getKey();
			jakarta.servlet.FilterRegistration jakartaRegistration = entry.getValue();
			FilterRegistration javaxRegistration = new FilterRegistrationAdapter(jakartaRegistration);
			javaxRegistrations.put(key, javaxRegistration);
		}

		return javaxRegistrations;
	}

	@Override
	public SessionCookieConfig getSessionCookieConfig() {
		return new SessionCookieConfigAdapter(jakartaContext.getSessionCookieConfig());
	}

	@Override
	public void setSessionTrackingModes(Set<SessionTrackingMode> sessionTrackingModes) {
		//jakartaContext.setSessionTrackingModes(sessionTrackingModes);
	}

	@Override
	public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
		return null;//jakartaContext.getDefaultSessionTrackingModes();
	}

	@Override
	public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
		return null;// jakartaContext.getEffectiveSessionTrackingModes();
	}

	@Override
	public void addListener(String className) {
		jakartaContext.addListener(className);
	}

	@Override
	public <T extends EventListener> void addListener(T t) {
		jakartaContext.addListener(t);
	}

	@Override
	public void addListener(Class<? extends EventListener> listenerClass) {
		jakartaContext.addListener(listenerClass);
	}

	@Override
	public <T extends EventListener> T createListener(Class<T> clazz) throws ServletException {
		try {
			return jakartaContext.createListener(clazz);
		} catch (jakarta.servlet.ServletException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public JspConfigDescriptor getJspConfigDescriptor() {
		return new JspConfigDescriptorAdapter(jakartaContext.getJspConfigDescriptor());
	}

	@Override
	public ClassLoader getClassLoader() {
		return jakartaContext.getClassLoader();
	}

	@Override
	public void declareRoles(String... roleNames) {
		jakartaContext.declareRoles(roleNames);
	}

	@Override
	public String getVirtualServerName() {
		return jakartaContext.getVirtualServerName();
	}

	@Override
	public int getSessionTimeout() {
		return jakartaContext.getSessionTimeout();
	}

	@Override
	public void setSessionTimeout(int sessionTimeout) {
		jakartaContext.getSessionTimeout();
	}

	@Override
	public String getRequestCharacterEncoding() {
		return jakartaContext.getRequestCharacterEncoding();
	}

	@Override
	public void setRequestCharacterEncoding(String encoding) {
		jakartaContext.setRequestCharacterEncoding(encoding);
	}

	@Override
	public String getResponseCharacterEncoding() {
		return jakartaContext.getRequestCharacterEncoding();
	}

	@Override
	public void setResponseCharacterEncoding(String encoding) {
		jakartaContext.setRequestCharacterEncoding(encoding);
	}
}