package pl.agol.dozer.test.entity.converter;

import org.dozer.DozerConverter;

import pl.agol.dozer.test.entity.composition.CarFactory.Manufacturer;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class ManufacturerToInfoConverter extends DozerConverter<Manufacturer, String> {

	public ManufacturerToInfoConverter() {
		super(Manufacturer.class, String.class);
	}

	@Override
	public String convertTo(Manufacturer manufacturer, String info) {

		return manufacturer.getName() + " " + manufacturer.getAdddress();
	}

	@Override
	public Manufacturer convertFrom(String manufacturer, Manufacturer info) {

		return null;
	}

}
