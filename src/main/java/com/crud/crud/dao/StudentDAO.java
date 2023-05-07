package com.crud.crud.dao;

import java.util.List;

import com.crud.crud.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student getById(Integer id);

    void delete(Student student);

    List<Student> findAll();

    int deleteAll();

    void deleteById(Integer id);

    List<Student> findByLastName(String lastName);

    void update(Student myStudent);

    int deleteByFirstName(String firstName);

}
