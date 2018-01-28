package Stream.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import Stream.day_08.Employee;
import Stream.day_08.Employee.Status;

/**
 * StreamAPI 练习
 * @author gaojiayin
 *
 */
public class TestStreamAPI {
/*
 * 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表呢
 * 给定[1,2,3,4,5]，应付返回【1,4,9,16,25】
 */
	@Test
	public void test(){
		List<Integer> arr=Arrays.asList(1,2,3,4,5);
		arr.stream()
			.map((e)->{return e*e;})
			.forEach((e)->System.out.print(e+" "));
	}
/*
 * 2.使用map,reduce方法数一数流中有多少个Employee呢 
 */
	List<Employee> emps = Arrays.asList(
			new Employee("王五", 16, Status.FREE,231.11), 
			new Employee("赵六", 25, Status.BUSY,555.11),
			new Employee("张三", 46, Status.VOCATION,111.11), 
			new Employee("李四", 37, Status.FREE,222.11),
			new Employee("孙琦", 25, Status.BUSY,555.11),
			new Employee("孙琦", 25, Status.BUSY,555.11)
			
			);
	@Test 
	public void test2(){
		//统计数据
		Optional<Integer> count=emps.stream()
			.map((e)->1)
			.reduce(Integer::sum);
		System.out.println(count.get());
	}
}