package lab1;
//tv��ü�������� Ŭ���� �ٸ� Ŭ������ new�� ������� X
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
