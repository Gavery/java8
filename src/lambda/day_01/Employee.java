package lambda.day_01;

public class Employee {
 public String name;
 public int age;
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public double salary;
public Employee() {
	super();
}
public Employee(String name, int age, double salary) {
	super();
	this.name = name;
	this.age = age;
	this.salary = salary;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "员工：【"+this.name+this.age+this.salary+"】";
	}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
}
