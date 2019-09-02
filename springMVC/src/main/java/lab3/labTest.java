package lab3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class labTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext c=new ClassPathXmlApplicationContext("lab3.xml");
		Car car=c.getBean("car",Car.class);
		System.out.println(car.model);
		System.out.println(car.price);
		System.out.println(car);
		People p=c.getBean("people4",People.class);
		System.out.println(p);
		People p2=c.getBean("people4",People.class);
		//p 와 p2는 같은 주소 같은 객체 single톤은 하나만 만들고 가져다 쓰기때문
		//prototype으로 하면 요청마다 새로운 객체 생성하므로 p와p2 다름.
		

	}

}
