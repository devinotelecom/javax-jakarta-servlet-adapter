package com.devinotele.servletbridge;

/**
 Unwrap original Jakarta type from Javax wrapper
 @see javax.sql.DataSource#unwrap(Class)  */
@FunctionalInterface
public interface IJakarta<T> {
	T unwrap ();

	@SuppressWarnings("unchecked")
	static <T> T unwrap (Object javax, Class<T> castTo) {
		if (castTo.isInstance(javax)){
			return castTo.cast(javax);// arg is T already
		}
		return ((IJakarta<T>) javax).unwrap();
	}

	static jakarta.servlet.http.HttpServletRequest unwrap (javax.servlet.http.HttpServletRequest javax) {
		if (javax instanceof IJakarta<?> j){
			return (jakarta.servlet.http.HttpServletRequest) j.unwrap();

		} else if (javax instanceof jakarta.servlet.http.HttpServletRequest j){
			return j;

		} else if (javax instanceof javax.servlet.http.HttpServletRequestWrapper w){
			var req = w.getRequest();

			if (req instanceof IJakarta<?> j){
				return (jakarta.servlet.http.HttpServletRequest) j.unwrap();

			} else if (req instanceof jakarta.servlet.http.HttpServletRequest j){
				return j;

			} else if (req instanceof javax.servlet.http.HttpServletRequest x){
				return unwrap(x);
			}
		}
		throw new IllegalArgumentException("Unsupported request type: "+ javax.getClass() +" = " + javax);
	}

	static jakarta.servlet.http.HttpServletResponse unwrap (javax.servlet.http.HttpServletResponse javax) {
		if (javax instanceof IJakarta<?> j){
			return (jakarta.servlet.http.HttpServletResponse) j.unwrap();

		} else if (javax instanceof jakarta.servlet.http.HttpServletResponse j){
			return j;

		} else if (javax instanceof javax.servlet.http.HttpServletResponseWrapper w){
			var req = w.getResponse();

			if (req instanceof IJakarta<?> j){
				return (jakarta.servlet.http.HttpServletResponse) j.unwrap();

			} else if (req instanceof jakarta.servlet.http.HttpServletResponse j){
				return j;

			} else if (req instanceof javax.servlet.http.HttpServletResponse x){
				return unwrap(x);
			}
		}
		throw new IllegalArgumentException("Unsupported Response type: "+ javax.getClass() +" = " + javax);
	}
}