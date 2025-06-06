package com.example.curddemo.dao;

import com.example.curddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "info")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByFirstName(String username);


}

