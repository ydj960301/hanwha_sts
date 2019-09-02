package lab2;

public class samsungTV implements TV{
	public samsungTV() {
		System.out.println("삼성 생성자");
	}
	public void powerOn() {
		System.out.println(this.getClass().getSimpleName()+"전원을 켠다.");
	}//this.getClass().getSimpleName() 클래스이름을 동적으로 읽어옴.
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName()+"전원을 끈다.");
	}
	

}
