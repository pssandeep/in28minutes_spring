package com.pssandeep.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloConrtoller {

	@RequestMapping("/sayHello")
	@ResponseBody
	public String sayHello() {
		return "Hello!";
	}

	@RequestMapping("/")
	@ResponseBody
	public String getHome() {
		return "Home!";
	}

	@RequestMapping("/HelloHtml")
	@ResponseBody
	public String getHelloHtml() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>First WebPage</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>Hi from HTML</h1>");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}

	@RequestMapping("/HelloHtmlJSP")
	public String getHelloHtmlJSP() {

		return "sayHello";
	}

}
