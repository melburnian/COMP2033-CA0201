package ds.sorter;

import java.util.Comparator;
import java.util.List;

public class SelectionSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		int n = input.size();

		// Loop through the entire list
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in the unsorted list
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (input.get(j).compareTo(input.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			// Swap the minimum element with the first element in the unsorted list
			E temp = input.get(minIndex);
			input.set(minIndex, input.get(i));
			input.set(i, temp);
		}
		return input;
	}

	@Override
	public List<E> sortType(List<E> input, Comparator<E> comparator) {
		int n = input.size();

		// Loop through the entire list
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in the unsorted list
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (comparator.compare(input.get(j), input.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			// Swap the minimum element with the first element in the unsorted list
			E temp = input.get(minIndex);
			input.set(minIndex, input.get(i));
			input.set(i, temp);
		}
		return input;
	}

	@Override
	public List<E> sortWeight(List<E> input, Comparator<E> comparator) {
		int n = input.size();
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (comparator.compare(input.get(j), input.get(minIndex)) < 0) {
					minIndex = j;
				}
			}

			// Swap the found minimum element with the first element
			E temp = input.get(minIndex);
			input.set(minIndex, input.get(i));
			input.set(i, temp);
		}
		return input;
	}

	@Override
	public List<E> sortRipeness(List<E> input, Comparator<E> comparator) {
		int n = input.size();

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (comparator.compare(input.get(j), input.get(minIndex)) < 0) {
					minIndex = j;
				}
			}

			// Swap the found minimum element with the first element
			E temp = input.get(minIndex);
			input.set(minIndex, input.get(i));
			input.set(i, temp);
		}
		return input;
	}

}