package com.siva.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.demo.entity.Employee;
import com.siva.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo emprepo;
	
	public String saveEmp(Employee emp) {
		emprepo.save(emp);
		return "success";
	}
	
	public String deleteEmployee(long id) {
		Optional<Employee> emp=findByEmpId(id);
		if(emp.isPresent()) {
		emprepo.deleteById(id);
		return "Employee Deleted Successfully";
		}
		else {
			return "No Employee delails found";
		}
	}
	public Optional<Employee> findByEmpId(long id) {
		Optional<Employee> emp=emprepo.findById(id);
		return emp;
	}
	
	public String updateEmployee(Employee emp) {
	if(emp!=null && emp.getId()!=0) {
		Optional<Employee> e=findByEmpId(emp.getId());
		if(e.isPresent()) {
			Employee updateEmp=e.get();
			updateEmp.setAddr(emp.getAddr());
			updateEmp.setAge(emp.getAge());
			updateEmp.setName(emp.getName());
			updateEmp.setSalary(emp.getSalary());
			emprepo.save(updateEmp);
			return "Employee Details Updated successfully";
			
		}
		else {
			return "Employee Details not found";
		}
	}else {
		return "Null data from user";
	}
		
	}
		
		
	
}
