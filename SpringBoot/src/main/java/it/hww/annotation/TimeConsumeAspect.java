package it.hww.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Slf4j
@Component
@Aspect
public class TimeConsumeAspect {

    /**
     * 切点定义为注解@annotation(注解类路径)
     */
    @Pointcut("@annotation(TimeConsume)")
    public void consume() {
    }

    @Around("consume()")
    public <T> T around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 获取切入点所有的参数
        Object[] args = joinPoint.getArgs();
        T result;
        Method methodClass;
        try {
            result = (T) joinPoint.proceed(args);
        } finally {
            long endTime = System.currentTimeMillis();

            // 获取签名
            Signature signature = joinPoint.getSignature();
            String methodName = signature.getName();

            // 获取目标对象
            Class<?> targetClass = joinPoint.getTarget().getClass();
            String classSimpleName = targetClass.getSimpleName();

            Class[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
            methodClass = targetClass.getMethod(methodName, parameterTypes);
            // 获取方法上的所有注解
            Annotation[] annotations = methodClass.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> aClass = annotation.annotationType();
                String simpleName = aClass.getSimpleName();
                if ("TimeConsume".equals(simpleName)) {
                    log.info(classSimpleName + ".{} cost time：{} ms", methodName, endTime - startTime);
                    break;
                }
            }

        }
        return result;
    }
}

