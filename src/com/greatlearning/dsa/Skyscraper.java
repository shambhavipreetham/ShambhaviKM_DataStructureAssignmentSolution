package com.greatlearning.dsa;

import java.util.*;

public class Skyscraper {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total number floors in the building : ");
		int n = sc.nextInt();
		int x[] = new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			System.out.println("Enter the floor size given on day "+i);
			int m = sc.nextInt();
			x[m] = i;
		}
		
		int j=n;
		boolean flag;
		System.out.println("\nThe order of construction is as follows :\n ");
		
		for(int i=1;i<=n;i++) {
			flag = false;
			System.out.println("\nDay "+i+" : ");
			
			while(j>=1 && x[j]<=i) {
				flag = true;
				System.out.println(j +" ");
				j--;
			}
			
			if(flag==true) {
				System.out.println();
			}
		}
		sc.close();
	}
}
