package com.company.ClrTester;

import com.company.beans.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Order(1)

public class TestWithRestTemplate implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        String addEmployeeUrl = "http://localhost:8081/addEmployee";
        String getEmployeeByIdUrl = "http://localhost:8081/getEmployee/1";
        String getEmployeesUrl = "http://localhost:8081/getEmployees";
        String getEmployeesByNameUrl = "http://localhost:8081/getEmployees/";

        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Worker1");
        employee1.setSalary(9999);
        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Worker2");
        employee2.setSalary(11000);

        System.out.println("RestTemplate test starts now\n----------");
        System.out.println("Adding two employees\n----------");
        System.out.println(restTemplate.postForObject(addEmployeeUrl, employee1, Long.class));
        System.out.println(restTemplate.postForObject(addEmployeeUrl, employee2, Long.class));
        System.out.println("Two employees were added, lets find one of them with restTemplate\n----------");
        System.out.println(restTemplate.getForObject(getEmployeeByIdUrl, Employee.class));
        System.out.println("----------\nall employees:\n-------------");
        System.out.println(restTemplate.getForObject(getEmployeesUrl, List.class));
        System.out.println("----------\nAll employees named " +employee2.getName()+":\n----------");
        System.out.println(restTemplate.getForObject(getEmployeesByNameUrl+employee2.getName(),List.class));
        System.out.println("----------\nEnd of the program\n----------");
    }
}
