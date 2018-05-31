package com.parisesoftware.algorithm;

import java.util.ArrayList;
import java.util.List;

public class QuickSortImplTest {

	private static void printArr(List<Integer> arr){
        for (Integer anArr : arr) {
            System.out.println(anArr);
        }
	}

	public static void main(String[] args) {
		List<Integer> testData = new ArrayList<>();//{1,3,2,532,6,744};
        testData.add(1);
        testData.add(3);
        testData.add(2);
        testData.add(532);
        testData.add(6);
        testData.add(744);

		QuickSortImpl qs = new QuickSortImpl(testData, true);
		qs.sort();
		printArr(qs.getSortedArr());



	}

}
