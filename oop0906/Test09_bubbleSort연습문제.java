package oop0906;

import java.awt.event.ItemEvent;

public class Test09_bubbleSort연습문제 {

	public static void bubbleSort(int[]array) {
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<array.length-i-1; j++) {
				swap(array, j, j+1);
			}
		}		
	}


	public static void swap(int[] array, int source, int target) {
		int temp = array[source];
		array[source] = array[target];
		array[target] = temp;
	}
	
	public static void printArray(int[] array) {
		for(int data : array) {
			System.out.print(data+ " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] item = new int[] {9,8,7,6,5};
		System.out.println("정렬 전");
		printArray(item);
		bubbleSort(item);
		System.out.println("정렬 후");
		printArray(item);
 	}
}
	
	
	
	
	
	
	