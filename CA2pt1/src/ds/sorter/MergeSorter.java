package ds.sorter;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		if (input.size() <= 1)
			return input;

		// Divide the input list into two halves
		List<E> left = input.subList(0, input.size() / 2);
		List<E> right = input.subList(input.size() / 2, input.size());

		// Recursively sort the two halves
		left = sort(left);
		right = sort(right);

		// Merge the sorted halves and return the result
		return merge(left, right);
	}

	private List<E> merge(List<E> left, List<E> right) {
		List<E> result = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < left.size() && j < right.size()) {
			if (left.get(i).compareTo(right.get(j)) <= 0) {
				result.add(left.get(i));
				i++;
			} else {
				result.add(right.get(j));
				j++;
			}
		}
		while (i < left.size()) {
			result.add(left.get(i));
			i++;
		}
		while (j < right.size()) {
			result.add(right.get(j));
			j++;
		}
		return result;
	}
}
