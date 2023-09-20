package ch03.sub3;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component("log")
public class LogAdvice {
	
	//위빙 시킴?
	@Pointcut("execution(void ch03.sub3.Service.insert(..))")
	public void insertPointcut() {} //내용이 없는 참조 메서드
	
	@Pointcut("execution(void ch03.sub3.Service.select(..))")
	public void selectPointcut() {} //내용이 없는 참조 메서드

	@Pointcut("execution(void ch03.sub3.Service.update(*))")
	public void updatePointcut() {} //내용이 없는 참조 메서드
	
	@Pointcut("execution(void ch03.sub3.Service.delete(*,*))")
	public void deletePointcut() {} //내용이 없는 참조 메서드

	@Before("insertPointCut() || selectPointCut() || updatePointcut() || deletePointcut()")
	public void beforeLog() {
		System.out.println("----------------------------");
		System.out.println("Cross-cutting - beforeLog...");
	}
	
	@After("insertPointCut() || selectPointCut() || updatePointcut() || deletePointcut()")
	public void afterLog() {
		System.out.println("Cross-cutting - afterLog...");
		System.out.println("----------------------------");
	}
}
