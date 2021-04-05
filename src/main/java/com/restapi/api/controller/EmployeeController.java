package com.restapi.api.controller;

import com.restapi.api.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.restapi.api.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hey! I got you.";
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){

        return empService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable int id){

        Optional<Employee> employee = empService.findById(id);

         return employee.orElseThrow(() -> new RuntimeException("Employee id not found - " + id));
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee employee){

        empService.save(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        empService.save(employee);

        return employee;

    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){

        empService.delete(id);
        
        return "This Employee Id was deleted:"+id;
    }
}
