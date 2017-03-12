/*
 * Andrew Parise
 * 4/28/16
 * Assignment 10.1
 * EfficiencyCalc.java
 * 
 * Class Overview:
 * 	Generates the random numbers to populate the array to then be sorted via quick sort
 * 
 */
public class EfficiencyCalc {
	//init
	private int[] _numberList;
	public static boolean _DEBUG = true;
		
	public EfficiencyCalc(int listSize){
		//default constructor, provide the size of the array to be constructed/generated
		_numberList = new int[listSize];
		populateNumList(listSize);
	}
	private void populateNumList(int listSize){
		//populates the number list with [listSize] number of elements
		for(int i = 0; i < listSize; i++){
			_numberList[i] = fetchRandNum(7);
		}
	}
	private int fetchRandNum(int numDigits){
		//generates and then returns a random number of [numDigits] digits
		return (int)(Math.random()*Math.pow(10, (numDigits)));
	}
	public int[] getNumList(){
		return _numberList;
	}
		


}
