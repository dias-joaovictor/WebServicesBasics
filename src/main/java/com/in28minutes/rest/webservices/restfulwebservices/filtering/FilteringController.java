package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping(path="/filtering")
	public SomeBean retrievingSomeBean() {
		return new SomeBean("field1", "field2", "field3");
	}
	
	
	@GetMapping(path="/filtering-list")
	public List<SomeBean> retrievingListofSomeBean() {
		return Arrays.asList(new SomeBean("field1", "field2", "Password1"), new SomeBean("field22", "field23", "Password2"),new SomeBean("field17", "field44", "Password3"));
	}
	
	
}
