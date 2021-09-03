package com.company.Controlloers;

import com.company.beans.Employee;
import com.company.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")


public class CompanyController {
    @Autowired
    private  EmployeeRepository employeeRepository;

    @PostMapping("addEmployee")
    private ResponseEntity<?> addEmployee (@RequestBody Employee employee){
        employeeRepository.save(employee);
        return new ResponseEntity<>(employee.getId(),HttpStatus.CREATED);
    }

    @GetMapping("getEmployee/{id}")
    private ResponseEntity<?> getEmployee(@PathVariable long id){
        return new ResponseEntity<>(employeeRepository.findById(id),HttpStatus.OK);
    }

    @GetMapping("getEmployees")
    private ResponseEntity<?> getEmployees(){
        return new ResponseEntity<>(employeeRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("getEmployees/{name}")
    private ResponseEntity<?> getEmployeesByName(@PathVariable String name){
        return new ResponseEntity<>(employeeRepository.findEmployeeByName(name),HttpStatus.OK);
    }

}
