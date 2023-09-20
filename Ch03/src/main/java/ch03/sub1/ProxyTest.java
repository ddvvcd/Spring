package ch03.sub1;


/*
 * 날짜 : 2023/09/19
 * 이름 : 박성용
 * 내용 : Proxy기반 AOP 실습
 * 
 */
public class ProxyTest {
	
	public static void main(String[] args) {
		
		Target targer = new TargetImpl();
		Target proxy = new TargetProxy(targer);
		
		proxy.doBusiness();
	}
}
