package ch1;

import java.util.Scanner;

import javax.swing.text.AsyncBoxView.ChildLocator;

import java.awt.color.*;

import java.lang.Math;
import java.math.BigDecimal;

public class Test1 {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		double val = input.nextDouble();
		double pi = calculatePi(val);
		System.out.println(pi);
	}
	
	static double calculatePi(double val){
		double pi=0;
		for(double i=1; i<=val; i++){
			if(i%2==0)
				pi+=-1/(2*i-1);
			else {
				pi += 1/(2*i-1);
			}
		}
		pi = 4*pi;
		return pi;
	}
	
	
}
