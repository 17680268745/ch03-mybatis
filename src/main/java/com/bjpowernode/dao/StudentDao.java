package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

//对数据库的操作方法
public interface StudentDao {
    public Student getById(String id);

    public void save(Student s);

    List<Student> getAll();
}
