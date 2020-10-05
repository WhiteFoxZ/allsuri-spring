package com.example.allsuri.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// @Bean은 개발자가 제어할 수 없는 외부 라이브러리를 빈(Bean)으로 등록할 때 사용하고, @Component는 개발자가 직접 정의한 클래스를 빈(Bean)으로 등록할 때 사용합니다.
// @Aspect AOP 기능을 하는 클래스의 클래스 레벨에 지정하는 애너테이션입니다.

@Component
@Aspect
public class LoggerAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	//@Around : 어드바이스(Advice)의 종류 중 한 가지로 어드바이스는 모두 다섯 가지의 타입이 있습니다.
	// 다섯 가지 중 어라운드(Around)는 메서드의 호출 자체를 제어할 수 있기 때문에
	//	어드바이스 중 가장 강력한 기능이라고 볼 수 있습니다.

	//@Around("execution(* com.example.allsuri.controller.*Controller.*(..)) or execution(* com.example.allsuri.service.*Impl.*(..)) or execution(* com.example.allsuri.mapper.*Mapper.*(..))")
	@Around("execution(* com.example.allsuri.controller.*Controller.*(..)) or execution(* com.example.allsuri.service.*Impl.*(..)) ")
	public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {

		String type = "";
		String name = joinPoint.getSignature().getDeclaringTypeName();

		if (name.contains("Controller") == true) {
			type = "Controller ===> ";

		} else if (name.contains("Service") == true) {
			type = "ServiceImpl ===> ";

		} else if (name.contains("Mapper") == true) {
			type = "Mapper ===> ";
		}

		logger.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
		return joinPoint.proceed();
	}


}

