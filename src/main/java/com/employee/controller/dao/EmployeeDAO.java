package com.employee.controller.dao;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.controller.entities.Employee;
import com.employee.controller.repository.UserRepository;

@Service
public class EmployeeDAO {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(Employee employee) {

        this.userRepository.save(employee);

    }

    public void update(Employee employee) {

        this.userRepository.save(employee);

    }
    
    @Transactional
    public void delete(int id) {
        Optional<Employee> option=this.userRepository.findById(id);
        Employee employee=option.get();
        this.userRepository.delete(employee);

    }
    
    public Employee read(int id) {
        
        Optional<Employee> findById=this.userRepository.findById(id);
        return findById.get();
    }
    
    public ArrayList<Employee> getAll(){
        ArrayList<Employee> list=(ArrayList<Employee>) this.userRepository.findAll();
        return list;
    }
}
