package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.util.ServiceFactory;

public class Test1 {
    public static void main(String[] args) {

        //StudentService ss = new StudentServiceImpl();
        StudentService ss = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        //测试添加操作
//        Student s = new Student();
//        s.setId("1006");
//        s.setName("cql");
//        s.setAge(25);
//        ss.save(s);

        Student s = ss.getById("1004");
        System.out.println(s);
//        List<Student> sList = ss.getAll();
//        for (Student s : sList){
//            System.out.println(s);
//        }
    }
}
