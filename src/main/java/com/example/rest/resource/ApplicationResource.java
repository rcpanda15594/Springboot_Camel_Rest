package com.example.rest.resource;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.example.rest.service.EmployeeService;

@Component
public class ApplicationResource extends RouteBuilder{

	@Autowired
	private EmployeeService service;
	
	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").port(6060).host("localhost").bindingMode(RestBindingMode.json);
		
		rest().get("/helloworld").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(constant("Welcome to World"));		
		
		
		rest().get("/getAllEmployees").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(() -> service.empList());
		
	}

}
