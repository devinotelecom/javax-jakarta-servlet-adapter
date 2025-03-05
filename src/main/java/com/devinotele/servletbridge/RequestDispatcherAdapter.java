package com.devinotele.servletbridge;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class RequestDispatcherAdapter implements RequestDispatcher {

	private final jakarta.servlet.RequestDispatcher jakartaDispatcher;

	public RequestDispatcherAdapter(jakarta.servlet.RequestDispatcher jakartaDispatcher) {
		this.jakartaDispatcher = jakartaDispatcher;
	}

	@Override
	public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		try {
			jakartaDispatcher.forward(new JavaxToJakartaRequestAdapter(request), new JavaxToJakartaResponseAdapter(response));
		} catch (jakarta.servlet.ServletException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		try {
			jakartaDispatcher.include(new JavaxToJakartaRequestAdapter(request), new JavaxToJakartaResponseAdapter(response));
		} catch (jakarta.servlet.ServletException e) {
			throw new RuntimeException(e);
		}
	}
}
