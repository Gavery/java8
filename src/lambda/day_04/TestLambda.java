package lambda.day_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/*java向我们提供了一些常用的函数式接口以便用于lambda表达式
 * lambda常用的内置函数式接口
 * 
 * 四大核心函数式接口：
 * 
 * Consumer<T>:消费型接口（没有返回值，只是对参数进行操作）
 *    void accept(T t);
 * Supplier<T>:供给型接口(产生对象)
 *     T get();
 * Function<T,R>:函数型接口
 * 		R apply(T t);
 * Predicate<T>:断言型接口
 * 		boolean test(T t);
 * 
 */
public class TestLambda {
	/*
	 * Predicate<T>：断言型接口
	 * 需求：过滤字符串
	 */
	@Test
	public void test4(){
		List<String> list=Arrays.asList("Hello","ok","morning","orange","rir");
		List<String> a=filterStr(list,(x)->x.length()>3);
		System.out.println(a);
	}
	public List<String> filterStr(List<String> a,Predicate<String> pre){
		List<String> list=new ArrayList<String>();
		for(String str:a){
			if(pre.test(str)){
				list.add(str);
			}
		}
		return list;
	}
	/*
	 * Function<T,R>函数型接口
	 *需求：对字符串进行操作
	 */
	@Test
	public void test3(){
		//去字符串空格
		String newStr=op("\t\t\t高嘉银爱廖立晴",(str)->str.trim());
		System.out.println(newStr);
		//截取字符串
		String subStr=op("廖立晴是美女胖子",(str)->str.substring(0,6));
		System.out.println(subStr);
	}
	public String op(String str,Function<String,String> mf){
		return mf.apply(str);
	}
/*
 * Supplier<T> 供给型接口
 */
//需求：产生指定个数的整数，并放入集合中
   @Test
   public void test2(){
	   List<Integer> list=getNumber(10,()->(int)(Math.random()*100));
	   System.out.println(list);
   }
   public List<Integer> getNumber(int num,Supplier<Integer> sup){
	   List<Integer> list=new ArrayList<>();
	   for (int i = 0; i < num; i++) {
		Integer n=sup.get();
		list.add(n);
	}
	   return list;
   }
	
//Consumer<T>消费型接口：
	@Test
	public void test(){
		happy(1000,(x)->System.out.println(x));
	}
	public void happy(double money,Consumer<Double> con){
		con.accept(money);
	}
}
