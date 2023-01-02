package ds.sorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ds.fruit.Fruit;

public class CustomSorting {

	/**
	 * This method must sort the fruit alphabetically by their type. Fruits must be
	 * sorted in the order Apple, Banana, Grape, Pear. The weight and ripeness of a
	 * fruit should not be considered.
	 *
	 * @param list The list to sort.
	 * @return A sorted list.
	 */

	// Implement custom sorting logic for alphabetical sorting, returning String
	// values of FRUIT enum
	public static List<Fruit> sortByType(List<Fruit> list) {
		// Add a custom comparator to sort the fruits by type
		Collections.sort(list, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit f1, Fruit f2) {
				// Compare the types of the two fruits as strings
				return f1.getType().compareTo(f2.getType());
			}
		});
		return list;
	}

	/**
	 * This method must sort the fruit by their ripeness value, from 100% ripe to 0%
	 * ripe. The type and weight of the fruit should not be considered.
	 *
	 * @param list The fruit to sort
	 * @return
	 */
	public static List<Fruit> sortByRipeness(List<Fruit> list) {
		// Add a custom comparator to sort the fruits by ripeness
		Collections.sort(list, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit f1, Fruit f2) {
				// Compare the ripeness values of the two fruits
				return Double.compare(f1.getRipeness(), f2.getRipeness());
			}
		});
		return list;
	}

	/**
	 * This method must sort the fruit by their weight, from lightest to heaviest.
	 * The type and ripeness of the fruit should not be considered.
	 *
	 * @param list The fruit to sort
	 * @return
	 */
	public static List<Fruit> sortByWeight(List<Fruit> list) {
		// Add a custom comparator to sort the fruits by weight
		Collections.sort(list, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit f1, Fruit f2) {
				// Compare the weight values of the two fruits
				return Double.compare(f1.getWeight(), f2.getWeight());
			}
		});
		return list;
	}
}
