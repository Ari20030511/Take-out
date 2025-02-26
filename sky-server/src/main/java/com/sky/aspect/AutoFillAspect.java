package com.sky.aspect;


import com.sky.annotation.AutoFill;
import com.sky.constant.AutoFillConstant;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AutoFillAspect {


    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointCut(){}


    @Before("autoFillPointCut()")
    public void autoFillBefore(JoinPoint joinPoint) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        log.info("开始公共字段填充");
        //1.获取当前被拦截到的数据库的操作方法是什么
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();//方法的签名
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);//获得方法的注解对象
        OperationType operationType = autoFill.value();
        //2.获取到当前被拦截的方法参数（emploee实体参数）
        Object[] args = joinPoint.getArgs();
        if(args == null || args.length ==0){
            return;
        }
        Object entity = args[0];
        //3.准备赋值数据，时间，id
        LocalDateTime now = LocalDateTime.now();
        long currentLd = BaseContext.getCurrentId();

        //4.根据不容的而操作类型，根据反射进行赋值
        if(operationType == OperationType.INSERT){
            //为四个公共字段赋值
            Method setCreateTime =  entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
            Method setCreateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
            Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
            Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);


            setCreateTime.invoke(entity,now);
            setUpdateTime.invoke(entity,now);
            setCreateUser.invoke(entity,currentLd);
            setUpdateUser.invoke(entity,currentLd);

        } else if (operationType == OperationType.UPDATE){
            //为两个公共字段赋值
            Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
            Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);
            setUpdateTime.invoke(entity,now);
            setUpdateUser.invoke(entity,currentLd);
        }

    }
}
