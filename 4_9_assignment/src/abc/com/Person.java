package abc.com;

public class Person {
	public String firstName;
	public String secondName;
	char gendar;
	public String number;
	public enum gender{
		M,F
	}
	
	public Person(String firstName, String secondName, char gendar) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.gendar = gendar;
		if(gendar != 'M' && gendar != 'F') {
			System.out.println("gender must be M or F");
			System.exit(1);
		}
		
		
	}
	
	/*
	public void setGender(char input_gender) {
		if(input_gender != 'M' && input_gender != 'F') {
			System.out.println("wrong gender");
			System.exit(1);
		}
		else if(input_gender == 'M') {
			
		}
	}
	*/
	
	public String toString() {
		
		return "what a happy day!" + firstName + secondName;
	}
	
	public void setNumber(String inputNumber) {
		this.number = inputNumber;
	}
	
	public void print() {
		System.out.println("the info is \n" + "name is : " + firstName + secondName + "\ngendaer is " + gendar + "\nphone number is: " + number );
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public char getGendar() {
		return gendar;
	}
	public void setGendar(char gendar) {
		this.gendar = gendar;
	}
	
	
	
}
