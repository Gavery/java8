package lambda.day_05;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import lambda.day_01.Employee;

/*
 * 方法引用：若lambda体中的内容有方法已经实现了，
 * 可以使用“方法引用”
 * 
 * （可以理解为方法引用是lambda表达式的另外一种表现形式）
 * 
 * 方法引用的格式（主要有三种）：
 * 对象：：实例方法名
 * 
 * 类：：静态方法名
 * 
 * 类：：实例方法名
 * 
 * 
 * 注意：lambda体中的方法返回值和参数列表要与函数式接口中
 * 的参数列表和返回值类型保持一致
 * 
 * 二。构造器引用：
 * ClassName::new
 * 
 * 注意：构造器里面的参数要和函数式接口中的一致
 * 
 * 三：数组引用：
 * Type::new
 */
public class TestLambda {
	/*
	 * 数组引用
	 */
	@Test
	public void test6(){
		Function<Integer,String[]> fun=(x)->new String[x];
		String[] strs=fun.apply(10);
		System.out.println(strs.length);
		
		Function<Integer,String[]> fun2=String[]::new;
		System.out.println(fun2.apply(10).length);
	}
	/*
	 * 构造器引用
	 */
	@Test
	public void test5(){
		Supplier<Employee> sup=()->new Employee();
		
		//构造器引用
		/*
		 * 调用的构造器是它的参数列表和接口中的参数列表一样的那个
		 */
		Supplier<Employee> sup2=Employee::new;
	}
	/*
	 * 类：：实例方法名
	 */
	@Test
	public void test4(){
		//比较两个字符串是否一样
		/*
		 * equals是实例方法
		 * 要求第一个参数是方法的调用者，另一个参数是方法调用
		 * 时的参数时
		 */
		BiPredicate<String,String> bp=(x,y)->x.equals(y);
		BiPredicate<String,String> bp2=String::equals;
	}
	/*
	 * 类：：静态方法
	 */
	@Test
	public void test3(){
		Comparator<Integer> com=(x,y)->Integer.compare(x,y);
		
		Comparator<Integer> com1=Integer::compare;
		
	}
	/*
	 * 对象：：实例方法名
	 */
@Test
public void test1(){
	//lambda体中有内容已有实现的方法，
	//并且要求这个已有的方法的参数和返回值
	//要和实现接口中的方法返回类型和参数一致
	PrintStream ps1=System.out;
	Consumer<String> con=(x)->ps1.println(x);
	
	PrintStream ps=System.out;
	Consumer<String> con1=ps::println;
	
	Consumer<String> con2=System.out::println;
	con2.accept("你好");
}
@Test
public void test2(){
	Employee emp=new Employee();
	//供给型接口
	Supplier<String> sup=()->emp.getName();
	String str=sup.get();
	System.out.println(str);
	
	//因为该形式的调用的前提是要求是emp中的方法的参数和返回值和supplier
	//中的一样，所以这里连方法的扩号这些都省略了
	Supplier<Integer> sup2=emp::getAge;
	Integer num=sup2.get();
	System.out.println(num);
}
}
