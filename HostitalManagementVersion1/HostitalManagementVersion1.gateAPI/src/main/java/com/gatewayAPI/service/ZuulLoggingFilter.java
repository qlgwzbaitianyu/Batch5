package com.gatewayAPI.service;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ZuulLoggingFilter extends ZuulFilter{
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	//logic for filtering
		@Override
		public Object run() {
			HttpServletRequest request= RequestContext.getCurrentContext().getRequest();
			logger.info("request -> {} request uri ->{} "+ request, request.getRequestURI());
			return null;
		}

		//want to execute this filter or no
		@Override
		public boolean shouldFilter() {
			return true;
		}

		//Filter order starts with1 as highest priority. 2 for other
		@Override
		public int filterOrder() {
			return 1;
		}

		//when should filtering happen: before request handled/after/ or only error requests
		@Override
		public String filterType() {
			return "pre";
		}
}
