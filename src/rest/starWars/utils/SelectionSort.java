package rest.starWars.utils;

public class SelectionSort {
	public static int[] executeSelectionSort(int[] numbers) {
		for(int i = 0; i < numbers.length - 1; i++) {
			int minIndex = findMin(numbers, i);
			swap(numbers, i, minIndex);
		}			
		return numbers;
	}
	
	private static int findMin(int[] numbers, int startIndex) {
		int currentMinIndex = startIndex;
		for(int i = startIndex; i < numbers.length - 1; i++) {
			if(numbers[currentMinIndex] > numbers[i]) {
				currentMinIndex = i;
			}
		}	
		return currentMinIndex;
	}
	
	private static int[] swap(int[] numbers, int firstIndex, int secondIndex) {
		int tmp = numbers[firstIndex];
		numbers[firstIndex] = numbers[secondIndex];
		numbers[secondIndex] = tmp;		
		return numbers;
	}
}
