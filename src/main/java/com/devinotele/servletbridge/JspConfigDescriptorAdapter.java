package com.devinotele.servletbridge;

import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.descriptor.JspPropertyGroupDescriptor;
import javax.servlet.descriptor.TaglibDescriptor;
import java.util.Collection;
import java.util.List;

public class JspConfigDescriptorAdapter implements JspConfigDescriptor {

	private final jakarta.servlet.descriptor.JspConfigDescriptor jspConfigDescriptor;

	public JspConfigDescriptorAdapter(jakarta.servlet.descriptor.JspConfigDescriptor jspConfigDescriptor) {
		this.jspConfigDescriptor = jspConfigDescriptor;
	}

	@Override
	public Collection<TaglibDescriptor> getTaglibs() {
		return List.of();
	}

	@Override
	public Collection<JspPropertyGroupDescriptor> getJspPropertyGroups() {
		return List.of();
	}
}
