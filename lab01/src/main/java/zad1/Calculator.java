package zad1;


public class Calculator {
	public Calculator(){}
	
	int add(int a, int b){
		return a + b;
	}
	
	int sub(int a, int b){
		return a - b;
	}
	int multi(int a, int b){
		return a * b;
	}
	int div(int a, int b){
		int div;
		try{
			div = a / b;
		}
		catch(ArithmeticException e){
			div = 0;
		}
		return div;
	}
	boolean greater(int a, int b){
		return a > b;
	}
}
