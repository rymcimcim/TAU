package lab01.zad4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Implementacja implements IPsikus {
	
	public Implementacja(){}

	@Override
	public Integer cyfrokrad(Integer liczba) {
		Integer result;
		int liczbaDigits = String.valueOf(liczba).length();
		
		String liczbaString = Integer.toString(liczba);
		Integer[] newLiczba = new Integer[liczbaString.length()];
		for (int i = 0; i < liczbaString.length(); i++) {
		    newLiczba[i] = liczbaString.charAt(i) - '0';
		}
		
		if (liczbaDigits == 1) {
			result = null;
		} else {
			Random generator = new Random();
			int newLiczbaRandomIndex = generator.nextInt(liczbaDigits);
			StringBuilder strBuilder = new StringBuilder();
			for(int i = 0; i < newLiczba.length; i++){
				if(i != newLiczbaRandomIndex){
					strBuilder.append(newLiczba[i].toString());
				}
			}
			result = Integer.parseInt(strBuilder.toString());
		}
		return result;
	}
	
	public int getDiffIndex(int pierwszyIndex, int size, Random generator){
//		System.out.println(size);
		int result = generator.nextInt(size);
		if (result == pierwszyIndex){
			return getDiffIndex(pierwszyIndex, size, generator);
		} else {
			return result;
		}
	}

	@Override
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
//		System.out.println(liczba);
		if (Integer.toString(liczba).length() == 1){
			throw new NieudanyPsikusException();
		} else {
			String liczbaString = Integer.toString(liczba);
			List<Integer> liczbaArray = new ArrayList<Integer>();
			for (int i = 0; i < liczbaString.length(); i++){
				liczbaArray.add(Character.getNumericValue(liczbaString.charAt(i)));
			}
			
			Random generator = new Random();
			int pierwszyIndex = generator.nextInt(liczbaArray.size());
			int drugiIndex = getDiffIndex(pierwszyIndex, liczbaArray.size(), generator);
			
			Collections.swap(liczbaArray, pierwszyIndex, drugiIndex);
			StringBuilder strBuilder = new StringBuilder();
			for(int i = 0; i < liczbaArray.size(); i++){
				strBuilder.append(liczbaArray.get(i).toString());
			}
//			System.out.println(Integer.parseInt(strBuilder.toString()));
			return Integer.parseInt(strBuilder.toString());
			
		}
	}

	@Override
	public Integer nieksztaltek(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

}
