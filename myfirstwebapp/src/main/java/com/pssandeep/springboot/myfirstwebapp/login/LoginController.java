package com.pssandeep.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/login")
	public String getLogin(@RequestParam String name, ModelMap model) {
		logger.debug("REQUEST PARAM IS " + name);
		logger.warn("REQUEST PARAM IS " + name);
		logger.info("REQUEST PARAM IS " + name);
		logger.error("REQUEST PARAM IS " + name);
		System.out.println("REQUEST PARAM IS " + name);
		model.put("name", name);
		return "login";
	}

}
