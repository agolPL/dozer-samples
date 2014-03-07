package pl.agol.dozer.test.entity.composition;

import pl.agol.dozer.test.entity.composition.CarFactory.Engine.Enginetype;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class CarFactory {

	public static class Car {

		private String brand;

		private Engine engine;

		private Manufacturer manufacturer;

		public Engine getEngine() {
			return engine;
		}

		public void setEngine(Engine engine) {
			this.engine = engine;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public Manufacturer getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(Manufacturer manufacturer) {
			this.manufacturer = manufacturer;
		}

	}

	public static class Engine {

		public enum Enginetype {
			V6, V8
		}

		private Enginetype type;

		public Engine() {
		}

		public Engine(Enginetype type) {
			this.type = type;
		}

		public Enginetype getType() {
			return type;
		}

		public void setType(Enginetype type) {
			this.type = type;
		}

	}

	public static class Manufacturer {

		private String name;

		private String adddress;

		public Manufacturer() {
		}

		public Manufacturer(String name, String adddress) {
			this.name = name;
			this.adddress = adddress;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAdddress() {
			return adddress;
		}

		public void setAdddress(String adddress) {
			this.adddress = adddress;
		}

	}

	public static class CarRepairInfo {

		private String carBrand;

		private Enginetype engineType;

		private String manufacturerInfo;

		public String getCarBrand() {
			return carBrand;
		}

		public void setCarBrand(String carBrand) {
			this.carBrand = carBrand;
		}

		public Enginetype getEngineType() {
			return engineType;
		}

		public void setEngineType(Enginetype engineType) {
			this.engineType = engineType;
		}

		public String getManufacturerInfo() {
			return manufacturerInfo;
		}

		public void setManufacturerInfo(String manufacturerInfo) {
			this.manufacturerInfo = manufacturerInfo;
		}

	}

}
