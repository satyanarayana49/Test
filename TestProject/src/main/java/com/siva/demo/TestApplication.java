package com.siva.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.siva.demo.entity.Employee;
import com.siva.demo.repository.EmployeeRepo;

@SpringBootApplication
public class TestApplication {
	@Autowired
	EmployeeRepo empRepo;
	
	List<Employee> list=Stream.of(new Employee(1, "Siva",30, 200000.0d, "Hyd"),
			new Employee(2, "Siva",20,220000.0d, "Hyd"),
			new Employee(3, "Nag",22, 230000.0d, "SEC"),
			new Employee(4, "Siva",34, 250000.0d, "RLG"),
			new Employee(5, "mag",19, 340000.0d, "TNK"),
			new Employee(6, "Nasa",31, 540000.0d, "TS"),
			new Employee(7, "Manu",45, 20000.0d, "AP"),
			new Employee(8, "Siva",60, 700000.0d, "BZA"),
			new Employee(9, "sai",61, 7100000.0d, "BZA"),
			new Employee(10, "Siva",42, 230000.0d, "Hyd"),
			new Employee(11, "Siva",25, 250000.0d, "CN"),
			new Employee(12, "rao",28, 340000.0d, "Dl"),
			new Employee(13, "ravi",23, 540000.0d, "GVP"),
			new Employee(14, "Siva",38, 20000.0d, "Hyd"),
			new Employee(15, "Satya",39, 700000.0d, "GVP"),
			new Employee(16, "Raju",68, 9000000.0d, "Hyd")).collect(Collectors.toList());
	@PostConstruct
	public void saveData() {
		empRepo.saveAll(list);
	}
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		
	}

}
