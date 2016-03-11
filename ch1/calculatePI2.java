package ch1;

import java.util.Scanner;

public class calculatePI2 {
	public static void main(String[] args) {
		double pi = 0;
		double i=1;
		while(true){
			if(i%2==0)
				pi+=4*(-1/(2*i-1));
			else {
				pi+=4*(1/(2*i-1));
			}
			if(pi>=3.14159&&pi<3.14160)
				break;
			i++;
		}
		int num = (int) i;
		System.out.println(num);
	}
}











