package com.devinotele.servletbridge;

import javax.servlet.ServletOutputStream;

public class ServletOutputStreamAdapter extends ServletOutputStream {
	public ServletOutputStreamAdapter (jakarta.servlet.ServletOutputStream jakartaOutputStream) {
		super(jakartaOutputStream);
	}//new
}