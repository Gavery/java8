package lambda.day_01.I;

import lambda.day_01.Employee;

public class filterEmpByAge implements FilterEmployee<Employee> {

	@Override
	public boolean filterEme(Employee t) {
		// TODO Auto-generated method stub
		return t.getAge()>35;
	}

}
