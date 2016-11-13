package zad2;



public class Calculator {
	public Calculator(){}
	
	double add(double a, double b){
		return a + b;
	}
	
	double sub(double a, double b){
		return a - b;
	}
	double multi(double a, double b){
		return a * b;
	}
	double div(double a, double b){
		double div;
		try{
			div = a / b;
		}
		catch(ArithmeticException e){
			div = 0;
		}
		return div;
	}
	boolean greater(double a, double b){
		return a > b;
	}
}
