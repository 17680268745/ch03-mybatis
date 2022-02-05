package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {

    private static SqlSessionFactory factory;

    private SqlSessionUtil(){};

    static {
        String config = "mybatis.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();

    public static SqlSession getSession(){
        SqlSession sqlSession = t.get();
        if (sqlSession == null){
            sqlSession = factory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }

    public static void myClose(SqlSession sqlSession){
        if (sqlSession != null){
            sqlSession.close();
            t.remove();
        }
    }
}
