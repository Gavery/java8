package Stream.day_08;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import lambda.day_01.Employee;

/**
 * stream 排序
 * @author gaojiayin
 *
 */
public class testStream {
	List<Employee> emps = Arrays.asList(
			new Employee("王五", 16, 231.11), 
			new Employee("赵六", 25, 555.11),
			new Employee("张三", 46, 111.11), 
			new Employee("李四", 37, 222.11),
			new Employee("孙琦", 25, 555.11)
			);
	/*
	 * 排序
	 * sorted()——自然排序(Comparable)
	 * sorted(Comparator com)——定制排序（Comparator）
	 */
	@Test
	public void test(){
		List<String> list=Arrays.asList("ccc","aaa","bbb");
		//自然排序
		list.stream()
			.sorted()
			.forEach(System.out::println);
		System.out.println("---------------------");
		//定制排序
		emps.stream()
			.sorted((e1,e2)->{
				if(e1.getAge()==e2.getAge()){
					return e1.getName().compareTo(e2.getName());
				}else{
					return e1.getName().compareTo(e2.getName());
				}
			}).forEach(System.out::println);
	}
}
