package pass_by_reference;

public class Person {
	String name;
	String surname;
	int experienceYear;
	int salary;
	String phone;
	
	void printlnfo() {
		System.out.println("Ad:" + name);
		System.out.println("Soyad:" + surname);
		System.out.println("Is Tecrubesi" + experienceYear);
		System.out.println("Maas" + salary);
		System.out.println("Telefon" + phone);
	}
}
