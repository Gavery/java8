package Stream.day_08;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import Stream.day_08.Employee.Status;


/**
 * stream 查找与匹配
 * @author gaojiayin
 *
 *allMatch——检查是否匹配所有元素
 *anyMatch——检查是否至少匹配一个元素
 *noneMatch——检查是否没有匹配所有元素
 *findFirst——返回第一个元素
 *findAny——返回当前流中的任意元素
 *count——返回流中元素的总个数
 *max——返回流中最大值
 *min——返回流中最小值
 */
public class TestStream2 {
	List<Employee> emps = Arrays.asList(
			new Employee("王五", 16, Status.FREE,231.11), 
			new Employee("赵六", 25, Status.BUSY,555.11),
			new Employee("张三", 46, Status.VOCATION,111.11), 
			new Employee("李四", 37, Status.FREE,222.11),
			new Employee("孙琦", 25, Status.BUSY,555.11)
			);
	@Test
	public void test1(){
		Long count=emps.stream()
			.count();
		Optional<Employee> op=emps.stream()
			.max((e1,e2)->Double.compare(e1.getSalary(), e2.getSalary()));
		Optional<Double> op1=emps.stream()
				.map(Employee::getSalary)
				.min(Double::compare);
		System.out.println("--"+count);
		System.out.println(op.get());
		System.out.println(op1.get());
	}
	@Test
	public void test(){
		boolean b1=emps.stream()	
			.allMatch((e)->e.getStatus().equals(Status.BUSY));
		System.out.println(b1);
		System.out.println("------------");
		boolean b2=emps.stream()
			.anyMatch((e)->e.getStatus().equals(Status.BUSY));
		System.out.println(b2);
		System.out.println("-------------");
		boolean b3=emps.stream()	
				.noneMatch((e)->e.getStatus().equals(Status.BUSY));
		System.out.println(b3);//false 有匹配的一个元素
		System.out.println("-------------");
		Optional<Employee> op=emps.stream()
			.sorted((e1,e2)->-Double.compare(e1.getSalary(),e2.getSalary()))
			.findFirst();
		System.out.println(op.get());
		System.out.println("----------1----");
		Optional<Employee> op1=emps.parallelStream()//获取并行流（多个线程来处理流的操作）
				.filter((e)->e.getStatus().equals(Status.FREE))
				.findAny();
		System.out.println(op1);
	}
}
