package pl.agol.dozer.test;

import static org.testng.Assert.assertEquals;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pl.agol.dozer.test.AdvancedMappingTest.AdvanceMapper;
import pl.agol.dozer.test.entity.Mtu;
import pl.agol.dozer.test.entity.Person;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class MegaAdvanceMappingTest {

	@Retention(RetentionPolicy.RUNTIME)
	public @interface Mapper {
		String value();
	}

	public class MegaAdvanceMapper<T, S> extends AdvanceMapper<T, S> {

		protected void copyField(Field sourceField, T source, S target) throws Exception {
			try {
				Field targetField = findAnnotatedField(target, sourceField.getName());
				targetField.setAccessible(true);
				sourceField.setAccessible(true);
				targetField.set(target, sourceField.get(source));
			} catch (NoSuchFieldException e) {
				// do nothing
			}
		}

		protected Field findAnnotatedField(S target, String fieldName) throws NoSuchFieldException {
			for (Field field : target.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(Mapper.class)) {
					if (field.getAnnotation(Mapper.class).value().equals(fieldName)) {
						return field;
					}
				}
			}
			throw new NoSuchFieldException();
		}
	}

	private AdvanceMapper<Person, Mtu> mapper;

	@BeforeClass
	public void setup() {
		mapper = new MegaAdvanceMapper<Person, Mtu>();
	}

	@Test
	public void should_create_OtherPerson_from_given_Person() throws Exception {

		// given
		Person person = new Person()
			.hasAge(Person.AGE)
			.hasLastname(Person.LASTNAME)
			.hasName(Person.NAME);

		// when
		Mtu mtu = mapper.map(person, Mtu.class);

		// then
		assertEquals(mtu.getUmri(), Person.AGE);
		assertEquals(mtu.getJina(), Person.NAME);
		assertEquals(mtu.getJinaLaMwisho(), Person.LASTNAME);

	}
}
