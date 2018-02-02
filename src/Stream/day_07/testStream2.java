package Stream.day_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import lambda.day_01.Employee;

/**stream 映射
 * @author gaojiayin
 *
 */
public class testStream2 {
	List<Employee> emps = Arrays.asList(
			new Employee("张三", 46, 111.11), 
			new Employee("李四", 32, 222.11),
			new Employee("王五", 37, 231.11), 
			new Employee("赵六", 16, 555.11));
	List<Integer> list=Arrays.asList(13,35,40,50);
	/*
	 * 映射：
	 * map--接受lambda，将元素转换成其他形式或提取信息。接受一个函数作为参数，该
	 * 函数会被应用到每个元素上，并将其映射成一个新的元素。
	 * flatMap--接受一个函数作为参数，将流中的没个值都换成另一个流，然后把所有流连接成一个流
	 */
	@Test
	public void test4(){
		emps.stream()
			.forEach((e)->{
				list.stream()
					.forEach((o)->{
						if(e.getAge()>o){
						}
					});
			});
	}
	@Test
	public void test(){
		List<String> list=Arrays.asList("aaa","bbb","ccc","eee");
		list.stream()
				.map((str)->str.toUpperCase())
				.forEach(System.out::println);
		System.out.println("-----------");
		List<String> a=new ArrayList<String>();
		emps.stream()
				.map(Employee::getName)
				.forEach((e)->{a.add(e);});
		for(String s:a){
			System.out.println(s+"---");
		}
	}
	@Test
	public void test1(){
		List<String> list=Arrays.asList("aaa","bbb","ccc","eee");
		/*
		 * map本身会得到一个流，filterCharacter函数也返回一个流，所有事流中嵌套一个流
		
		Stream<Stream<Character>> stream=list.stream()
							.map(testStream2::filterCharacter);
		stream.forEach((sm)->{
			sm.forEach(System.out::println);
		});
		 */
		
		System.out.println("----------------");
		Stream<Character> stream=list.stream()
			.flatMap(testStream2::filterCharacter);
		stream.forEach(System.out::println);
	}
	public static Stream<Character> filterCharacter(String str){
		List<Character> list=new ArrayList<>();
		for(Character ch:str.toCharArray()){
			list.add(ch);
		}
		return list.stream();
	}
}
