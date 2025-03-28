package com.devinotele.servletbridge;

import javax.servlet.ServletException;

public class ServletExceptionAdapter extends ServletException {

	private final jakarta.servlet.ServletException jakartaException;

	public ServletExceptionAdapter(jakarta.servlet.ServletException jakartaException) {
		this.jakartaException = jakartaException;
	}

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

	private Throwable wrapThrowable(Throwable t) {
		if (t == null) {
			return null;
		}
		if (t instanceof jakarta.servlet.ServletException) {
			return new ServletExceptionAdapter((jakarta.servlet.ServletException) t);
		}
		return t;
	}
}
