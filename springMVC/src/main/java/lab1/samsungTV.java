package lab1;

public class samsungTV implements TV{
	public void powerOn() {
		System.out.println(this.getClass().getSimpleName()+"전원을 켠다.");
	}//this.getClass().getSimpleName() 클래스이름을 동적으로 읽어옴.
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName()+"전원을 끈다.");
	}
	

}
