package Interface;

/*
 * 如果两个接口中都有相同的方法，那么久要求必须要实现其中一个的方法来解决冲突
 */
public class SubClass2 implements MyFun,MyInterface {

	//实现的是MyFun中的方法
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return MyFun.super.getName();
	}

}
