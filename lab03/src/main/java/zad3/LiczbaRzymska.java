package zad3;

import java.util.TreeMap;

public class LiczbaRzymska {

	private int liczba;
	
	public void setNumber(int liczba) {
		this.liczba = liczba;
	}

	public int getNumber() {
		return liczba;
	}

	private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

	static {
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
	}

	public String convertToRoman(){
		if (liczba < 1 || liczba > 3999) {
			throw new IllegalArgumentException();
		}
		int chosenKey = map.floorKey(liczba);
		if (chosenKey == liczba) {
			return map.get(chosenKey);
		}
		liczba = liczba - chosenKey;
		return map.get(chosenKey) + convertToRoman();
	}
	
	public String toString() {
		return convertToRoman();
	}

}
