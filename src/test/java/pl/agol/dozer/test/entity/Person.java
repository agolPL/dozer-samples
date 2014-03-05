package pl.agol.dozer.test.entity;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class Person {

	public static final String NAME = "Andrzej";
	public static final String LASTNAME = "Goławski";
	public static final Integer AGE = 34;

	private String name;
	private String lastname;
	private Integer age;

	public String getName() {
		return name;
	}

	public Person hasName(String name) {
		this.name = name;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public Person hasLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public Person hasAge(Integer age) {
		this.age = age;
		return this;
	}

}
