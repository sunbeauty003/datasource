package com.example.datasource.aop;

import com.example.datasource.annotation.DataSource;
import com.example.datasource.config.DynamicDataSourceContextHolder;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
//@Order(-1900)
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    //定义切点
    @Pointcut("execution(* com.example.datasource.service.*.*(..))")
    public void qieru(){ }

    @Before("qieru()")
    public void qianzhi(JoinPoint joinPoint){
        Class<?> target = joinPoint.getTarget().getClass();
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        resolveDataSource(target,methodSignature.getMethod());
    }

    /**
     * 切换数据源
     * @param clazz
     * @param method
     */
    public void resolveDataSource(Class<?> clazz, Method method){
        try {
            if(!clazz.isAnnotationPresent(DataSource.class))
            {
                DynamicDataSourceContextHolder.setDataSourceRouterKey("master");
            }
            if (clazz.isAnnotationPresent(DataSource.class))  // 默认使用类型注解
            {
                DataSource source = clazz.getAnnotation(DataSource.class);
                DynamicDataSourceContextHolder.setDataSourceRouterKey(source.value());
            }
            // 方法注解可以覆盖类型注解
            if(null != method && method.isAnnotationPresent(DataSource.class)){
                DataSource source = method.getAnnotation(DataSource.class);
                DynamicDataSourceContextHolder.setDataSourceRouterKey(source.value());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* @After("qieru()")
    public void houzhi(JoinPoint point, DataSource ds){
        logger.debug("Revert DataSource : " + ds.value() + " > " + point.getSignature());
        DynamicDataSourceContextHolder.removeDataSourceRouterKey();
    }*/
}