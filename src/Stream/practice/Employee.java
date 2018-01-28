package Stream.practice;
public class Employee {
 public String name;
 public int age;
 public Status status;
public Employee(String name, int age, Status status, double salary) {
	super();
	this.name = name;
	this.age = age;
	this.status = status;
	this.salary = salary;
}
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
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
	return "Employee [name=" + name + ", age=" + age + ", status=" + status + ", salary=" + salary + "]";
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
public enum Status{
	FREE,BUSY,VOCATION;
}
}
