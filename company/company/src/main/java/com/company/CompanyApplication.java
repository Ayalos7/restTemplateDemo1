package com.company;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.company.beans.Employee;
import com.company.beans.Job;
import com.company.repo.EmployeeRepository;
import com.company.repo.JobRepository;

@SpringBootApplication
public class CompanyApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(CompanyApplication.class, args);

	}

}
