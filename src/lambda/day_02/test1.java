package lambda.day_02;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

/*
 *lambda就是对接口中的方法进行实现
 *相当于java7中的匿名内部内
 *lambda表达式需要“函数式接口的支持”
 *函数式接口：接口中只有一个抽象方法的接口，称为函数式接口，
 *可以使用注解@FunctionalInterface进行修饰
 *
 * lambda的基础语法：
 * “->”lambda操作符：将lambda表达式拆分成两部分：
 * 左侧：lambda的参数列表
 * 右侧：lambda中需要执行的功能，即lambda体
 * 
 * 语法格式1：接口中无参数，无返回值的情况
 * 	()->System.out.println("hello world");
 * 语法格式2：有一个参数，无返回值（若只有一个参数，小括号可以不写）
 *  (X)->System.out.println(X)或者X->System.out.println(X)
 *  语法格式3：有多个参数，有返回值并且Lambda体中有多条语句
 *  多条语句必须用大括号包住
 *  语法格式4：若lambda体中只有一条语句，return 和大括号都可以不写
 *  Comparator<Integer> com=(x,y)->Integer.compare(x, y);
 *  语法格式5：lambad参数列表的数据类型可以省略不写，因为jvm编译器通过上下文来推断出数据类型，即“类型推断”
 *  
 */
public class test1 {
//无参数，无返回值
@Test
public void test1(){
	Runnable r=new Runnable(){
		@Override
		public void run() {
			System.out.println("hello");		
		}	
	};
	r.run();
	System.out.println("----------------");
	Runnable r1=()->System.out.println("hello world");
	r1.run();
}
//有参无返回值
@Test
public void test2(){
	Consumer<String> con=(X)->System.out.println(X);
	con.accept("高嘉银");
}
//语法格式3:有两个参数并且有多条语句
@Test
public void test3(){
	Comparator<Integer> com=(x,y)->{
		System.out.println("函数式接口");
		return Integer.compare(x, y);
	};
}
//语法格式4：
@Test
public void test4(){
	Comparator<Integer> com=(x,y)->Integer.compare(x, y);
}
//语法格式5：
@Test
public void test5(){
	String[] strs={"aaa","bbb","ccc"};
}

/*
 * 需求：
 * 对一个数进行运算
 */
@Test
public void test6(){
	Integer num=operation(100,(x)->x*x);
	System.out.println(num);
}
public Integer operation(Integer num,MyFun mf){
	return mf.getValue(num);
}
}
