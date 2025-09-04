package lx.edu.springmvc.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LogAdvice {
	
	@Before("execution(* lx.edu.springmvc.controller.Addr*.*(..))")
	public void beforeLog(JoinPoint joinPoint) {
		System.out.println("LogAdvice.beforeLog()");
		Class targetClass = joinPoint.getTarget().getClass();
		String methodName = joinPoint.getSignature().getName();
		System.out.printf("class=%s, method=%s\n", targetClass.getName(), methodName);
	}
	
}
