
public class Demo2 {
	public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}
class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {
        empID = id;
    }
}
class Person {
    String name = "No name";
    public Person(){
    	
    }
    public Person(String nm) {
        name = nm;
    }
}