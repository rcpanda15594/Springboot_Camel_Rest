package com.example.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.rest.entity.Employee;

@Service
public class EmployeeService {

	private List<Employee> empList = new ArrayList<>();
	
	@PostConstruct
	public void initEmp(){
	empList.add(new Employee(100,"Ram","Delhi"));	
	empList.add(new Employee(101,"Sam","Bangalore"));	
	empList.add(new Employee(102,"Dam","Mumbai"));	
	empList.add(new Employee(103,"Aam","MP"));	
	}
	
	public List<Employee> empList() {
		System.out.println(empList);
		return empList;
	}
}
