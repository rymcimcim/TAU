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
		int result = generator.nextInt(size);
		if (result == pierwszyIndex){
			result = getDiffIndex(pierwszyIndex, size, generator);
		}
		return result;
	}

	@Override
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
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
			return Integer.parseInt(strBuilder.toString());
			
		}
	}
	
	public Integer[] getInteger(Integer liczba, Integer[] liczbaArray){
    	List<Integer> indexArray = new ArrayList<Integer>();
    	for (int i = 0; i < liczbaArray.length; i++){
    		if (liczbaArray[i] == liczba){
    			indexArray.add(i);
    		}
    	}
    	
    	Random generator = new Random();
    	int randomArrayIndex = generator.nextInt(indexArray.size());
    	int numberToChange = liczbaArray[indexArray.get(randomArrayIndex)];
    	int changeNumber = 0;
    	
    	switch (numberToChange) {
		case 3:
			changeNumber = 8;
			break;
		case 7:
			changeNumber = 1;
			break;
		case 6:
			changeNumber = 9;
			break;
		default:
			break;
		}
    	
    	if (changeNumber != 0){
    		numberToChange = changeNumber;
    	}
    	
    	return liczbaArray;
    }

	@Override
	public Integer nieksztaltek(Integer liczba) {
		String liczbaString = Integer.toString(liczba);
		Integer[] liczbaArray = new Integer[liczbaString.length()];
		for (int i = 0; i < liczbaArray.length; i++){
			liczbaArray[i] = Character.getNumericValue(liczbaString.charAt(i));
		}
    	
    	Integer[] resultArray;
    	Random generator = new Random();
    	int randomIndex = generator.nextInt(5);
    	resultArray = liczbaArray;
    	if (randomIndex == 0){
	    	if (Arrays.asList(liczbaArray).contains(3)){
	    		resultArray = getInteger(3, liczbaArray);
	    	} else if (Arrays.asList(liczbaArray).contains(7)){
	    		resultArray = getInteger(7, liczbaArray);
	    	} else if (Arrays.asList(liczbaArray).contains(6)){
	    		resultArray = getInteger(6, liczbaArray);
	    	} 
    	} else if (randomIndex == 1){
	    	if (Arrays.asList(liczbaArray).contains(3)){
	    		resultArray = getInteger(3, liczbaArray);
	    	} else if (Arrays.asList(liczbaArray).contains(6)){
	    		resultArray = getInteger(6, liczbaArray);
	    	} else if (Arrays.asList(liczbaArray).contains(7)){
	    		resultArray = getInteger(7, liczbaArray);
	    	} 
    	} else if (randomIndex == 2){
	    	if (Arrays.asList(liczbaArray).contains(6)){
	    		resultArray = getInteger(6, liczbaArray);
	    	} else if (Arrays.asList(liczbaArray).contains(3)){
	    		resultArray = getInteger(3, liczbaArray);
	    	} else if (Arrays.asList(liczbaArray).contains(7)){
	    		resultArray = getInteger(7, liczbaArray);
	    	} 
    	} else if (randomIndex == 3){
	    	if (Arrays.asList(liczbaArray).contains(7)){
	    		resultArray = getInteger(7, liczbaArray);
	    	} else if (Arrays.asList(liczbaArray).contains(3)){
	    		resultArray = getInteger(3, liczbaArray);
	    	} else if (Arrays.asList(liczbaArray).contains(6)){
	    		resultArray = getInteger(6, liczbaArray);
	    	} 
    	} else if (randomIndex == 4){
	    	if (Arrays.asList(liczbaArray).contains(7)){
	    		resultArray = getInteger(7, liczbaArray);
	    	} else if (Arrays.asList(liczbaArray).contains(6)){
	    		resultArray = getInteger(6, liczbaArray);
	    	} else if (Arrays.asList(liczbaArray).contains(3)){
	    		resultArray = getInteger(3, liczbaArray);
	    	} 
    	} else if (randomIndex == 5){
	    	if (Arrays.asList(liczbaArray).contains(6)){
	    		resultArray = getInteger(6, liczbaArray);
	    	} else if (Arrays.asList(liczbaArray).contains(7)){
	    		resultArray = getInteger(7, liczbaArray);
	    	} else if (Arrays.asList(liczbaArray).contains(3)){
	    		resultArray = getInteger(3, liczbaArray);
	    	} 
    	}
    	
    	StringBuilder builder = new StringBuilder();
		for(int i = 0; i < resultArray.length; i++){
			builder.append(resultArray[i].toString());
		}
		return Integer.parseInt(builder.toString());
	}

}
