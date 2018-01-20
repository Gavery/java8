package lambda.day_03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import lambda.day_01.Employee;

public class TestLambda {
	List<Employee> emps = Arrays.asList(
			new Employee("张三", 46, 111.11), 
			new Employee("李四", 32, 222.11),
			new Employee("王五", 37, 231.11), 
			new Employee("赵六", 16, 555.11));

	/*
	 * lambda练习
	 * 对集合进行排序
	 */
	@Test
	public void test1() {
		Collections.sort(emps, (e1,e2)->{
			if(e1.getAge()==e2.getAge()){
				return e1.getName().compareTo(e2.getName());
			}else{
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		for(Employee emp:emps){
			System.out.println(emp);
		}
	}
	/*
	 * 需求：
	 * 对一个字符串进行操作
	 */
	@Test
	public void test2(){
		//去除字符串首尾空格
		String trimStr=strHandler("\t\t\t高嘉银  ",str->str.trim());
		System.out.println(trimStr);
		//把小写字符串转换为大写字符串
		String upcase=strHandler("asdf",str->str.toUpperCase());
		System.out.println(upcase);
		//截取字符串
		String subStr=strHandler("廖立晴爱我",str->str.substring(2,5));
		System.out.println(subStr);
	}
	
	 /*
	  * 需求:处理两个long型的数字
	  * 
	  */
	@Test
	public void test3(){
		op(100L,200L,(x,y)->x+y);
	}
	
	//处理字符串的函数
	public String strHandler(String str,MyFunction mf){
		return mf.getValue(str);
	}
	//需求：处理两个long型的数据
	public void op(Long l1,Long l2,MyFunction2<Long,Long> mf){
		System.out.println( mf.getValue(l1, l2));
	}
}
