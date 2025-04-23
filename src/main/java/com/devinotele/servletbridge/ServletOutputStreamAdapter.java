package com.devinotele.servletbridge;

import lombok.RequiredArgsConstructor;

import javax.servlet.ServletOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class ServletOutputStreamAdapter extends ServletOutputStream implements IJakarta<jakarta.servlet.ServletOutputStream> {
	private final jakarta.servlet.ServletOutputStream jakartaOutputStream;

	@Override public jakarta.servlet.ServletOutputStream unwrap () { return jakartaOutputStream; }

	@Override public void write (int b) throws IOException { jakartaOutputStream.write(b); }

	@Override public boolean isReady () { return jakartaOutputStream.isReady(); }

	@Override public void close () throws IOException { jakartaOutputStream.close(); }

	@Override public void write (byte[] b) throws IOException { jakartaOutputStream.write(b); }

	@Override public void write (byte[] b, int off, int len) throws IOException { jakartaOutputStream.write(b, off, len); }

	@Override public void flush () throws IOException { jakartaOutputStream.flush(); }

	@Override
	public void setWriteListener (javax.servlet.WriteListener writeListener) {
		jakartaOutputStream.setWriteListener(new WriteListenerAdapter(writeListener));
	}

	@Override public void print (String s) throws IOException { jakartaOutputStream.print(s); }

	@Override public void print (boolean b) throws IOException { jakartaOutputStream.print(b); }

	@Override public void print (char c) throws IOException { jakartaOutputStream.print(c); }

	@Override public void print (int i) throws IOException { jakartaOutputStream.print(i); }

	@Override public void print (long l) throws IOException { jakartaOutputStream.print(l); }

	@Override public void print (float f) throws IOException { jakartaOutputStream.print(f); }

	@Override public void println () throws IOException { jakartaOutputStream.println(); }

	@Override public void print (double d) throws IOException { jakartaOutputStream.print(d); }

	@Override public void println (String s) throws IOException { jakartaOutputStream.println(s); }

	@Override public void println (boolean b) throws IOException { jakartaOutputStream.println(b); }

	@Override public void println (char c) throws IOException { jakartaOutputStream.println(c); }

	@Override public void println (int i) throws IOException { jakartaOutputStream.println(i); }

	@Override public void println (long l) throws IOException { jakartaOutputStream.println(l); }

	@Override public void println (float f) throws IOException { jakartaOutputStream.println(f); }

	@Override public void println (double d) throws IOException { jakartaOutputStream.println(d); }
}