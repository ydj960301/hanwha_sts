package lab1;

public class samsungTV implements TV{
	public void powerOn() {
		System.out.println(this.getClass().getSimpleName()+"������ �Ҵ�.");
	}//this.getClass().getSimpleName() Ŭ�����̸��� �������� �о��.
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName()+"������ ����.");
	}
	

}
