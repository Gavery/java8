package Interface;


public class TestDefaultInterface {
	public static void main(String[] args) {
		SubClass sc=new SubClass();
		//类优先原则，如果父类中有一个方法，接口中也有一个同名方法，类中先优先
		System.out.println(sc.getName());
		MyFun.show();//接口中的静态方法
	}
}
