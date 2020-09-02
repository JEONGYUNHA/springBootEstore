package kr.ac.hansung.cse.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// private static final Logger logger = LoggerFactory.getLogger("kr.ac.hansung.cse.controller.HomeController");
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Locale locale) {
		
		// trace -> debug -> info -> warn -> error 순서 기억!
//		logger.trace("trace level : Welcome home! The client local is {}", locale);
//		logger.debug("trace level : Welcome home! The client local is {}", locale);
//		logger.info("trace level : Welcome home! The client local is {}", locale);
//		logger.warn("trace level : Welcome home! The client local is {}", locale);
//		logger.error("trace level : Welcome home! The client local is {}", locale);
		
		logger.info("trace level : Welcome home! The client local is {}", locale);
		
		String url = request.getRequestURL().toString();
		String clientIPadress = request.getRemoteAddr();
		
		logger.info("request URL : {}, client IP : {}", url, clientIPadress  );
		return "home";
	}
	
}
