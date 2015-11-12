package yes;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Main {

	static int number;
	static int num;
	static int sum;
	
	public static int recursive(int x){
	
		
		//System.out.println(x);
		
		
		if(x==0||x==1)
		return 1;
			
				
		sum = x* recursive(x-1);
		System.out.println(sum);
		return sum;
}
	
	
	public static void main(String args []){

		num=4;
		number = 7;

		//System.out.println(number);
		//System.out.println(num);
				
		//recursive(number);
		
		System.out.printf("this is the number %d and this is num %d",recursive(number),num);
}
}
	


