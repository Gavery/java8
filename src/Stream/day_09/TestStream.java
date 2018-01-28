package Stream.day_09;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import Stream.day_08.Employee;
import Stream.day_08.Employee.Status;

/**
 * 归约与收集
 * @author gaojiayin
 * map和reduce的连接通常称为map-reduce模式（大数据常用的）
 * 比如：
 * 搜索文章中某一个字出现的次数等等
 * 
 * 先用map做一个提取，然后再用reduce做一个归约操作
 *
 */
public class TestStream {
	List<Employee> emps = Arrays.asList(
			new Employee("王五", 16, Status.FREE,231.11), 
			new Employee("赵六", 25, Status.BUSY,555.11),
			new Employee("张三", 46, Status.VOCATION,111.11), 
			new Employee("李四", 37, Status.FREE,222.11),
			new Employee("孙琦", 25, Status.BUSY,555.11),
			new Employee("孙琦", 25, Status.BUSY,555.11)
			
			);
	/*
	 * 归约
	 * reduce(T identity,BinaryOperator)/reduce(BInaryOperator)——可以将流中元素反复结合起来，得到一个值
	 * 
	 * 收集
	 * collect——将流转换为其他形式。接受一个Collector接口的实现，用于给Stream中元素做汇总的方法
	 * 
	 */
	@Test
	public void test8(){
		String str=emps.stream()
					.map(Employee::getName)
					.collect(Collectors.joining(","));
		System.out.println(str);
	}
	@Test
	public void test7(){
		//组函数
		//得到所有的统计数据(最大值，最小值，平均值。。。)
		DoubleSummaryStatistics dss=emps.stream()
			.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(dss.getSum());
		System.out.println(dss.getAverage());
		System.out.println(dss.getMax());
	}
	
	@Test 
	public void test6(){
		//分片（分区）
		Map<Boolean,List<Employee>> map=emps.stream()
			.collect(Collectors.partitioningBy((e)->e.getSalary()>300));
		System.out.println(map);
	}
	@Test
	public void test5(){
		//多级分组
		Map<Status,Map<String,List<Employee>>> map=emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus,Collectors.groupingBy((e)->{
				if(e.getAge()<=35){
					return "青年";
				}else if(e.getAge()<=50){
					return "中年";
				}else{
					return "老年";
				}
			})));
		System.out.println(map); 
	}
	@Test
	public void test4(){
		//分组(按照状态分组)
		Map<Status,List<Employee>> map=emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println(map);
	}
	@Test
	public void test3(){
		//总数
		Long count=emps.stream()
			.collect(Collectors.counting());
		System.out.println(count);
		//平均值
		Double avg=emps.stream()
			.collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(avg);
		//总和
		Double sum=emps.stream()
			.collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		//最大值
		Optional<Employee> maxEm=emps.stream()
				.collect(Collectors.maxBy((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary())));
		System.out.println(maxEm.get());
		//最小工资
		Optional<Double> min=emps.stream()
			.map(Employee::getSalary)
			.collect(Collectors.minBy(Double::compare));
		System.out.println(min.get());
	}
	@Test
	public void test2(){		/*
		 * collect接受一个接口的实现方法，Collectors就是它本身一个实例，里面提供了许多静态的方法供我们使用
		 */
		
		//收集为list集合
		List<String> list=emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toList());
		System.out.println(list);
		System.out.println("-----------------");
		//收集为set集合去重
		Set<String> set=emps.stream()
							.map((e)->e.getName())
							.collect(Collectors.toSet());
		System.out.println(set);
		System.out.println("-----------");
		//自定义其他集合类型
		HashSet<String> hset=emps.stream()
							.map(Employee::getName)
							.collect(Collectors.toCollection(HashSet::new));
		System.out.println(hset);
	}
	@Test
	public void test(){
		List<Integer> list=Arrays.asList(1,2,3,4,4,5);
		Integer sum=list.stream()
			.reduce(0,(x,y)->x+y);//0为起始值(起始值为多少)，后面的x,y就是对集合中的元素进行累加运算（先去集合中元素x,y。然后相加后作为x，再取元素y，一次累加）
		System.out.println(sum);
		System.out.println("--------------");
		//这儿返回一个Optional，因为无法确定返回是否为null值，而上面由于指定了初始值的，返回值不会为空
		Optional<Double> op=emps.stream()
			.map(Employee::getSalary)
			.reduce(Double::sum);
		System.out.println(op.get());
		System.out.println("-------------");
		Integer[] nums=new Integer[]{1,2,3,4,5};
		Arrays.stream(nums)
				.map((x)->x*x)
				.forEach(System.out::println);
		System.out.println("-------------");
		
	}
}
