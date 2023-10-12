package com.luv2code.springboot.demosecurity.service;

import com.luv2code.springboot.demosecurity.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> listAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
}
