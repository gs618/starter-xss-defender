package cn.devcenter.framework.starter.xss.filter;

import cn.devcenter.framework.starter.xss.config.property.ExcludeCharatorsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class XssFilter extends OncePerRequestFilter {

	@Autowired
	private ExcludeCharatorsProperties excludeCharatorsProperties;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request);
		xssRequest.setExcludeCharatorsProperties(excludeCharatorsProperties);
		filterChain.doFilter(xssRequest, response);
	}

}
