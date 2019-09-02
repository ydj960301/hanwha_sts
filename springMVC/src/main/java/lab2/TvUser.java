package lab2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		//ClassPathXmlApplicationContext 사용되기전에 미리로딩되기때문에 엘지는 객체 생성안해도 생성자가 프린트된다.
		ClassPathXmlApplicationContext c=new ClassPathXmlApplicationContext("lab2.xml");
		
		//TV tv1=(TV) c.getBean("stv"); //가져오면서 무조건 Object로 변하므로 캐스트필요
		TV tv1=(TV) c.getBean("stv",TV.class);
		tv1.powerOn();
		tv1.powerOff();
		
		

	}

}
