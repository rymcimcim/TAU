package lab01.zad4;

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

	@Override
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer nieksztaltek(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

}
