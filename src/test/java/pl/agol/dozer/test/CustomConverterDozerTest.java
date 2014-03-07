package pl.agol.dozer.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pl.agol.dozer.test.entity.composition.CarFactory.Car;
import pl.agol.dozer.test.entity.composition.CarFactory.CarRepairInfo;
import pl.agol.dozer.test.entity.composition.CarFactory.Engine;
import pl.agol.dozer.test.entity.composition.CarFactory.Engine.Enginetype;
import pl.agol.dozer.test.entity.composition.CarFactory.Manufacturer;

/**
 * 
 * @author Andrzej Goławski
 *
 */
public class CustomConverterDozerTest extends DozerXMLTestTemplate {

	public CustomConverterDozerTest() {
		super("CustomerCarFactoryMapping.xml");
	}

	@Test
	public void should_create_CarRepairInfo_from_given_Car() {

		// given		
		Car car = new Car();
		car.setBrand("BMW");
		car.setEngine(new Engine(Enginetype.V6));
		car.setManufacturer(new Manufacturer("Bawaria Motors", "Somewhere in Berlin"));
		

		// when
		CarRepairInfo carRepairInfo = mapper.map(car, CarRepairInfo.class);

		// then
		assertEquals(carRepairInfo.getCarBrand(), car.getBrand());
		assertEquals(carRepairInfo.getEngineType(), car.getEngine().getType());
		assertEquals(carRepairInfo.getEngineType(), car.getEngine().getType());
		assertEquals(carRepairInfo.getManufacturerInfo(), "Bawaria Motors Somewhere in Berlin");

	}

}
