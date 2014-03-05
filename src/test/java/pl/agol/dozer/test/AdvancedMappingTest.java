package pl.agol.dozer.test;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pl.agol.dozer.test.entity.OtherPerson;
import pl.agol.dozer.test.entity.Person;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class AdvancedMappingTest {

	public static class AdvanceMapper<T, S> {

		public S map(T from, Class<S> to) throws Exception {
			S target = to.newInstance();
			mapFields(from, target);
			return target;
		}

		protected void mapFields(T source, S target) throws Exception {
			for (Field field : source.getClass().getDeclaredFields()) {
				if (!Modifier.isStatic(field.getModifiers())) {
					copyField(field, source, target);
				}
			}
		}

		protected void copyField(Field sourceField, T source, S target) throws Exception {
			try {
				Field targetField = target.getClass().getDeclaredField(sourceField.getName());
				sourceField.setAccessible(true);
				targetField.setAccessible(true);
				targetField.set(target, sourceField.get(source));
			} catch (NoSuchFieldException e) {
				// do nothing
			}
		}

	}

	private AdvanceMapper<Person, OtherPerson> mapper;

	@BeforeClass
	public void setup() {
		mapper = new AdvanceMapper<Person, OtherPerson>();
	}

	@Test
	public void should_create_OtherPerson_from_given_Person() throws Exception {

		// given
		Person person = new Person()
			.hasAge(Person.AGE)
			.hasLastname(Person.LASTNAME)
			.hasName(Person.NAME);

		// when
		OtherPerson otherPerson = mapper.map(person, OtherPerson.class);

		// then
		assertEquals(otherPerson.getAge(), Person.AGE);
		assertEquals(otherPerson.getName(), Person.NAME);
		assertEquals(otherPerson.getLastname(), Person.LASTNAME);

	}
}
