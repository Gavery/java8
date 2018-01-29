package lambda.day_01;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lambda.day_01.I.FilterEmployee;
import lambda.day_01.I.filterEmpByAge;

public class TestLambda {

	public static void main(String[] args) {
		/*
		 * 需求：需要找到年龄大于好多的人
		 * （比较原始的for循环方法和lambda表达式）
		 */
		List<Employee> em=Arrays.asList(
				new Employee("张三",46,111.11),
				new Employee("李四",32,222.11),
				new Employee("王五",37,231.11),
				new Employee("赵六",16,555.11)
				);
		//调用下面的方法进行filter
		
		
		/*
		 * 第一种方法
		 *此方法过于累赘：
		 *因为如果需求发生变化例如按照工资工资来筛选员工就得重新写个过滤工资的方法
		 */
		//List<Employee> list=filtersEmployee(em);//最普通的方式
		
		/*
		 * 第二种：按照策略模式来优化（用filterEmpByAge这个策略来解决问题）
		 * 此方法的局限性：
		 * 没调用一次策略就要从新new一个类来实现接口，也有代码的冗余性
		 * 比如这儿是按age来筛选，就new了一个filterEmpByAge来实现FilterEmployee这个接口
		 * 如果要想按照工资来筛选又得从新new一个类来实现FilterEmployee这个接口
		 */
		//List<Employee> list=filtersEmployee1(em,new filterEmpByAge());
		
		/*
		 * 第三种方法：传一个匿名函数来实现接口
		 *  理解：
		 *  就相当于第二种方式实现接口的方式，只是这里通过匿名内部内函数来实现接口，
		 *  那样就不需要再创建一个类来实现接口
		 *  但是这种方法也有代码的一些冗余性，因为有用的代码就只有return 那句，其他的都是一样的代码
		 */
		/*
		 * List<Employee> list=filtersEmployee2(em,new FilterEmployee<Employee>(){
		 
			@Override
			public boolean filterEme(Employee t) {
				// TODO Auto-generated method stub
				return t.getAge()>35;
			}
			
		});
		//		for(Employee pre:list){
//			System.out.println(pre);
//		}
		 */
		/*
		 * 第三种方式：lambda表达式
		 */
		List<Employee> list=filtersEmployee2(em,(e)->e.getAge()>35);
		list.forEach(System.out::println);
		
		System.out.println("--------------------------------");
		/*
		 * 第四种方式： stream
		 *
		 */
		em.stream().filter((e)->e.getAge()>35)
					.limit(2)
					.forEach(System.out::println);
		em.stream().map(Employee::getName).forEach(System.out::println);
	    }
	//按照年龄来过滤员工（最原始的方法）
	public static List<Employee> filtersEmployee(List<Employee> emps){
		List<Employee> listEm=new ArrayList<Employee>();
		for(Employee pre:emps){
			if(pre.getAge()>35){
				listEm.add(pre);
			}
		}
		return listEm;
	}
	
	//优化方法1：按照策略方法来解决代码的冗余
	public static List<Employee> filtersEmployee1(List<Employee> emps,FilterEmployee<Employee> em){
		List<Employee> listEm=new ArrayList<Employee>();
		for(Employee pre:emps){
			//调用策略来解决
			if(em.filterEme(pre)){
				listEm.add(pre);
			}
		}
		return listEm;
	}
	//优化方法2：传入一个匿名内部内来解决问题
	public static List<Employee> filtersEmployee2(List<Employee> emps,FilterEmployee<Employee> em){
		List<Employee> listEm=new ArrayList<Employee>();
		for(Employee pre:emps){
			//调用策略来解决
			if(em.filterEme(pre)){
				listEm.add(pre);
			}
		}
		return listEm;
	}
	//优化方法3：lambda表达式
	public static List<Employee> filtersEmployee3(List<Employee> emps,FilterEmployee<Employee> em){
		List<Employee> listEm=new ArrayList<Employee>();
		for(Employee pre:emps){
			//调用策略来解决
			if(em.filterEme(pre)){
				listEm.add(pre);
			}
		}
		return listEm;
	}
}
