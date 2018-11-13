package com.in28minutes.rest.webservices.restfulwebservices.helloWorld;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	
	//GET
	//URI - /hello-world
	//Method - "Hello World"
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	//hello-world/path-variable/in28minutes
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(MessageFormat.format("Hello World, {0}", name)) ;
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
}
