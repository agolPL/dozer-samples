package pl.agol.dozer.test;

import static org.dozer.loader.api.FieldsMappingOptions.customConverter;
import static org.testng.Assert.assertEquals;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.testng.annotations.BeforeClass;
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
public class DozerBuilderMappingTest {
	
	
	protected DozerBeanMapper mapper;
	
	private BeanMappingBuilder builder = new BeanMappingBuilder() {
		
		@Override
		protected void configure() {
			
			mapping(Car.class, CarRepairInfo.class )
				.fields("brand", "carBrand")
				.fields("engine.type", "engineType")
				.fields("manufacturer", "manufacturerInfo", 
						customConverter("pl.agol.dozer.test.entity.converter.ManufacturerToInfoConverter") );
		}
	};
	
	@BeforeClass
	public void setup() {
		mapper = new DozerBeanMapper();
		mapper.addMapping(builder);
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
