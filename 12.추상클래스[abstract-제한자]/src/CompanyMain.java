
public class CompanyMain {

	public static void main(String[] args) {
		
		Employee[] emps = {
				new SalaryEmployee(1, "KIM", 30000000),
				new SalaryEmployee(2, "KOO", 35000000),
				new SalaryEmployee(3, "HONG", 28000000),
				new HourlyEmployee(4, "PARK", 130, 6300),
				new HourlyEmployee(5, "LEE", 203, 6700),
		};
		
		for (int i = 0; i < emps.length; i++) {
			emps[i].calculatePay();
			if(emps[i] instanceof SalaryEmployee){
				SalaryEmployee.headerPrint();
			}
			else{
				HourlyEmployee.headerPrint();
			}
			emps[i].print();
		}
		
		
		for (int i = 0; i < emps.length; i++) {
			System.out.println(">>사번:"+emps[i].getNo());
			System.out.println(">>인센티브:"+emps[i].calcIncentive());
			System.out.println();
		}
		
		
		
		
	}

}
