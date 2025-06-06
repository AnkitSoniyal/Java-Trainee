package com.example.curddemo.dao;

import com.example.curddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);
    Employee findByFirstName(String firstName);
}
