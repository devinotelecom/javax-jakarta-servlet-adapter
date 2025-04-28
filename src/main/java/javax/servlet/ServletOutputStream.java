/*
 * Copyright (c) 1997-2018 Oracle and/or its affiliates and others.
 * All rights reserved.
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package javax.servlet;

import com.devinotele.servletbridge.IJakarta;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

/**
 * Provides an output stream for sending binary data to the client. A <code>ServletOutputStream</code> object is
 * normally retrieved via the {@link ServletResponse#getOutputStream} method.
 *
 * <p>
 * This is an abstract class that the servlet container implements. Subclasses of this class must implement the
 * <code>java.io.OutputStream.write(int)</code> method.
 *
 *
 * @author Various
 *
 * @see ServletResponse
 *
 */
@RequiredArgsConstructor
public class ServletOutputStream extends jakarta.servlet.ServletOutputStream implements IJakarta<jakarta.servlet.ServletOutputStream> {
	private final jakarta.servlet.ServletOutputStream jakartaOutputStream;

	@Override public jakarta.servlet.ServletOutputStream unwrap () { return jakartaOutputStream; }

	@Override public void write (int b) throws IOException { jakartaOutputStream.write(b); }

	@Override public boolean isReady () { return jakartaOutputStream.isReady(); }

	@Override public void close () throws IOException { jakartaOutputStream.close(); }

	@Override public void write (byte[] b) throws IOException { jakartaOutputStream.write(b); }

	@Override public void write (byte[] b, int off, int len) throws IOException { jakartaOutputStream.write(b, off, len); }

	@Override public void flush () throws IOException { jakartaOutputStream.flush(); }

	@Override
	public void setWriteListener (jakarta.servlet.WriteListener writeListener) {
		jakartaOutputStream.setWriteListener(writeListener);
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