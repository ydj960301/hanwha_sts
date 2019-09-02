package lab4;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
@Component
public class Car {
	String model;
	int price;
	public Car() {}
	public Car(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}
	@Override
	public String toString() {
		return "�ڵ��� ���� [model=" + model + ", price=" + price + "]";
	}
	public String getModel() {
		return model;
	}
	//model�� �ݵ�� set�ؾ����� ǥ�� annotation�̶�� �� �ٵ� �̰� �о���Ѵ�. xml��������
	//xmlns:context namespace���� �����������.
	//@Required
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	

}
