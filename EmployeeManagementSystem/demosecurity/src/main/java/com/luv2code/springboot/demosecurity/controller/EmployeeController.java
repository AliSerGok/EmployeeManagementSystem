package com.luv2code.springboot.demosecurity.controller;

import com.luv2code.springboot.demosecurity.entity.Employee;
import com.luv2code.springboot.demosecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/showList")
    public String showList(Model model){
        List<Employee> employees=new ArrayList<>();
        employees=service.listAll();
        model.addAttribute("employees",employees);
        return "employee/show-list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("employeeId") int theId,Model theModel){
        Employee employee=service.findById(theId);
        theModel.addAttribute("employee",employee);
        return "employee/add-employee";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        service.deleteById(theId);
        return "redirect:/employee/showList";
    }

    @GetMapping("/addPage")
    public String showAddPage(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employee/add-employee";
    }

    @PostMapping("/addEmployee")
    public String save(@ModelAttribute("employee") Employee theEmployee){
        service.save(theEmployee);
        return "employee/confirm-page";
    }


}
