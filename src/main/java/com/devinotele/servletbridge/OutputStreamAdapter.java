package com.devinotele.servletbridge;

import javax.servlet.ServletOutputStream;
import java.io.IOException;

public class OutputStreamAdapter extends ServletOutputStream {

	private final jakarta.servlet.ServletOutputStream jakartaOutputStream;

	public OutputStreamAdapter(jakarta.servlet.ServletOutputStream jakartaOutputStream) {
		this.jakartaOutputStream = jakartaOutputStream;
	}

	@Override
	public void write(int b) throws IOException {
		jakartaOutputStream.write(b);
	}

	@Override
	public boolean isReady() {
		return jakartaOutputStream.isReady();
	}

	@Override
	public void setWriteListener(javax.servlet.WriteListener writeListener) {
		jakartaOutputStream.setWriteListener(new WriteListenerAdapter(writeListener));
	}
}