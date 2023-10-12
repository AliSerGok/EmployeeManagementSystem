package com.luv2code.springboot.demosecurity.service;

import com.luv2code.springboot.demosecurity.DTO.EmployeeRepository;
import com.luv2code.springboot.demosecurity.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository repository;
    Employee employee;

    public EmployeeServiceImpl(Employee employee) {
        this.employee = employee;
    }

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> listAll() {

        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> byId = repository.findById(id);
        Employee result=null;
        if (byId.isPresent()) {
            result = byId.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return result;
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);

    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }
}
