package pl.agol.dozer.test.entity.collection;

import java.util.ArrayList;
import java.util.List;

import pl.agol.dozer.test.entity.composition.CarFactory.Car;

/**
 * 
 * @author Andrzej Goławski
 *
 */
public class Garage {

	private List<Car> cars = new ArrayList<Car>();
	
	public Garage() {
	}

	public Garage(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
}
