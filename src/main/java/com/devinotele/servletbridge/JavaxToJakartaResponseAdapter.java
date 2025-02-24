package com.devinotele.servletbridge;

import jakarta.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class JavaxToJakartaResponseAdapter extends HttpServletResponseWrapper {

	private final javax.servlet.http.HttpServletResponse javaxResponse;

	public JavaxToJakartaResponseAdapter(javax.servlet.http.HttpServletResponse response) {
		super(null); // HttpServletResponseWrapper требует передачи jakarta.servlet.http.HttpServletResponse
		this.javaxResponse = response;
	}

	@Override
	public void setStatus(int sc) {
		javaxResponse.setStatus(sc);
	}

	@Override
	public void setHeader(String name, String value) {
		javaxResponse.setHeader(name, value);
	}

	@Override
	public void sendError(int sc, String msg) throws IOException {
		javaxResponse.sendError(sc, msg);
	}
}