package pl.agol.dozer.test.entity.inheritance;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class ZooDomain {

	public static abstract class Animal {

		protected String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static class Dog extends Animal {

		public Dog() {
			name = "Reksio";
		}
	}

	public static class Bull extends Animal {

		public Bull() {
			name = "Jordan";
		}
	}

	public static class AnimalInfo {

		private String animalName;

		public String getAnimalName() {
			return animalName;
		}

		public void setAnimalName(String animalName) {
			this.animalName = animalName;
		}
	}
}
