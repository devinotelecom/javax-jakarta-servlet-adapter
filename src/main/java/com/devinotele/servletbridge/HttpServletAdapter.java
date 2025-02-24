package com.devinotele.servletbridge;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpServletAdapter extends HttpServlet {
	private final javax.servlet.http.HttpServlet legacyServlet;

	public HttpServletAdapter(javax.servlet.http.HttpServlet legacyServlet) {
		this.legacyServlet = legacyServlet;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			javax.servlet.http.HttpServletRequest javaxRequest = new JakartaToJavaxRequestAdapter(req);
			javax.servlet.http.HttpServletResponse javaxResponse = new JakartaToJavaxResponseAdapter(resp);

			legacyServlet.service(javaxRequest, javaxResponse);
		} catch (javax.servlet.ServletException e) {
			throw new ServletException(e);
		}
	}
}
