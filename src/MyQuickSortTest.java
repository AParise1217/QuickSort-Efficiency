/*
 * Andrew Parise
 * 4/28/16
 * Assignment 10.1
 * MyQuickSortTest.java
 * 
 * Class Overview:
 *  Test class to test the functionality of MyQuickSort.java before it is further used
 *  
 */
public class MyQuickSortTest {

	public static void printArr(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testData = {1,3,2,532,6,744};
		
		MyQuickSort qs = new MyQuickSort(testData, true);
		qs.sort();
		printArr(qs.getSortedArr());
		
		
		
	}

}
