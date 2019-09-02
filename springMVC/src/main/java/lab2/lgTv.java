package lab2;

public class lgTv implements TV{
	public lgTv() {
		System.out.println("엘지 생성자");
	}
	public void powerOn() {
		System.out.println(this.getClass().getSimpleName()+" 전원을 켠다.");
	}//this.getClass().getSimpleName() 클래스이름을 동적으로 읽어옴.
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName()+" 전원을 끈다.");
	}

}
