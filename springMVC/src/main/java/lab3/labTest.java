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
		//p �� p2�� ���� �ּ� ���� ��ü single���� �ϳ��� ����� ������ ���⶧��
		//prototype���� �ϸ� ��û���� ���ο� ��ü �����ϹǷ� p��p2 �ٸ�.
		

	}

}
