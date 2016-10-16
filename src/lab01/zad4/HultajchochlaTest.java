package lab01.zad4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HultajchochlaTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	private Integer input;
    private Integer expected;

	Implementacja imp = new Implementacja();
	
	public HultajchochlaTest(Integer input, Integer expected) {
        this.input= input;
        this.expected= expected;
    }
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 1, null }, { 2, null }, { 55, 5 }, { 999, 99 }, { 2222, 222 }, { 2324, 224 }, { 1029384756, 187654329 }
           });
    }
	
	@Test
	public void checkHultajchochla() throws NieudanyPsikusException{
		String inputString = Integer.toString(getInput());
		
		if (inputString.length() == 1) {
			exception.expect(NieudanyPsikusException.class);
			imp.hultajchochla(getInput());
		}
		
		Integer[] inputArray = new Integer[inputString.length()];
		String resultString = Integer.toString(imp.hultajchochla(getInput()));
		Integer[] resultArray = new Integer[resultString.length()];
		for (int i = 0; i < inputArray.length; i++){
			inputArray[i] = Character.getNumericValue(inputString.charAt(i));
			resultArray[i] = Character.getNumericValue(resultString.charAt(i));
		}
		
		if (inputString.length() == 2){
			Integer pierwszaLiczba = inputArray[0];
			Integer drugaLiczba = inputArray[1];
			Integer pierwszaZmienionaLiczba = resultArray[1];
			Integer drugaZmienionaLiczba = resultArray[0];
			
			assertEquals(pierwszaZmienionaLiczba, pierwszaLiczba);
			assertEquals(drugaZmienionaLiczba, drugaLiczba);
		} else {
			List<Integer> indexArray = new ArrayList<Integer>(2);
			int index = 0;
			for (int i = 0; i < inputArray.length; i++){
				if (inputArray[i] != resultArray[i]){
					indexArray.add(i);
					index++;
				}
			}

			if (index == 0){
				indexArray.add(0);
				indexArray.add(1);
			}
			
			Integer pierwszaLiczba = inputArray[indexArray.get(0)];
			Integer drugaLiczba = inputArray[indexArray.get(1)];
			Integer drugaZmienionaLiczba = resultArray[indexArray.get(0)];
			Integer pierwszaZmienionaLiczba = resultArray[indexArray.get(1)];
//			
			assertEquals(drugaZmienionaLiczba, drugaLiczba);
			assertEquals(pierwszaZmienionaLiczba, pierwszaLiczba);
		}
	}

	public Integer getInput() {
		return input;
	}

	public Integer getExpected() {
		return expected;
	}
}
