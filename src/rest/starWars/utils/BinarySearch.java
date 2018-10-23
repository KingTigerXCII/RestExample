package rest.starWars.utils;

import java.util.ArrayList;

import rest.starWars.models.Jedi;

public class BinarySearch {
	public static int binarySearch(ArrayList<Jedi> searchableItems, int searchValue) {
		int start = 0;
		int end = searchableItems.size() - 1;
		int middle = start + (end - start) / 2;
		
		while(start <= end) {
			if(searchableItems.get(middle).getId() == searchValue) {
				return middle;
			} else if(searchValue < searchableItems.get(middle).getId()) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
			middle = start + (end - start) / 2;
		}
		
		if(start <= end) {
			return middle;
		} else {
			return -1;
		}
		
	}
	
	public static int binarySearchOnIdsRec(ArrayList<Jedi> searchableItems, int searchValue, int start, int end) {
		int middle = start + (end - start) / 2;
		
		if(start > end) {
			return -1;
		} else if(searchableItems.get(middle).getId() == searchValue) {
			return middle;
		} else if(searchableItems.get(middle).getId() > searchValue) {
			return binarySearchOnIdsRec(searchableItems, searchValue, middle + 1, end);
		} else {
			return binarySearchOnIdsRec(searchableItems, searchValue, start, middle - 1);			
		}
	}
}
