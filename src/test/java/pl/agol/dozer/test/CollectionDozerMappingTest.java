package pl.agol.dozer.test;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.testng.annotations.Test;

import pl.agol.dozer.test.entity.collection.Garage;
import pl.agol.dozer.test.entity.collection.GarageInfo;
import pl.agol.dozer.test.entity.composition.CarFactory.Car;
import pl.agol.dozer.test.entity.composition.CarFactory.CarRepairInfo;
import pl.agol.dozer.test.entity.composition.CarFactory.Engine;
import pl.agol.dozer.test.entity.composition.CarFactory.Engine.Enginetype;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class CollectionDozerMappingTest extends DozerXMLTestTemplate {

	public CollectionDozerMappingTest() {
		super("CollectionMapping.xml");
	}

	@Test
	public void should_create_GarageInfo_from_given_Garage() {

		// given
		Car bmw = new Car();
		bmw.setBrand("BMW");
		bmw.setEngine(new Engine(Enginetype.V6));

		Car peugeot = new Car();
		peugeot.setBrand("PEUGEOT");
		peugeot.setEngine(new Engine(Enginetype.V8));

		Garage garage = new Garage(Arrays.asList((new Car[] { bmw, peugeot })));

		// when
		GarageInfo garageInfo = mapper.map(garage, GarageInfo.class);

		// then
		assertEquals(garageInfo.getCarRepairInfos().size(), 2);
		assertEquals(garageInfo.getCarRepairInfos().get(0).getCarBrand(), bmw.getBrand());
		assertEquals(garageInfo.getCarRepairInfos().get(0).getEngineType(), bmw.getEngine().getType());
		assertEquals(garageInfo.getCarRepairInfos().get(1).getEngineType(), peugeot.getEngine().getType());
		assertEquals(garageInfo.getCarRepairInfos().get(1).getEngineType(), peugeot.getEngine().getType());

	}

	@Test
	public void should_create_CarRepairInfo_from_given_Garage() {

		// given
		Car bmw = new Car();
		bmw.setBrand("BMW");
		bmw.setEngine(new Engine(Enginetype.V6));

		Car peugeot = new Car();
		peugeot.setBrand("PEUGEOT");
		peugeot.setEngine(new Engine(Enginetype.V8));

		Garage garage = new Garage(Arrays.asList((new Car[] { bmw, peugeot })));

		// when
		CarRepairInfo firstCarRepairInfo = mapper.map(garage, CarRepairInfo.class);

		// then
		assertEquals(firstCarRepairInfo.getCarBrand(), bmw.getBrand());
		assertEquals(firstCarRepairInfo.getEngineType(), bmw.getEngine().getType());

	}

}
