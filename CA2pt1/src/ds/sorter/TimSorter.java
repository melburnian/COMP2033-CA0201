package ds.sorter;

import java.util.ArrayList;
import java.util.List;

public class TimSorter<E extends Comparable<E>> implements Sorter<E> {
	private static final int MIN_MERGE = 32;
	private final List<E> aux;

	public TimSorter(List<E> input) {
		aux = new ArrayList<>(input.size());
	}

	@Override
	public List<E> sort(List<E> input) {
		int n = input.size();
		// Initialise the auxiliary array
		for (int i = 0; i < n; i++) {
			aux.add(null);
		}
		// Perform the TimSort algorithm
		for (int len = MIN_MERGE; len < n; len *= 2) {
			for (int lo = 0; lo < n - len; lo += len + len) {
				int mid = lo + len - 1;
				int hi = Math.min(lo + len + len - 1, n - 1);
				merge(input, lo, mid, hi);
			}
		}
		// Return the sorted list
		return input;
	}

	private void merge(List<E> input, int lo, int mid, int hi) {
		// Initialise the indices for the left, right, and merged subarrays
		int i = lo;
		int j = mid + 1;
		int k = lo;

		// Copy the elements of the input list into the aux array
		for (int l = lo; l <= hi; l++) {
			aux.set(l, input.get(l));
		}

		// Compare the elements in the left and right subarrays and
		// copy the smaller element back into the input list
		while (i <= mid && j <= hi) {
			if (aux.get(i).compareTo(aux.get(j)) < 0) {
				input.set(k, aux.get(i));
				i++;
			} else {
				input.set(k, aux.get(j));
				j++;
			}
			k++;
		}

		// Copy the remaining elements from the left subarray back into the input list
		while (i <= mid) {
			input.set(k, aux.get(i));
			i++;
			k++;
		}

		// Copy the remaining elements from the right subarray back into the input list
		while (j <= hi) {
			input.set(k, aux.get(j));
			j++;
			k++;
		}
	}
}
