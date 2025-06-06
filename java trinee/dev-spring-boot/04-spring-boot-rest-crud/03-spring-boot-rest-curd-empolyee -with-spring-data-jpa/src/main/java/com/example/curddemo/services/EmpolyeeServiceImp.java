package com.example.curddemo.services;
import com.example.curddemo.dao.EmployeeRepository;
import com.example.curddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpolyeeServiceImp implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Autowired
    public void setEmployeeDAO(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee emp = null;
        if (employee.isPresent()) {
            emp = employee.get();
        }
        else{
            throw new RuntimeException("Employee with id " + id + " not found");
        }

        return emp;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Employee findByUsername(String username) {
        return employeeRepository.findByFirstName(username);
    }
}
