package com.bjpowernode.service;

import com.bjpowernode.domain.Student;

import java.util.List;

//具有哪些业务服务
public interface StudentService {
    public Student getById(String id);

    public void save(Student s);

    List<Student> getAll();
}
