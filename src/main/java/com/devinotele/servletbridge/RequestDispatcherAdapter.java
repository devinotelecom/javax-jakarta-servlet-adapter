package com.devinotele.servletbridge;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class RequestDispatcherAdapter implements RequestDispatcher, jakarta.servlet.RequestDispatcher {
	@Getter private final jakarta.servlet.RequestDispatcher jakartaDispatcher;

	@Override
	public void forward (ServletRequest request, ServletResponse response) throws ServletException, IOException {
		try {
			jakartaDispatcher.forward(
				IJakarta.unwrap(request, jakarta.servlet.ServletRequest.class),
				IJakarta.unwrap(response, jakarta.servlet.ServletResponse.class)
			);
		} catch (jakarta.servlet.ServletException e){
			throw new ServletException(e);
		}
	}

	@Override
	public void include (ServletRequest request, ServletResponse response) throws ServletException, IOException {
		try {
			jakartaDispatcher.include(
				IJakarta.unwrap(request, jakarta.servlet.ServletRequest.class),
				IJakarta.unwrap(response, jakarta.servlet.ServletResponse.class)
			);
		} catch (jakarta.servlet.ServletException e){
			throw new ServletException(e);
		}
	}

	@Override
	public void forward (jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response) throws jakarta.servlet.ServletException, IOException {
		jakartaDispatcher.forward(request, response);
	}

	@Override
	public void include (jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response) throws jakarta.servlet.ServletException, IOException {
		jakartaDispatcher.include(request, response);
	}

	@Override
	public String toString () {
		return jakartaDispatcher.toString();
	}
}