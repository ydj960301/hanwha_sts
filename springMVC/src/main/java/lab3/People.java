package lab3;

import java.util.List;

public class People {
	String name;
	String phone;
	Car car;
	List<String> major;
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
