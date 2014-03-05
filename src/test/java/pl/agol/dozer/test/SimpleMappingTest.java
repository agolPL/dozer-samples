package pl.agol.dozer.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pl.agol.dozer.test.entity.OtherPerson;
import pl.agol.dozer.test.entity.Person;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class SimpleMappingTest {
	
	private class Mapper {

		public OtherPerson map(Person p) {

			return new OtherPerson()
				.hasAge(p.getAge())
				.hasLastname(p.getLastname())
				.hasName(p.getName());
		}
	}
	
	private Mapper mapper;

	@BeforeClass
	public void setup() {
		mapper = new Mapper();
	}

	@Test
	public void should_create_OtherPerson_from_given_Person() {
		
		//given
		Person person = new Person()
			.hasAge(Person.AGE)
			.hasLastname(Person.LASTNAME)
			.hasName(Person.NAME);
		
		//when
		OtherPerson otherPerson = mapper.map(person);
		
		//than
		assertEquals(otherPerson.getAge(), Person.AGE);
		assertEquals(otherPerson.getName(), Person.NAME);
		assertEquals(otherPerson.getLastname(), Person.LASTNAME);
		
	}
}
