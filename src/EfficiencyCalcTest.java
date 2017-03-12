/*
 * Andrew Parise
 * 4/28/16
 * Assignment 10.1
 * EfficiencyCalcTest.java
 * 
 * Class Overview:
 * 	Solves the problem defined in the assignment overview
 * 
 */
public class EfficiencyCalcTest {

	public static void printAnalyticData(int[] analyticData){
		System.out.println("Number of Statements: " + analyticData[0]);
		System.out.println("Number of Conditionals: " + analyticData[1]);
		System.out.println("Number of Loops: " + analyticData[2]);
		System.out.println("Number of Nested Loops: " + analyticData[3]);
		System.out.println("Number of Nested O(n) Calls: " + analyticData[4]);
		if(analyticData[4] > 0){
			//When there is a nested O(n) method call, it becomes O(n * log(n)) efficiency
			System.out.println("Efficiency of this execution: O(n * log(n))");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EfficiencyCalc generateArr = new EfficiencyCalc(5000);
		int[] numList = generateArr.getNumList();
		MyQuickSort qs = new MyQuickSort(numList, true);
		qs.sort();
		int[] analyticData = qs.getAnalyticData();
		printAnalyticData(analyticData);
	}

}
