package com.employee.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.controller.dao.EmployeeDAO;
import com.employee.controller.entities.Employee;

@RestController()
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping("/employeelist")
    public String employee(){
        return "This is woorking";
    }
    
//  @GetMapping(path="/createUser/{name}&{dob}&{email}&{location}")
    @PostMapping("/createUser")
    public void add(@RequestBody Employee employee) {
//        Employee employee=new Employee();
//        employee.setEmpName(name);
//        employee.setdOB(dob);
//        employee.setEmail(email);
//        employee.setLocation(location);
        System.out.println(employee);
        this.employeeDao.save(employee);
        
    }
    
    
    @GetMapping("/get/{id}")
    public Employee get(@PathVariable("id") int id) {
       return this.employeeDao.read(id);
    }
    
    @GetMapping("/getAll")
    public ArrayList<Employee> getAll(){
        return this.employeeDao.getAll();
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public void delete(@PathVariable("id") int id) {
        this.employeeDao.delete(id);
    }
    
    
}
