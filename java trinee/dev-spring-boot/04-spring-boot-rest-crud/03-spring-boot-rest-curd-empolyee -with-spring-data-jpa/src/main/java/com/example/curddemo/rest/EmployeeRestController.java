package com.example.curddemo.rest;

import com.example.curddemo.entity.Employee;
import com.example.curddemo.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    private ObjectMapper objectMapper;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/id/{employeeid}")
    public Employee findById(@PathVariable int employeeid) {
        Employee employee = employeeService.findById(employeeid);
        if (employee == null) {
            throw new RuntimeException("Employee with id " + employeeid + " not found");
        }
        return employee;
    }

    @GetMapping("/employees/name/{first_name}")
    public Employee findByUsername(@PathVariable String first_name) {
        return employeeService.findByUsername(first_name);
    }

    @PostMapping("/employees/new")
    public Employee newEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee employee1=employeeService.save(employee);
        return employee1;
    }

    @PutMapping("/employees/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee employee1=employeeService.save(employee);
        return employee1;
    }

    @PatchMapping("/employees/update/{employeeID}")
    public Employee updateEmployee(@RequestBody Map<String,Object> pathPayLoad , @PathVariable int employeeID) {
        Employee employee=employeeService.findById(employeeID);
        if (employee == null) {
            throw new RuntimeException("Employee with id " + employeeID + " not found");
        }
        if (pathPayLoad.containsKey("id")) {
         throw  new RuntimeException("Employee ID cannot be updated");
        }
        Employee employee1=apply(pathPayLoad,employee);
        return employeeService.save(employee1);

    }

    @DeleteMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        employeeService.deleteById(id);
        return "Employee with id " + id + " deleted";
    }

    public Employee apply(Map<String,Object> pathPayLoad, Employee employee) {
        //CONVERT EMPLOYEE OBJECT TO JSON OBJECT NODE
        ObjectNode objectNode = objectMapper.convertValue(employee, ObjectNode.class);
        //CONVERT JSON OBJECT TO EMPLOYEE OBJECT NODE
        ObjectNode pathNode = objectMapper.convertValue(pathPayLoad, ObjectNode.class);
        //MERGE
        objectNode.setAll(pathNode);
        return objectMapper.convertValue(objectNode, Employee.class);
    }



}
