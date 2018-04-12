
public class Person {
	String name = "A";
	int age = 5;
	int weight = 10;
	
	
	
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			
			Person p = (Person) obj;
			if(p.name.equals(name) && p.age == age && p.weight == weight) {
				return true;
			}
			else {
				return false;
			}
			
		}
		else {
			return false;
		}
		
	}

}
