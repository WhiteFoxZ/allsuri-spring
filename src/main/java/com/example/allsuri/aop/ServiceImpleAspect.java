package com.example.allsuri.aop;

import java.util.Iterator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.allsuri.service.DefaultService;

// @Bean은 개발자가 제어할 수 없는 외부 라이브러리를 빈(Bean)으로 등록할 때 사용하고, @Component는 개발자가 직접 정의한 클래스를 빈(Bean)으로 등록할 때 사용합니다.
// @Aspect AOP 기능을 하는 클래스의 클래스 레벨에 지정하는 애너테이션입니다.

@Component
@Aspect
public class ServiceImpleAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());






	//Target 메서드 호출 이전에 적용할 어드바이스 정의
	//@Before("execution(* com.example.allsuri.service.CommInfoService.insertDmlCommInfoTransationAop())")

//	@Before(" execution(* @annotation(Transactional) com.example.allsuri.service.CommInfoService.insertDmlCommInfoTransationAop() ) ")

	@Before("execution(@Transactional * com.example.allsuri.service.CommInfoService.insertDmlCommInfoTransationAop()) ")
	public void beforeAdvice(JoinPoint  joinPoint)  {

		String name = joinPoint.getSignature().getDeclaringTypeName();

		DefaultService service = (DefaultService)joinPoint.getTarget();

		PlatformTransactionManager transactionManager=  service.getTransactionManager();

		TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		service.setTxStatus(txStatus);

		logger.debug( "******************************");
		logger.debug( name + "." + joinPoint.getSignature().getName() + " mapper 호출전 입니다.()");
		logger.debug( "txStatus : "+txStatus.toString());
		logger.debug( "txStatus.hasSavepoint : "+txStatus.hasSavepoint());
		logger.debug( "txStatus.isNewTransaction : "+txStatus.isNewTransaction());
		logger.debug( "txStatus.isCompleted : "+txStatus.isCompleted());
		logger.debug( "txStatus.isRollbackOnly : "+txStatus.isRollbackOnly());






	}

	//Target 메서드가 성공적으로 실행되고, 결괏값을 반환한 뒤에 적용
	@AfterReturning("execution(* com.example.allsuri.service.CommInfoService.insertDmlCommInfoTransationAop())")
	public void afterReturningAdvice(JoinPoint joinPoint) throws Throwable {

		String name = joinPoint.getSignature().getDeclaringTypeName();

		DefaultService service = (DefaultService)joinPoint.getTarget();

		PlatformTransactionManager transactionManager=  service.getTransactionManager();

		TransactionStatus txStatus = service.getTxStatus();

		logger.debug( "***********commit commit *************");
		if(txStatus!=null && txStatus.isNewTransaction() ) {
		transactionManager.commit(txStatus);


		logger.debug( "txStatus : "+txStatus.toString());
		logger.debug( "txStatus.hasSavepoint : "+txStatus.hasSavepoint());
		logger.debug( "txStatus.isNewTransaction : "+txStatus.isNewTransaction());
		logger.debug( "txStatus.isCompleted : "+txStatus.isCompleted());
		logger.debug( "txStatus.isRollbackOnly : "+txStatus.isRollbackOnly());
		logger.debug( name + "." + joinPoint.getSignature().getName() + " commit 호출");
		}else {
			logger.debug( "***********txStatus is null *************");
		}





	}


	//Target 메서드에서 예외 발생 이후에 적용
	@AfterThrowing("execution(* com.example.allsuri.service.CommInfoService.insertDmlCommInfoTransationAop())")
	public void afterThrowingAdvice(JoinPoint joinPoint) throws Throwable {

		String name = joinPoint.getSignature().getDeclaringTypeName();

		DefaultService service = (DefaultService)joinPoint.getTarget();

		PlatformTransactionManager transactionManager=  service.getTransactionManager();

		TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

		transactionManager.rollback(txStatus);



		logger.debug( "***********rollback rollback *************");
		if(txStatus!=null && txStatus.isNewTransaction() ) {
		transactionManager.commit(txStatus);


		logger.debug( "txStatus : "+txStatus.toString());
		logger.debug( "txStatus.hasSavepoint : "+txStatus.hasSavepoint());
		logger.debug( "txStatus.isNewTransaction : "+txStatus.isNewTransaction());
		logger.debug( "txStatus.isCompleted : "+txStatus.isCompleted());
		logger.debug( "txStatus.isRollbackOnly : "+txStatus.isRollbackOnly());
		logger.debug( name + "." + joinPoint.getSignature().getName() + " rollback 호출");
		}else {
			logger.debug( "***********txStatus is null *************");
		}


	}

	//Target 메서드에서 예외 발생에 관계없이 적용 try/catch 문의 finally와 유사
	@After("execution(* com.example.allsuri.service.CommInfoService.insertDmlCommInfoTransationAop())")
	public void afterAdvice(JoinPoint joinPoint) throws Throwable {

		String name = joinPoint.getSignature().getDeclaringTypeName();

		logger.debug( name + "." + joinPoint.getSignature().getName() + " finally 호출");

	}

}
