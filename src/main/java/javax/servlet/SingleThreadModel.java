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

/**
 * Ensures that servlets handle only one request at a time. This interface has no methods.
 *
 * <p>
 * If a servlet implements this interface, you are <i>guaranteed</i> that no two threads will execute concurrently in
 * the servlet's <code>service</code> method. The servlet container can make this guarantee by synchronizing access to a
 * single instance of the servlet, or by maintaining a pool of servlet instances and dispatching each new request to a
 * free servlet.
 *
 * <p>
 * Note that SingleThreadModel does not solve all thread safety issues. For example, session attributes and static
 * variables can still be accessed by multiple requests on multiple threads at the same time, even when
 * SingleThreadModel servlets are used. It is recommended that a developer take other means to resolve those issues
 * instead of implementing this interface, such as avoiding the usage of an instance variable or synchronizing the block
 * of the code accessing those resources. This interface is deprecated in Servlet API version 2.4.
 *
 *
 * @author Various
 *
 * @deprecated As of Java Servlet API 2.4, with no direct replacement.
 */
@Deprecated(forRemoval = true)
public interface SingleThreadModel {
}