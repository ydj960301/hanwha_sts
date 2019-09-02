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
		return "자동차 정보 [model=" + model + ", price=" + price + "]";
	}
	public String getModel() {
		return model;
	}
	//model은 반드시 set해야함을 표시 annotation이라고 함 근데 이걸 읽어야한다. xml설정에서
	//xmlns:context namespace에서 선택해줘야함.
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
