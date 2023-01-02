package ds.fruit;

import java.util.Arrays;
import java.util.Comparator;

public class Fruit {
	private int weight;
	private float ripeness;
	private TYPE type;

	// create an enum of TYPE with the values APPLE, PEAR, BANANA, GRAPE
	public enum TYPE {
		APPLE, PEAR, BANANA, GRAPE;

		public String getType() {
			switch (this) {
			case APPLE:
				return "Apple";
			case PEAR:
				return "Pear";
			case BANANA:
				return "Banana";
			case GRAPE:
				return "Grape";
			default:
				return "Unknown";
			}
		}
	}

	public Fruit(TYPE type, int weight, float ripeness)
			throws InvalidFruitWeightException, InvalidFruitRipenessException {
		if (weight < 0) {
			throw new InvalidFruitWeightException("The weight of this fruit cannot be below zero.");
		}
		if (ripeness < 0) {
			throw new InvalidFruitRipenessException("The ripeness of this fruit cannot be below zero.");
		}
		this.type = type;
		this.weight = weight;
		this.ripeness = ripeness;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public float getRipeness() {
		return ripeness;
	}

	public void setRipeness(float ripeness) {
		this.ripeness = ripeness;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		if (ripeness != other.ripeness)
			return false;
		if (type != other.type)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ripeness);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public String toString() {
		return "Fruit [weight=" + weight + "g, ripeness=" + ripeness + "%, type=" + type + "]";
	}

	public static Comparator<Fruit> FruitWeightComparator = new Comparator<Fruit>() {
		@Override
		public int compare(Fruit f1, Fruit f2) {
			int fruitWeight1 = f1.getWeight();
			int fruitWeight2 = f2.getWeight();

			// ascending order
			return fruitWeight1 - fruitWeight2;
		}
	};

	public static Comparator<Fruit> FruitRipenessComparator = new Comparator<Fruit>() {
		@Override
		public int compare(Fruit f1, Fruit f2) {
			int fruitRipeness1 = (int) f1.getRipeness();
			int fruitRipeness2 = (int) f2.getRipeness();
			// ascending order
			return fruitRipeness1 - fruitRipeness2;
		}
	};

	public static Comparator<Fruit> FruitTypeComparator = new Comparator<Fruit>() {

		@Override
		public int compare(Fruit o1, Fruit o2) {
			String fruitType1 = o1.getType().getType();
			String fruitType2 = o2.getType().getType();
			// ascending order
			return fruitType1.compareTo(fruitType2);
		}
	};

	public static void main(String[] args) {
		// CREATE OBJECT OF FRUIT
		try {
			Fruit fruit = new Fruit(TYPE.APPLE, 10, 0);
			System.out.println(fruit.toString());
			Fruit f2 = new Fruit(TYPE.PEAR, 20, 10);
			System.out.println(f2.toString());

			Fruit f3 = new Fruit(TYPE.BANANA, 30, 40);
			System.out.println(f3.toString());

			Fruit f4 = new Fruit(TYPE.GRAPE, 40, 10);
			System.out.println(f4.toString());

			// SORT BY WEIGHT
			System.out.println("\nSorted by weight:");
			Fruit[] fruitList = { f2, f3, f4, fruit };
			Arrays.sort(fruitList, FruitWeightComparator);
			for (Fruit fruit1 : fruitList) {
				System.out.println(fruit1.toString());
			}

			// SORT BY RIPENESS
			System.out.println("\nSorted by ripeness:");
			Fruit[] fruitList2 = { f2, f3, f4, fruit };
			Arrays.sort(fruitList2, FruitRipenessComparator);
			for (Fruit fruit1 : fruitList2) {
				System.out.println(fruit1.toString());
			}

			// SORT BY TYPE
			System.out.println("\nSorted by Type:");
			Fruit[] fruitList3 = { f2, f3, f4, fruit };
			Arrays.sort(fruitList3, FruitTypeComparator);
			for (Fruit fruit1 : fruitList3) {
				System.out.println(fruit1.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}