# JAVAX to JAKARTA servlet adapter
[![](https://jitpack.io/v/devinotelecom/javax-jakarta-servlet-adapter.svg)](https://jitpack.io/#devinotelecom/javax-jakarta-servlet-adapter)

Allows to run legacy spring boot 2.+ code on spring boot 3.+. As a result, makes migration process easier and softer.

## How to use
```java
@Bean
public ServletRegistrationBean<HttpServletAdapter> wrappedLegacyServlet() {
	//Any legacy javax servlet which extends javax.servlet.http.HttpServlet
	val legacyServlet = new LegacyServlet();
	// wrapping legacy servlet into adapter
	HttpServletAdapter adapter = new HttpServletAdapter(applicationServlet);
	val registrationBean = new ServletRegistrationBean<>(adapter,	"servlet_path");
	registrationBean.setName("beanName");
	return registrationBean;
}
```
