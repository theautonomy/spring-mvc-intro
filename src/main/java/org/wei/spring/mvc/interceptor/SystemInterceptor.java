package org.wei.spring.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SystemInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(SystemInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("Enter preHandle");

		String contextPath = request.getContextPath();
		logger.info("context path=" + contextPath);

		String maintenance = request.getParameter("maintenance");
		
		if ("true".equalsIgnoreCase(maintenance)) {
			response.sendRedirect(contextPath + "/unavailable");
			return false;
		}

		long startTime = System.nanoTime();
		request.setAttribute("startTime", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("Enter postHandle");

		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.nanoTime();
		long executeTime = endTime - startTime;

		String timing = request.getParameter("timing");

		String time = String.format("Executing time is %.3f ms.", executeTime / 1000000.0);

		if ("true".equalsIgnoreCase(timing)) {
			modelAndView.addObject("executeTime", time);
		}

		logger.debug(executeTime + "ns");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		logger.info("Enter afterCompletion");
	}

}
