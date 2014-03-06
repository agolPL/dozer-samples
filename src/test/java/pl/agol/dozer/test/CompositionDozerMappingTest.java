package pl.agol.dozer.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pl.agol.dozer.test.entity.composition.CarFactory.Car;
import pl.agol.dozer.test.entity.composition.CarFactory.CarRepairInfo;
import pl.agol.dozer.test.entity.composition.CarFactory.Engine;
import pl.agol.dozer.test.entity.composition.CarFactory.Engine.Enginetype;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class CompositionDozerMappingTest extends DozerXMLTestTemplate {

	public CompositionDozerMappingTest() {
		super("CarFactoryMapping.xml");
	}

	@Test
	public void should_create_CarRepairInfo_from_given_Car() {

		// given
		Car car = new Car();
		car.setBrand("BMW");
		car.setEngine(new Engine(Enginetype.V6));

		// when
		CarRepairInfo carRepairInfo = mapper.map(car, CarRepairInfo.class);

		// then
		assertEquals(car.getBrand(), carRepairInfo.getCarBrand());
		assertEquals(car.getEngine().getType(), carRepairInfo.getEngineType());

	}

	@Test
	public void should_create_Car_from_given_CarRepairInfo() {

		// given
		CarRepairInfo carRepairInfo = new CarRepairInfo();
		carRepairInfo.setCarBrand("BMW");
		carRepairInfo.setEngineType(Enginetype.V6);

		// when
		Car car = mapper.map(carRepairInfo, Car.class);

		// then
		assertEquals(carRepairInfo.getCarBrand(), car.getBrand());
		assertEquals(carRepairInfo.getEngineType(), car.getEngine().getType());

	}

}
