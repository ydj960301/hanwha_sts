package lab4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("people2") 객체 생성시 이름이렇게 줄수있다.
@Component
public class People {
	String name;
	String phone;
	@Autowired
	Car car; //car가 알아서 들어옴
	List<String> major;
	@Autowired
	List<License> license;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public People() {
		
	}
	

	public List<String> getMajor() {
		return major;
	}

	public void setMajor(List<String> major) {
		this.major = major;
	}

	public List<License> getLicense() {
		return license;
	}

	public void setLicense(List<License> license) {
		this.license = license;
	}

	public People(String name, String phone, Car car, List<String> major, List<License> license) {
		super();
		this.name = name;
		this.phone = phone;
		this.car = car;
		this.major = major;
		this.license = license;
	}
	

	public People(String name, String phone, Car car) {
		super();
		this.name = name;
		this.phone = phone;
		this.car = car;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", phone=" + phone + ", car=" + car + ", major=" + major + ", license="
				+ license + "]";
	}
	

	

}
