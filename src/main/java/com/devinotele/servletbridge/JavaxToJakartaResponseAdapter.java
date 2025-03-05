package com.devinotele.servletbridge;


import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class JavaxToJakartaResponseAdapter implements ServletResponse {

	private final javax.servlet.ServletResponse javaxResponse;

	public JavaxToJakartaResponseAdapter(javax.servlet.ServletResponse javaxResponse) {
		this.javaxResponse = javaxResponse;
	}


	@Override
	public String getCharacterEncoding() {
		return "";
	}

	@Override
	public String getContentType() {
		return "";
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return null;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		return null;
	}

	@Override
	public void setCharacterEncoding(String encoding) {

	}

	@Override
	public void setContentLength(int len) {

	}

	@Override
	public void setContentLengthLong(long len) {

	}

	@Override
	public void setContentType(String type) {

	}

	@Override
	public void setBufferSize(int size) {

	}

	@Override
	public int getBufferSize() {
		return 0;
	}

	@Override
	public void flushBuffer() throws IOException {

	}

	@Override
	public void resetBuffer() {

	}

	@Override
	public boolean isCommitted() {
		return false;
	}

	@Override
	public void reset() {

	}

	@Override
	public void setLocale(Locale loc) {

	}

	@Override
	public Locale getLocale() {
		return null;
	}
}
