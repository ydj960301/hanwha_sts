package lab2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		//ClassPathXmlApplicationContext ���Ǳ����� �̸��ε��Ǳ⶧���� ������ ��ü �������ص� �����ڰ� ����Ʈ�ȴ�.
		ClassPathXmlApplicationContext c=new ClassPathXmlApplicationContext("lab2.xml");
		
		//TV tv1=(TV) c.getBean("stv"); //�������鼭 ������ Object�� ���ϹǷ� ĳ��Ʈ�ʿ�
		TV tv1=(TV) c.getBean("stv",TV.class);
		tv1.powerOn();
		tv1.powerOff();
		
		

	}

}
