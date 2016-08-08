package sorting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for SortingMethods.java
 * @author Tony Song
 *
 */

public class TestSortingMethods {
	Integer[] emptyArr;
	Integer[] oneArr;
	Integer[] sevenArr;
	Integer[] randomTen;
	Integer[] randomHundred;
	Integer[] randomThousand;
	
	Integer[] sevenArrSorted;
	Integer[] randomTenSorted;
	Integer[] randomHundredSorted;
	Integer[] randomThousandSorted;
	
	/**
	 * Make an array of random Integers with the given size.
	 * @param size
	 * @return an array of Integers
	 */
	private static Integer[] randomArr(int size) {
		Random rand = new Random();
		Integer[] arr = new Integer[size];
		for (int i = 0; i < size; i++) {
			arr[i] = rand.nextInt(100);
		}
		return arr;
	}
	
	@Before
	public void setup() {
		emptyArr = new Integer[0];
		oneArr = new Integer[1];
		oneArr[0] = 10;
		Integer[] temp = {3, 2, 5, 4, 1, 7, 6};
		sevenArr = temp;
		randomTen = randomArr(10);
		randomHundred = randomArr(100);
		randomThousand = randomArr(1000);
		
		Integer[] tempSort = {1, 2, 3, 4, 5, 6, 7};
		sevenArrSorted = tempSort;
		randomTenSorted = Arrays.copyOf(randomTen, 10);
		Arrays.sort(randomTenSorted);
		randomHundredSorted = Arrays.copyOf(randomHundred, 100);
		Arrays.sort(randomHundredSorted);
		randomThousandSorted = Arrays.copyOf(randomThousand, 1000);
		Arrays.sort(randomThousandSorted);
	}
	
	@Test
	public void selectionSortTest() {
		Integer[] ans = {10};
		
		SortingMethods.selectionSort(emptyArr);
		SortingMethods.selectionSort(oneArr);
		SortingMethods.selectionSort(sevenArr);
		
		assertArrayEquals(new Integer[0], emptyArr);
		assertArrayEquals(ans, oneArr);
		assertArrayEquals(sevenArrSorted, sevenArr);
	}
	
	@Test
	public void selectionSortRandomTest() {
		SortingMethods.selectionSort(randomTen);
		SortingMethods.selectionSort(randomHundred);
		SortingMethods.selectionSort(randomThousand);
		
		assertArrayEquals(randomTenSorted, randomTen);
		assertArrayEquals(randomHundredSorted, randomHundred);
		assertArrayEquals(randomThousandSorted, randomThousand);
	}
	
	@Test
	public void bubbleSortTest() {
		Integer[] ans = {10};
		
		SortingMethods.bubbleSort(emptyArr);
		SortingMethods.bubbleSort(oneArr);
		SortingMethods.bubbleSort(sevenArr);
		
		assertArrayEquals(new Integer[0], emptyArr);
		assertArrayEquals(ans, oneArr);
		assertArrayEquals(sevenArrSorted, sevenArr);
	}
	
	@Test
	public void bubbleSortRandomTest() {
		SortingMethods.bubbleSort(randomTen);
		SortingMethods.bubbleSort(randomHundred);
		SortingMethods.bubbleSort(randomThousand);
		
		assertArrayEquals(randomTenSorted, randomTen);
		assertArrayEquals(randomHundredSorted, randomHundred);
		assertArrayEquals(randomThousandSorted, randomThousand);
	}
	
	@Test
	public void insertionSortTest() {
		Integer[] ans = {10};

		SortingMethods.insertionSort(emptyArr);
		SortingMethods.insertionSort(oneArr);
		SortingMethods.insertionSort(sevenArr);

		assertArrayEquals(new Integer[0], emptyArr);
		assertArrayEquals(ans, oneArr);
		assertArrayEquals(sevenArrSorted, sevenArr);
	}
	
	@Test
	public void insertionSortRandomTest() {
		SortingMethods.insertionSort(randomTen);
		SortingMethods.insertionSort(randomHundred);
		SortingMethods.insertionSort(randomThousand);
		
		assertArrayEquals(randomTenSorted, randomTen);
		assertArrayEquals(randomHundredSorted, randomHundred);
		assertArrayEquals(randomThousandSorted, randomThousand);
	}
}
