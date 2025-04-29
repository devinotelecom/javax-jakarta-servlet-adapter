package com.devinotele.servletbridge;

import lombok.RequiredArgsConstructor;

import javax.servlet.ServletException;

@RequiredArgsConstructor
public class ServletExceptionAdapter extends ServletException {
	private final jakarta.servlet.ServletException jakartaException;

	@Override
	public String getMessage() {
		return jakartaException.getMessage();
	}

	@Override
	public String getLocalizedMessage() {
		return jakartaException.getLocalizedMessage();
	}

	@Override
	public Throwable getCause() {
		return wrapThrowable(jakartaException.getCause());
	}

	@Override
	public Throwable getRootCause() {
		return wrapThrowable(jakartaException.getRootCause());
	}

	@Override
	public void printStackTrace() {
		jakartaException.printStackTrace();
	}

	@Override
	public void printStackTrace(java.io.PrintStream s) {
		jakartaException.printStackTrace(s);
	}

	@Override
	public void printStackTrace(java.io.PrintWriter s) {
		jakartaException.printStackTrace(s);
	}

	@Override
	public StackTraceElement[] getStackTrace() {
		return jakartaException.getStackTrace();
	}

	@Override
	public void setStackTrace(StackTraceElement[] stackTrace) {
		jakartaException.setStackTrace(stackTrace);
	}

	@Override
	public String toString() {
		return jakartaException.toString();
	}

	private Throwable wrapThrowable (Throwable t) {
		if (t == null) {
			return null;
		}
		if (t instanceof jakarta.servlet.ServletException e){
			return new ServletExceptionAdapter(e);
		}
		return t;
	}
}