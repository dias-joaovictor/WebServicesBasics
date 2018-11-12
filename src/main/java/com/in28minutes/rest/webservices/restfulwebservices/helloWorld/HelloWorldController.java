package com.in28minutes.rest.webservices.restfulwebservices.helloWorld;

import java.text.MessageFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

	
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
}
