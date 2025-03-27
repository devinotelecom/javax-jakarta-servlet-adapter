package com.devinotele.servletbridge;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.servlet.WriteListener;
import java.io.IOException;

@RequiredArgsConstructor
public class WriteListenerAdapter implements jakarta.servlet.WriteListener {
	@Getter private final WriteListener writeListener;

	@Override
	public void onWritePossible() throws IOException {
		writeListener.onWritePossible();
	}

	@Override
	public void onError(Throwable t) {
		writeListener.onError(t);
	}

	@Override
	public String toString () {
		return writeListener.toString();
	}
}