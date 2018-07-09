package com.shiv.microservices.netflixzuulapigateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		logger.info("## shouldFilter() ->");
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

		logger.info("## reuest -> {}, request URI -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		logger.info("## filterType() ->");
		return "pre";
	}

	@Override
	public int filterOrder() {
		logger.info("filterOrder()");
		return 1;
	}

}
