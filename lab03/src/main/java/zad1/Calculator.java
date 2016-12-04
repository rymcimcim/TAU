package zad1;

public class Calculator {
	
	private int a;
	private int b;
	
	public int getLeft() {
		return a;
	}

	public void setLeft(int a) {
		this.a = a;
	}

	public int getRight() {
		return b;
	}

	public void setRight(int b) {
		this.b = b;
	}

	
	public int add(){
		return a + b;
	}
	
	public int sub(){
		return a - b;
	}
	
	public int multi(){
		return a * b;
	}
	
	public int div(){
		try {
			return a / b;
		}
		catch (ArithmeticException e) {
			return 0;
		}
	}

	public boolean greater(){
		if (a > b)
			return true;
		else
			return false;
	}
	
}