package com.eddie.test3;

import java.util.*;

public class SortedMan {
	
	
	public static Double[][] sortedData(Double[][] data){
		ArrayList<Double[]> sortedBox = new ArrayList<Double[]>();
		sortedBox.add(data[0]);
		Double[] min = data[0];
		int rows = data.length;
		int cols = min.length;
		for(int i = 1; i < rows; i++){
			int first 	= 0;
			int second 	= 0;
			for(int j = 1; j < cols; j++){
				if(min[j] < data[i][j]) first++;
				else if(min[j] > data[i][j]) second++;
			}
			if(first == second) sortedBox.add(data[i]);
			else if(first < second) {
				sortedBox.removeAll(sortedBox);
				sortedBox.add(data[i]);
				min = data[i];
			}
		}
		rows = sortedBox.size();
		Double[][] dataSort = new Double[rows][cols];
		for (int i = 0; i < rows; i++) {
			Double[] element = sortedBox.get(i);
			for(int j = 0; j < cols; j++){
				dataSort[i][j] = element[j];
			}
		}
		
		return dataSort;
	}
	
	public static void main(String[] args) {
		System.out.println("FirstTesting");
		System.out.println("Input data :");
		Double[][] x = new Double[][]{
			{1.0, 1.0,     0.1, 0.3333, 0.1667, 0.8571, 0.4444},
			{2.0, 0.2857,  0.3, 0.6667, 0.0,    0.8571, 0.8889},
			{3.0, 0.7143,  0.7, 0.0,    0.5,    0.5714, 0.2222},
			{4.0, 0.5714,  1.0, 0.5,    0.6667, 0.8571, 1.0   },
			{5.0, 0.2857,  0.1, 0.5,    0.0,    0.0,    0.0667}
		};
		print(x);
		System.out.println("Output data :");
		print(sortedData(x));
		System.out.println("\n\n\n");
		
		System.out.println("Second Testing");
		System.out.println("Input data :");
		Double[][] x2 = new Double[][]{
			{1.0, 1.0,     0.1, 0.3333, 0.1667, 0.8571, 0.4444},
			{2.0, 0.2857,  0.3, 0.6667, 0.0,    0.8571, 0.8889},
			{3.0, 0.7143,  0.7, 0.0,    0.5,    0.5714, 0.2222},
			{4.0, 0.5714,  1.0, 0.5,    0.6667, 0.8571, 1.0   },
			{5.0, 0.2857,  0.1, 0.5,    0.0,    0.0,    0.0667}
		};
		print(x2);
		System.out.println("Output data :");
		print(sortedData(x2));
		
		
		
	}
	
	public static void print(Double[][] data){
		for(Double[] s : data)
			System.out.println(Arrays.toString(s));
	}

}
