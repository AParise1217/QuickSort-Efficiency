package com.parisesoftware.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *	@author 	Andrew Parise
 * 	@since		4/28/16
 * 	@version	5/30/18
 *
 * 	Implementation of the Quick Sort algorithm
 */
public class QuickSortImpl {

	private List<Integer> preSortList;
	private List<Integer> postSortList;
	private List<Integer> tempList; //this array is used during the sorting algorithm, before running, should be the same as _presort, after calling sort() it is the same as postSortList
	private boolean hasSorted;

	//used for calculating the efficiency
	private boolean performAnalytics;
	private int numStatements;
	private int numConditionals;
	private int numLoops;
	private int numNestedLoops;
	private int numHelperOofNCalls;

    /**
     * Default Constructor
     * @param preSortList
     * @param performAnalytics
     */
	public QuickSortImpl(List<Integer> preSortList, boolean performAnalytics){
		//default constructor, input is a list to be sorted
		this.preSortList = preSortList;
		tempList = preSortList;
		postSortList = new ArrayList<>();
		hasSorted = false;

		if(performAnalytics){
			//Used to track data for analytics performed
			this.performAnalytics = true;
			numStatements = 0;
			numConditionals = 0;
			numLoops = 0;
			numNestedLoops = 0;
			numHelperOofNCalls = 0;
		}
	}

    /**
     * A list of the data collected in performing the bubble sort algorithm
     * @return List of Analytics Data
     * format is [numStatements, numConditionals, numLoops, numNestedLoops]
     */
	public List<Integer> getAnalyticData(){
		if(performAnalytics && (hasSorted)){
            List<Integer> data = new ArrayList<>();
			data.set(0, numStatements);
			data.set(1, numConditionals);
			data.set(2, numLoops);
			data.set(3, numNestedLoops);
			data.set(4, numHelperOofNCalls);
			return data;
		}
		return null;
	}

    /**
     * @return the sorted array
     */
	public List<Integer> getSortedArr(){
		if(hasSorted){
			return postSortList;
		}
		return postSortList;
	}

    /**
     * @return the array before it is sorted, used to ensure continuity in calculations during testing
     */
	public List<Integer> getPreSortedArr(){
		return preSortList;
	}

    /**
     * Determines which version of bubble sort to call
     */
	public void sort(){
        if (tempList != null && tempList.size() != 0) {
            if(performAnalytics){
                qsortAnalytics((tempList.size() - 1));
            }
            else{
                qsortRegular(0, (tempList.size() - 1));
            }
        }
    }

    /**
     * The quick sort algorithm, this version does not run efficiency analytics
     * @param low
     * @param high
     */
	private void qsortRegular(int low, int high){
		int tempLow = low;
		int tempHigh = high;
		int pivotPoint = tempList.get(low + ((high - low) / 2)); //find the middle point of the array, this is the pivot point

		while(tempLow <= tempHigh){
			//Iterates over the array, keeping track of relative min's and max's in each division
			while(tempList.get(tempLow) < pivotPoint){
				tempLow++;
			}
			while(tempList.get(tempHigh) > pivotPoint){
				tempHigh--;
			}

			if(tempLow <= tempHigh){
				//if the rightmost index >= the leftmost index
				swap(tempLow, tempHigh);
				tempLow++;
				tempHigh--;
			}
		}

		//the recursive call
		if(low < tempHigh){
			qsortRegular(low, tempHigh);
		}
		if(tempLow < high){
			qsortRegular(tempLow, high);
		}
		hasSorted = true;
		postSortList = tempList;
	}

    /**
     * the quick sort algorithm, this version does perform efficiency analytics
     * @param high
     */
	private void qsortAnalytics(int high){
		//
		int tempLow = 0;
		numStatements++;
		int tempHigh = high;
		numStatements++;
		int pivotPoint = tempList.get(high / 2); //find the middle point of the array, this is the pivot point
		numStatements++;

		while(tempLow <= tempHigh){
			numLoops++;
			//Iterates over the array, keeping track of relative min's and max's in each division
			while(tempList.get(tempLow) < pivotPoint){
				numNestedLoops++;
				tempLow++;
				numStatements++;
			}
			while(tempList.get(tempHigh) > pivotPoint){
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
		if(0 < tempHigh){
			numConditionals++;
			qsortRegular(0, tempHigh);
			numStatements++;

		}
		if(tempLow < high){
			numConditionals++;
			qsortRegular(tempLow, high);
			numStatements++;

		}
		hasSorted = true;
		postSortList = tempList;

	}

    /**
     * Switches two elements in the presorted list
     * @param index1
     * @param index2
     */
	private void swap(int index1, int index2){
		if(performAnalytics){
			numHelperOofNCalls++;
		}
		int tempVar = tempList.get(index1);
		tempList.set(index1, tempList.get(index2));
		tempList.set(index2, tempVar);
	}
}
