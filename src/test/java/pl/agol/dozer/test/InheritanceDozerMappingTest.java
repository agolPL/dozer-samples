package pl.agol.dozer.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pl.agol.dozer.test.entity.inheritance.ZooDmain.AnimalInfo;
import pl.agol.dozer.test.entity.inheritance.ZooDmain.Bull;
import pl.agol.dozer.test.entity.inheritance.ZooDmain.Dog;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class InheritanceDozerMappingTest extends DozerXMLTestTemplate {

	public InheritanceDozerMappingTest() {
		super("ZooMapping.xml");
	}

	@Test
	public void should_create_AnimalInfo_from_given_Dog() {

		// given
		Dog dog = new Dog();

		// when
		AnimalInfo animalInfo = mapper.map(dog, AnimalInfo.class);

		// then
		assertEquals(dog.getName(), animalInfo.getAnimalName());

	}

	@Test
	public void should_create_AnimalInfo_from_given_Cat() {

		// given
		Bull bull = new Bull();

		// when
		AnimalInfo animalInfo = mapper.map(bull, AnimalInfo.class);

		// then
		assertEquals(bull.getName(), animalInfo.getAnimalName());

	}
}
