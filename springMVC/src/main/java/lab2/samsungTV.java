package lab2;

public class samsungTV implements TV{
	public samsungTV() {
		System.out.println("�Ｚ ������");
	}
	public void powerOn() {
		System.out.println(this.getClass().getSimpleName()+"������ �Ҵ�.");
	}//this.getClass().getSimpleName() Ŭ�����̸��� �������� �о��.
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName()+"������ ����.");
	}
	

}
