package com.devinotele.servletbridge;

import javax.servlet.*;
import java.io.IOException;

public class ServletAdapter implements Servlet {

	private final jakarta.servlet.Servlet jakartaServlet;

	public ServletAdapter(jakarta.servlet.Servlet jakartaServlet) {
		this.jakartaServlet = jakartaServlet;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	@Override
	public ServletConfig getServletConfig() {
		return new ServletConfigAdapter(jakartaServlet.getServletConfig());
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {
			jakartaServlet.service(new JavaxToJakartaRequestAdapter(req), new JavaxToJakartaResponseAdapter(res));
		} catch (jakarta.servlet.ServletException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getServletInfo() {
		return jakartaServlet.getServletInfo();
	}

	@Override
	public void destroy() {
	jakartaServlet.destroy();
	}
}
