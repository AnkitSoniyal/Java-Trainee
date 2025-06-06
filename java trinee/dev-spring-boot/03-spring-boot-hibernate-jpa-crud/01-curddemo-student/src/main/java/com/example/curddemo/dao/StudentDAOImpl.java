package com.example.curddemo.dao;

import com.example.curddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    //DEFINE FIELD FOR ENTITY MANAGER
    private EntityManager em;

    //INJECT ENTITY MANAGER USING CONSTRUCTOR
    @Autowired
    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }

    //IMPLEMENT SAVE METHOD
    @Transactional
    @Override
    public void save(Student  student) {
        em.persist(student);

    }
    @Override
    public Student findById(Integer id) {
        return em.find(Student.class, id);
    }
    @Override
    public List<Student> findAll() {
        return em.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = em
                .createQuery("from Student s where s.lastName = :lastName", Student.class);
        return query.setParameter("lastName", lastName).getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        em.merge(student);
    }

    @Override
    @Transactional
    public void delete(int student) {
        Student stud = em.find(Student.class, student);
        em.remove(stud);
    }
    @Override
    @Transactional
    public int deleteAll() {
        return em.createQuery("delete from Student", Student.class).getResultList().size();
    }

}
