package bean;

public class Student implements Comparable{

	private long id;
	private String name;
	
	@Override
	public int compareTo(Object obj) {
		Student stu = (Student)obj;
		return id>stu.id?1:(id==stu.id?0:-1);
	}

	public Student(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
