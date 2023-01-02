package ds.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ds.fruit.Fruit;
import ds.fruit.Fruit.TYPE;
import ds.fruit.InvalidFruitRipenessException;
import ds.fruit.InvalidFruitWeightException;

class FruitTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	// Test creating fruit with valid weight and ripeness
	@Test
	void test() throws InvalidFruitRipenessException, InvalidFruitWeightException {
		Fruit fruit = new Fruit(TYPE.APPLE, 1, 1);
		assertEquals(fruit.getType(), TYPE.APPLE);
		assertEquals(fruit.getWeight(), 1);
		assertEquals(fruit.getRipeness(), 1);
	}

	// Test creating fruit with invalid weight but valid ripeness
	@Test
	void testInvalidFruitWeightException() {
		assertThrows(InvalidFruitWeightException.class, () -> {
			Fruit fruit = new Fruit(TYPE.APPLE, -1, 1);
		});
	}

	// Test creating fruit with valid weight and ripeness
	@Test
	void testValidFruit() throws InvalidFruitRipenessException, InvalidFruitWeightException {
		Fruit fruit = new Fruit(TYPE.APPLE, 500, 0.75f);
		assertEquals(TYPE.APPLE, fruit.getType());
		assertEquals(500, fruit.getWeight());
		assertEquals(0.75f, fruit.getRipeness());
	}

	// Test creating fruit with negative weight
	@Test
	void testInvalidFruitWeightException1() {
		assertThrows(InvalidFruitWeightException.class, () -> {
			new Fruit(TYPE.APPLE, -1, 0.5f);
		});
	}

	// Test creating a fruit with ripeness above 100%
	@Test
	void testInvalidFruitRipenessException() {
		assertThrows(InvalidFruitRipenessException.class, () -> {
			new Fruit(TYPE.APPLE, 1, 1.1f);
		});
	}

	// Test creating a fruit with weight of 0
	@Test
	void testFruitWeightZero() throws InvalidFruitWeightException, InvalidFruitRipenessException {
		Fruit fruit = new Fruit(TYPE.APPLE, 0, 0.5f);
		assertEquals(TYPE.APPLE, fruit.getType());
		assertEquals(0, fruit.getWeight());
		assertEquals(0.5f, fruit.getRipeness());
	}

	// Test creating a fruit with ripeness of 0
	@Test
	void testFruitRipenessZero() throws InvalidFruitWeightException, InvalidFruitRipenessException {
		Fruit fruit = new Fruit(TYPE.APPLE, 1, 0f);
		assertEquals(TYPE.APPLE, fruit.getType());
		assertEquals(1, fruit.getWeight());
		assertEquals(0f, fruit.getRipeness());
	}

	// Test creating a fruit with maximum int value for weight:
	@Test
	void testFruitMaxWeight() throws InvalidFruitWeightException, InvalidFruitRipenessException {
		Fruit fruit = new Fruit(TYPE.APPLE, Integer.MAX_VALUE, 0.5f);
		assertEquals(TYPE.APPLE, fruit.getType());
		assertEquals(Integer.MAX_VALUE, fruit.getWeight());
		assertEquals(0.5f, fruit.getRipeness());
	}
}
