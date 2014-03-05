package pl.agol.dozer.test.entity;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class OtherPerson {

	private String name;
	private String lastname;
	private Integer age;

	public String getName() {
		return name;
	}

	public OtherPerson hasName(String name) {
		this.name = name;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public OtherPerson hasLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public OtherPerson hasAge(Integer age) {
		this.age = age;
		return this;
	}
}
