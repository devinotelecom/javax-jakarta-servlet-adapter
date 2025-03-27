# JAVAX to JAKARTA servlet adapter

Allows to run legacy spring boot 2.+ code on spring boot 3.+. As a result, makes migration process easier and softer.

## How to use
```java
@Bean
public ServletRegistrationBean<HttpServletAdapter> wrappedLegacyServlet() {
	//Legacy javax servlet which extends javax.servlet.http.HttpServlet
	val legacyApplicationServlet = new ApplicationServlet();
	// wrapping legacy servlet into adapter
	HttpServletAdapter adapter = new HttpServletAdapter(applicationServlet);
	val registrationBean = new ServletRegistrationBean<>(adapter,	"servlet_path");
	registrationBean.setName("beanName");
	return registrationBean;
	}
```