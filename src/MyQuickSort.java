/*
 * Andrew Parise
 * 4/28/16
 * Assignment 10.1
 * MyQuickSortTest.java
 * 
 * Class Overview:
 * 	My implementation of the Quick Sort algorithm
 * 
 */
public class MyQuickSort {
	//init
	private int[] _preSort; 
	private int[] _postSort;
	private int[] _tempArr; //this array is used during the sorting algorithm, before running, should be the same as _presort, after calling sort() it is the same as _postSort
	private boolean _hasSorted;
	public static boolean _DEBUG = true;
	//used for calculating the efficiency
	private boolean _performAnalytics;
	private int numStatements;
	private int numConditionals;
	private int numLoops;
	private int numNestedLoops;
	private int numHelperOofNCalls;
	
	public MyQuickSort(int[] preSortList, boolean performAnalytics){
		//default constructor, input is a list to be sorted
		_preSort = preSortList;
		_tempArr = preSortList;
		_postSort = new int[preSortList.length]; //creates a new array of the same length as the preSorted array
		_hasSorted = false;
		if(performAnalytics){
			//Used to track data for analytics performed
			_performAnalytics = true;
			numStatements = 0;
			numConditionals = 0;
			numLoops = 0;
			numNestedLoops = 0;
			numHelperOofNCalls = 0;
		}
	}
	

	
	public int[] getAnalyticData(){
		//returns a list of the data collected in performing the bubble sort algorithm
		//format is [numStatements, numConditionals, numLoops, numNestedLoops]
		if(_performAnalytics && (_hasSorted)){
			int[] data = new int[5];
			data[0] = numStatements;
			data[1] = numConditionals;
			data[2] = numLoops;
			data[3] = numNestedLoops;
			data[4] = numHelperOofNCalls;
			return data;
		}
		return null;
	}
	public int[] getSortedArr(){
		//returns the sorted array
		if(_hasSorted){
			return _postSort;
		}
		return _postSort;
	}
	public int[] getPreSortedArr(){
		//returns the array before it is sorted, used to ensure continuity in calculations during testing
		return _preSort;
	}
	public void sort(){
		//Determines which version of bubble sort to call
		if(_tempArr == null || _tempArr.length == 0 ){
			//error checking to illeviate worrying about null reference ex later
			return;
		}
		else {
			if(_performAnalytics){
				qsortAnalytics(0, (_tempArr.length - 1));
			}
			else{
				qsortRegular(0, (_tempArr.length - 1));
			}
		}
		
	}
	private void qsortRegular(int low, int high){
		//The quick sort algorithm, this version does not run efficiency analytics
		int tempLow = low;
		int tempHigh = high;
		int pivotPoint = _tempArr[low + ((high - low)/ 2)]; //find the middle point of the array, this is the pivot point
		//System.out.println("TEST: pivot point = " + pivotPoint);

		while(tempLow <= tempHigh){
			//Iterates over the array, keeping track of relative min's and max's in each division
			while(_tempArr[tempLow] < pivotPoint){ 
				tempLow++;
			}
			while(_tempArr[tempHigh] > pivotPoint){
				tempHigh--;
			}	
		
		
		if(tempLow <= tempHigh){
			//if the rightmost index >= the leftmost index
			swap(tempLow, tempHigh);
			tempLow++;
			tempHigh--;
		}
		}
		//System.out.println("TEST: qsortRegular() about to recursively call");

		//the recursive call
		if(low < tempHigh){
			qsortRegular(low, tempHigh);
		}
		if(tempLow < high){
			qsortRegular(tempLow, high);
		}
		_hasSorted = true;
		_postSort = _tempArr;
	}
	private void qsortAnalytics(int low, int high){
		//the quick sort algorithm, this verison does perform efficiency analytics
		int tempLow = low;
		numStatements++;
		int tempHigh = high;
		numStatements++;
		int pivotPoint = _tempArr[low + (int)((high - low)/ 2)]; //find the middle point of the array, this is the pivot point
		numStatements++;
		
		while(tempLow <= tempHigh){
			numLoops++;
			//Iterates over the array, keeping track of relative min's and max's in each division
			while(_tempArr[tempLow] < pivotPoint){
				numNestedLoops++;
				tempLow++;
				numStatements++;
			}
			while(_tempArr[tempHigh] > pivotPoint){
				numNestedLoops++;
				tempHigh--;
				numStatements++;
			}	
		
		
		if(tempLow <= tempHigh){
			numConditionals++;
			//if the rightmost index >= the leftmost index
			swap(tempLow, tempHigh);
			tempLow++;
			tempHigh--;
		}
		}
		//the recursive call
		if(low < tempHigh){
			numConditionals++;
			qsortRegular(low, tempHigh);
			numStatements++;

		}
		if(tempLow < high){
			numConditionals++;
			qsortRegular(tempLow, high);
			numStatements++;

		}
		_hasSorted = true;
		_postSort = _tempArr;

	}
	private void swap(int index1, int index2){
		//switches two elements in the presorted list
		if(_performAnalytics){
			numHelperOofNCalls++;
		}
		int tempVar = _tempArr[index1];
		_tempArr[index1] = _tempArr[index2];
		_tempArr[index2] = tempVar;
	}
}
