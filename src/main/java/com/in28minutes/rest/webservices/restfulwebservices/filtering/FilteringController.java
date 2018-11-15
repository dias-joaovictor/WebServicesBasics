package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	


	@GetMapping(path="/filtering")
	public MappingJacksonValue retrievingSomeBean() {
		SomeBean someBean = new SomeBean("field1", "field2", "field3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	
	@GetMapping(path="/filtering-list")
	public List<SomeBean> retrievingListofSomeBean() {
		return Arrays.asList(new SomeBean("field1", "field2", "Password1"), new SomeBean("field22", "field23", "Password2"),new SomeBean("field17", "field44", "Password3"));
	}
	
	
}
