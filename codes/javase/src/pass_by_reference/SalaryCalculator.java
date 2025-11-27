package pass_by_reference;

public class SalaryCalculator {
	void calculateSalary(Person person) {
		int baseSalary = 500;
		person.salary = person.experienceYear * baseSalary;
	}
}
