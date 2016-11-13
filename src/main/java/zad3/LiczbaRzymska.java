package lab01.zad3;

import java.util.TreeMap;

public class LiczbaRzymska {
	
	private int liczba;
	
	public LiczbaRzymska(int liczba){
		this.liczba = liczba;
	}
	
	public String toString(){
		final TreeMap<Integer, String> map = new TreeMap<Integer, String>();

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

	    int l = map.floorKey(this.getLiczba());
	    if (this.getLiczba() == l) {
	    	return map.get(this.getLiczba());
	    } else {
	    	this.setLiczba(this.getLiczba() - 1);
	    	return map.get(l) + toString();
	    }
	}

	public int getLiczba() {
		return liczba;
	}

	public void setLiczba(int liczba) {
		this.liczba = liczba;
	}
}
