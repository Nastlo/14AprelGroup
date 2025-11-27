package pass_by_reference;

public class MainClass {

	public static void main(String[] args) {
		Person person = new Person();
				person.name = "Omar";
				person.surname = "Jafarli";
				person.experienceYear = 3;
				person.phone = "+9940513753352";
				
				SalaryCalculator calculator = new SalaryCalculator();
				calculator.calculateSalary(person);
				
				person.printlnfo();
	}

}
