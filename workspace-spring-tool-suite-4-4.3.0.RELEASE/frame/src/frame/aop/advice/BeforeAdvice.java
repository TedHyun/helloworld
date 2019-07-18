package frame.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class BeforeAdvice {
	
	public void hello(JoinPoint j) {
		System.out.println("before advice");
	}
	
	public void after(JoinPoint j) {
		System.out.println("after advice");
	}
	//before + after
	public Object around(ProceedingJoinPoint j)throws Throwable {
		System.out.println("around before");
		
		//j.proceed(); mapping �޼��� ȣ��
		// �����帧�� �̾
		Object obj = j.proceed();
		System.out.println("around after");
		return obj;
	}
	
}
