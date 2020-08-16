package com.kevin.multi.datasource.spring.boot.autoconfigure;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 切面
 *
 * @author wangyong
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    /**
     * 拦截目标方法，获取由@DataSource指定的数据源标识，设置到线程存储中以便切换数据源
     */
    @Around("@annotation(DataSource)")
    @Order(-1)
    public Object doAround(ProceedingJoinPoint point) throws Exception {
        Object result = null;
        Object target = point.getTarget();
        String methodName = point.getSignature().getName();
        Class<?> clazz = target.getClass();
        Class<?>[] parameterTypeArray = ((MethodSignature) point.getSignature())
                .getMethod().getParameterTypes();
        try {
            Method method = clazz.getMethod(methodName, parameterTypeArray);
            if (method.isAnnotationPresent(DataSource.class)) {
                DataSource data = method.getAnnotation(DataSource.class);
                DataSourceContextHolder.setDataSource(data.value());
                logger.info("【读写分离】==========================>{}", data.value());
                result = point.proceed();
            }
        } catch (Throwable e) {
            logger.error("【读写分离获取数据源异常】:{}", e.getMessage(), e);
            throw new Exception(e);
        } finally {
            DataSourceContextHolder.clearDataSourceType();
        }
        return result;
    }


}
