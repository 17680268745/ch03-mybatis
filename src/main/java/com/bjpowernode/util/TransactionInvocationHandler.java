package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {
    //target:zs
    private Object target;

    public TransactionInvocationHandler(Object target){
        this.target = target;
    }

    //代理类的业务方法
    //ls的表白方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession sqlSession = null;
        Object object = null;
        try {
            sqlSession = SqlSessionUtil.getSession();
            //处理业务逻辑
            //method.invoke：zs的表白方法
            object = method.invoke(target,args);
            //成功处理完成业务，提交事务
            sqlSession.commit();
        }catch (Exception e){
            //如果业务处理失败，事务回滚
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(sqlSession);
        }
        return null;
    }

    //取得ls对象
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
