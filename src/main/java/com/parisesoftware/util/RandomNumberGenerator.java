package com.parisesoftware.util;

import java.util.ArrayList;
import java.util.List;

/*
 * @author	Andrew Parise
 * @since	4/24/16
 * @version	5/30/18
 *
 * Generates Lists of random numbers
 */
public class RandomNumberGenerator implements IRandomNumberGenerator {

	private List<Integer> numberList;

	/**
	 * Default Constructor
	 */
	public RandomNumberGenerator(){
		//default constructor, provide the size of the array to be constructed/generated
		numberList = new ArrayList<>();
	}

	/**
	 * @param listLength
	 * @return
	 */
	public List<Integer> getNumberList(int listLength){
		populateNumList(listLength);
		return numberList;
	}

	/**
	 * @param howMany
	 */
	private void populateNumList(int howMany){
		//populates the number list with [listSize] number of elements
		for(int i = 0; i < howMany; i++){
			this.numberList.set(i, fetchRandNum());
		}
	}

	/**
	 * @return
	 */
	private int fetchRandNum(){
		//generates and then returns a random number of [numDigits] digits
		return (int)(Math.random()*Math.pow(10, (7)));
	}

}
