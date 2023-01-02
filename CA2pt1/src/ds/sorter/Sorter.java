/**
 * I declare that the work contained in this assignment is my own, except where acknowledgement of sources is made.
 * I authorise the University to test any work submitted by me, using comparison software, for instances of plagiarism. I understand this will involve the University or its contractor copying my work and storing it on a database to be used in future to test work submitted by others.
 * I understand that I can obtain further information on this matter at
 * https://lo.unisa.edu.au/mod/book/view.php?id=252142

 * @author Steven Davidson davsy036
 *
 */
package ds.sorter;

import java.util.Comparator;
import java.util.List;

public interface Sorter<E extends Comparable<E>> {
	public List<E> sort(List<E> input);

	default List<E> sortType(List<E> input, Comparator<E> comparator) {
		input.sort(comparator);
		return sort(input);
	}

	default List<E> sortWeight(List<E> input, Comparator<E> comparator) {
		input.sort(comparator);
		return sort(input);
	}

	default List<E> sortRipeness(List<E> input, Comparator<E> comparator) {
		input.sort(comparator);
		return sort(input);
	}

}
