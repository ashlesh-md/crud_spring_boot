package com.crud.crud.dao;

import org.springframework.stereotype.Repository;

import com.crud.crud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // Define field for entity manager

    private EntityManager entityManager;

    // Inject entity manager using constructor injection

    // implement save method

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getById(Integer id) {
        return (Student) entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        entityManager.remove(student);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theLastName",
                Student.class);
        theQuery.setParameter("theLastName", lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student myStudent) {

        entityManager.merge(myStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();

    }

    @Override
    @Transactional
    public int deleteByFirstName(String firstName) {
        Query theQuery = entityManager.createQuery("DELETE FROM Student where firstName=:first_name");
        theQuery.setParameter("first_name", firstName);
        return theQuery.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Student student = getById(id);
        if (student == null)
            return;
        else
            entityManager.remove(getById(id));
    }
}
