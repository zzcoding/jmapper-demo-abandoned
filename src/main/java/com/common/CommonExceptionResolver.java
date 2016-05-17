package com.common;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.common.exception.XssException;



@Component
public class CommonExceptionResolver implements HandlerExceptionResolver {

	private Logger logger=Logger.getLogger(CommonExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		ex.printStackTrace();
		if(ex instanceof XssException){
			ActionHelper.generText("{\"error\":\"true\",\"msg\":\""+ex.getMessage()+"\"}", response, logger);
			return null;
		}
		ActionHelper.generText("{\"error\":\"true\",\"msg\":\""+ex.getMessage()+"\"}", response, logger);
		return null;
	}
	
}
