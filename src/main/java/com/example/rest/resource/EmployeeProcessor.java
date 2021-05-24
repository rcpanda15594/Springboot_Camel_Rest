package com.example.rest.resource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rest.entity.Employee;
import com.example.rest.service.EmployeeService;

@Component
public class EmployeeProcessor implements Processor {

	@Autowired
	private EmployeeService service;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		service.addEmployee(exchange.getIn().getBody(Employee.class));
	}

}
