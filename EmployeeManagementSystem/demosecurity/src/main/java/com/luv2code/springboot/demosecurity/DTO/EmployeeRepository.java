package com.luv2code.springboot.demosecurity.DTO;

import com.luv2code.springboot.demosecurity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
