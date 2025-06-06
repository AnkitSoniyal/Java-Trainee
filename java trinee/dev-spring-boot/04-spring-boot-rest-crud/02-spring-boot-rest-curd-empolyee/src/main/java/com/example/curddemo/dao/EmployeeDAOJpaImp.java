package com.example.curddemo.dao;

import com.example.curddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO {
    private EntityManager em;

    @Autowired
    public EmployeeDAOJpaImp(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = em.find(Employee.class, id);
        return employee;
    }
    @Override
    public Employee save(Employee employee) {
        Employee employee1 = em.merge(employee);
        return employee1;
    }

    @Override
    public void delete(int id) {
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
    }

    @Override
    public Employee findByFirstName(String firstName) {
        TypedQuery<Employee> employeeQuery = em.createQuery("from Employee where firstName = :firstName", Employee.class);
        employeeQuery.setParameter("firstName", firstName);
        List<Employee> employees = employeeQuery.getResultList();
        return employees.get(0);
    }
}

