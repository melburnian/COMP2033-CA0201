package ds.sorter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TimSortHelper<E extends Comparable<E>> {
	private List<E> input;
	private List<E> sortedList;
	private static final int MIN_MERGE = 32;

	public TimSortHelper(List<E> input) {
		this.input = input;
		this.setSortedList(new ArrayList<>(input));
	}

	public void sort() {
		// Create a list of sublists, each of length MIN_MERGE
		List<List<E>> sublists = createSublists();

		// Sort each sublist using an insertion sort
		for (List<E> sublist : sublists) {
			insertionSort(sublist);
		}

		// Initialise the merge stack with the sublists
		Deque<List<E>> stack = new ArrayDeque<>();
		stack.addAll(sublists);

		// Keep merging sublists until the stack is empty
		while (!stack.isEmpty()) {
			// Pop the top two sublists off the stack
			List<E> left = stack.pop();
			List<E> right = stack.pop();

			// Merge the left and right sublists
			List<E> merged = merge(left, right);

			// If the stack is empty, the merged sublist is the final sorted list
			if (stack.isEmpty()) {
				setSortedList(merged);
			} else {
				// Otherwise, push the merged sublist back onto the stack
				stack.push(merged);
			}
		}
	}

	private List<List<E>> createSublists() {
		List<List<E>> sublists = new ArrayList<>();
		int start = 0;
		while (start < input.size()) {
			int end = Math.min(start + MIN_MERGE, input.size());
			List<E> sublist = input.subList(start, end);
			sublists.add(sublist);
			start = end;
		}
		return sublists;
	}

	private void insertionSort(List<E> sublist) {
		for (int i = 1; i < sublist.size(); i++) {
			E key = sublist.get(i);
			int j = i - 1;
			while (j >= 0 && sublist.get(j).compareTo(key) > 0) {
				sublist.set(j + 1, sublist.get(j));
				j--;
			}
			sublist.set(j + 1, key);
		}
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
		return result;
	}

	public List<E> getSortedList() {
		return sortedList;
	}

	public void setSortedList(List<E> sortedList) {
		this.sortedList = sortedList;
	}
}
