package optional.day_10;

import java.util.Optional;

import org.junit.Test;
/*
 * Optional：
 * 作用就是为了避免空指针异常，它把对null的一些运算封装到了容器（Optional）里面
 */
public class testOptional {
/*
  	Optional容器类的常用方法：
 	Optional.of(T t):创建一个Option实例
  	Optional.empty():创建一个空的Optional实例
  	Optional.ofNullable(T t):若t不为null，创建Optional实例，否则创建空实例
  	isPresent():判断是否包含值
  	orElse(T t):如果调用对象包含值，返回该值，否则返回t
  	orElseGet(Supplier s):如果调用对象包含值，返回该值，否则返回s获取的值
  	map(Function f): 如果有值与其处理，并返回处理后的Optinoal,否则返回Optional.empty()
  	flatMap(Function mapper):与map类似，要求返回值必须是Optional
 */
	@Test
	public void test7() {
		Optional<Employee> op=Optional.ofNullable(new Employee());
		Optional<String> str=op.map((e)->e.getName());
		System.out.println(str.get());
		//flatMap要求返回的类型为Optional，所得封装为Optional对象实例返回
		Optional<String> str2=op.flatMap((e)->Optional.of(e.getName()));
		System.out.println(str2.get());
	}
	@Test
	public void test6() {
		/*
		 * 作用和orElse差不多，只是orElseGet里面传入的是一个函数，可以做更多的事情
		 */
		Optional<Employee> op=Optional.ofNullable(null);
		Employee emp=op.orElseGet(()->new Employee());
		System.out.println(emp);
	}
	@Test
	public void test5() {
		/*
		 * orElse:
		 * 如果容器里面有值就创建那个值，如果没有值就设置一个默认的值
		 */
		Optional<Employee> op=Optional.ofNullable(null);
		Employee emp=op.orElse(new Employee());//由于容器里面为null，所以这里就会设置一个默认值
		System.out.println(emp);
	}
	@Test
	public void test4() {
		/*
		 * ispresent判断optional里面是否有值，有值就创建，没有就不创建
		 */
		//Optional<Employee> op=Optional.ofNullable(null);//不会报错，也不会创建null对象
		Optional<Employee> op=Optional.ofNullable(new Employee());
		if(op.isPresent()) {
			System.out.println(op.get());
		}
	}
	@Test
	public void test3() {
		//Optional<Employee> op=Optional.ofNullable(new Employee());
		//ofNullable既能构建对象，也能构建空对象（区别test1和test2）
		Optional<Employee> op=Optional.ofNullable(null);
		System.out.println(op.get());
	}
	@Test
	public void test2() {
		//构建一个空的Optional对象
//		empty只能构建空对象
		Optional<Employee> op=Optional.empty();//这儿不会报错
		System.out.println(op.get());//是这儿输出报的错（和test1区别）
	}
	@Test
	public void test1() {
		//Optional<Employee> op=Optional.of(new Employee());
		/*
		 用处1：
		 能够快速定位到空指针的位置
		 of方法不能构建空对象
		 */
		Optional<Employee> op=Optional.of(null);//这儿就会报错
		Employee emp=op.get();
		System.out.println(emp);
	}
}
