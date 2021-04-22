package com.employee.controller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.controller.entities.Employee;

@Repository
public interface UserRepository extends CrudRepository<Employee, Integer>{
    

}
