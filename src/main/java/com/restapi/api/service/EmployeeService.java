package com.restapi.api.service;

import com.restapi.api.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restapi.api.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public List<Employee> findAll(){

        return employeeRepo.findAll();
    }

    public void save(Employee employee){

        employeeRepo.save(employee);
    }
    public Optional<Employee> findById(int id){

        return employeeRepo.findById(id);
    }

    public void delete(int id){
        Employee emp = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("employee not found"));

        employeeRepo.delete(emp);
    }


}
