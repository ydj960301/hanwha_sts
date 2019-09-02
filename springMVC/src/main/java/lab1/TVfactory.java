package lab1;
//tv객체생성위한 클래스 다른 클래스는 new를 사용할일 X
public class TVfactory {
	public static TV makeTV(String brand) {
		TV tv=null;
		if(brand.equals("sam")) {
			tv=new samsungTV();
		}
		else if(brand.contentEquals("lg")) {
			tv=new lgTv();
		}
		return tv;
	}

}
