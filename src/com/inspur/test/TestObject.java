
package com.inspur.test;

public class TestObject {
	
	public static void main(String[] args) throws Exception{
		int[] arr  = new int[]{111,1,3,44,3,44,55,6,77};
		
		quickSort(arr, 0, arr.length-1);
		
		for(int number : arr){
			System.out.println(number);
		}
	}

	private static void quickSort(int[] arr, int left, int right) {
		if(left > right){
			return ;
		}
		
		int i,j,temp;
		i = left;
		j = right;
		temp = arr[left];
		
		while(i < j){
			
			while(arr[j] >= temp && i < j){
				j--;
			}
			while(arr[i] <= temp && i < j){
				i++;
			}
			
			if(i < j){
				int num = arr[i];
				arr[i] = arr[j];
				arr[j] = num;
			}
		}
		
		arr[left] = arr[i];
		arr[i] = temp;
		
		quickSort(arr, left, i-1);
		quickSort(arr, i+1, right);
	}
	
	
	

	
	
	
}
