package com.devinotele.servletbridge;

import javax.servlet.WriteListener;
import java.io.IOException;

public class WriteListenerAdapter implements jakarta.servlet.WriteListener {

	private final WriteListener writeListener;

	public WriteListenerAdapter(WriteListener writeListener) {
		this.writeListener = writeListener;
	}

	@Override
	public void onWritePossible() throws IOException {
		writeListener.onWritePossible();
	}

	@Override
	public void onError(Throwable t) {
		writeListener.onError(t);
	}
}