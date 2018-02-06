package Interface;
/*
 * 以前的接口中只能有全局静态常量和抽象方法
 * 但是在java8中允许有实现的方法，通过关键字“default”
 * 还可以有静态方法
 * 
 * 
 */
public interface MyFun {
	default String getName() {
		return "哈哈哈";
	}
public static void show() {
	System.out.println("接口中的静态方法");
}
}
