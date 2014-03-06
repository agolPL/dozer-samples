package pl.agol.dozer.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pl.agol.dozer.test.entity.Mtu;
import pl.agol.dozer.test.entity.OtherPerson;
import pl.agol.dozer.test.entity.Person;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class SimpleDozerMappingTest extends DozerXMLTestTemplate {

	public SimpleDozerMappingTest() {
		super("PersonMapping.xml");
	}

	@Test
	public void should_create_OtherPerson_from_given_Person() {

		// given
		Person person = new Person()
			.hasAge(Person.PERSON_AGE)
			.hasLastname(Person.PERSON_LASTNAME)
			.hasName(Person.PERSON_NAME);

		// when
		OtherPerson otherPerson = mapper.map(person, OtherPerson.class);

		// than
		assertEquals(otherPerson.getAge(), Person.PERSON_AGE);
		assertEquals(otherPerson.getName(), Person.PERSON_NAME);
		assertEquals(otherPerson.getLastname(), Person.PERSON_LASTNAME);
	}
	
	@Test
	public void should_create_Mtu_from_given_Person() throws Exception {

		// given
		Person person = new Person()
			.hasAge(Person.PERSON_AGE)
			.hasLastname(Person.PERSON_LASTNAME)
			.hasName(Person.PERSON_NAME);

		// when
		Mtu mtu = mapper.map(person, Mtu.class);

		// then
		assertEquals(mtu.getUmri(), Person.PERSON_AGE);
		assertEquals(mtu.getJina(), Person.PERSON_NAME);
		assertEquals(mtu.getJinaLaMwisho(), Person.PERSON_LASTNAME);

	}
	
	

}
