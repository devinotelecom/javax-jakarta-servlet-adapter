package com.devinotele.servletbridge;

import lombok.RequiredArgsConstructor;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@RequiredArgsConstructor
public class AsyncContextAdapter implements AsyncContext, IJakarta<jakarta.servlet.AsyncContext> {
	private final jakarta.servlet.AsyncContext jakartaAsyncContext;

	@Override
	public jakarta.servlet.AsyncContext unwrap () {
		return jakartaAsyncContext;
	}

	@Override
	public void complete() {
		jakartaAsyncContext.complete();
	}

	@Override
	public void start(Runnable run) {
		jakartaAsyncContext.start(run);
	}

	@Override
	public void addListener(AsyncListener listener) {

	}

	@Override
	public void addListener(AsyncListener listener, ServletRequest servletRequest, ServletResponse servletResponse) {

	}

	@Override
	public <T extends AsyncListener> T createListener(Class<T> clazz) throws ServletException {
		return null;
	}

	@Override
	public void setTimeout(long timeout) {

	}

	@Override
	public long getTimeout() {
		return 0;
	}

	@Override
	public void dispatch() {
		jakartaAsyncContext.dispatch();
	}

	@Override
	public void dispatch(String path) {
		jakartaAsyncContext.dispatch(path);
	}

	@Override
	public void dispatch(ServletContext context, String path) {

	}

	@Override
	public ServletRequest getRequest() {
		return new HttpServletRequestAdapter((jakarta.servlet.http.HttpServletRequest) jakartaAsyncContext.getRequest());
	}

	@Override
	public ServletResponse getResponse() {
		return new HttpServletResponseAdapter((jakarta.servlet.http.HttpServletResponse) jakartaAsyncContext.getResponse());
	}

	@Override
	public boolean hasOriginalRequestAndResponse() {
		return false;
	}
}