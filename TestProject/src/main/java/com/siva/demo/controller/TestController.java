package com.siva.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siva.demo.entity.Employee;
import com.siva.demo.repository.EmployeeRepo;
import com.siva.demo.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
public class TestController {
	public static  Logger logger = LoggerFactory.getLogger(TestController.class);
	@Autowired
	EmployeeService service;
	@Autowired
	EmployeeRepo repo;
	@GetMapping("/wish")
	public String getwish() {
		
		return "Welcome";
	}
	@PostMapping("/Save")
	public String saveEmpData(@RequestBody Employee emp) {
		logger.info("Data from user "+emp);
		return service.saveEmp(emp);
	}
	@GetMapping("/List")
	public List<Employee> empList(){
		return repo.findAll() ;
	}
	@GetMapping("/Id/{id}")
	public Employee empById(@RequestParam("id") long id){
		Optional<Employee> emp=service.findByEmpId(id);
		if(emp.isPresent()) {
		return emp.get() ;
		}else {
			return new Employee();
		}
	}
	
	@DeleteMapping("/Delete/{id}")
	public String deleteEmp(@RequestParam("id") long id) {
		logger.info("Employee Delete request "+id);
		return service.deleteEmployee(id);
	}
	@PutMapping("/update")
	public String updateEmp(@RequestBody Employee emp){
		return service.updateEmployee(emp) ;
	}
	@GetMapping("/pagenation")
	public Page<Employee> empBasedOnPages(Pageable pageable){
		return repo.findAll(pageable) ;
	}

	@GetMapping("/pages/{page}/{size}")
	public List<Employee> empBasedOnPageReq(@RequestParam("page") int page,@PathVariable("size") int size){
		Pageable pageable=PageRequest.of(page, size);
		Page<Employee> emp= repo.findAll(pageable);
		List<Employee> empList=emp.getContent();
		return empList;
	}
}
