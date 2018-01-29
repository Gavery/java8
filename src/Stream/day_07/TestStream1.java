package Stream.day_07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import lambda.day_01.Employee;

/*
 * Stream  * 筛选与切片：
 * 一。Stream的三个操作步骤
 * 1.创建Stream
 * 2.中间操作
 * 3.终止操作（终端操作）
 */
public class TestStream1 {
	List<Employee> emps = Arrays.asList(
			new Employee("张三", 46, 111.11), 
			new Employee("李四", 32, 222.11),
			new Employee("王五", 37, 231.11), 
			new Employee("赵六", 16, 555.11));
	/*
	 * 中间操作
	 * 
	 * 筛选与切片：
	 * filter-接收Lambda,从流中排除某些元素
	 * limit-截断流，使其元素不超过给定数量
	 * skip(n)-跳过元素，返回一个扔掉了前n个元素的流，若
	 * 流中元素不足n个，则返回一个空流
	 * distinct-筛选，通过流所生成元素的hashCode()和equals()去除重复元素
	 */
	
	
	//skip和distinct去重
	@Test
	public void test3(){
		emps.stream()
					.filter((e)->e.getSalary()>300)
					.skip(2)
					.distinct()
					.forEach(System.out::println);
	}
	//limit
	@Test
	public void test2(){
		emps.stream()
					.filter((e)->e.getSalary()>20)
					.limit(2)
					.forEach(System.out::println);
	}
	
	
	//内部迭代,由Stream完成（外部迭代就是我们平时常用的迭代方法）
@Test
public void test(){
//过滤
	//1.先创建流
	Stream<Employee> stream1=emps.stream();
	//2.中间操作(会得到一个新流,但是此时并没有结果，必须要关闭流)
	Stream<Employee> s=stream1.filter((e)->{
		System.out.println("asf");
		return e.getAge()>35;
		});
	//3.终止操作"惰性求值（只有终止了才执行前面的所有流水线）"
	s.forEach(System.out::println);
}
}
