package lab01.zad4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NieksztaltekTest {
	private Integer input;
    private Integer expected;
    
	public NieksztaltekTest(Integer input, Integer expected) {
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
    public void checkNieksztaltek(){
    	String inputString = Integer.toString(getInput());
    	Integer[] inputArray = new Integer[inputString.length()];
    	for (int i = 0; i < inputArray.length; i++){
    		inputArray[i] = Character.getNumericValue(inputString.charAt(i));
    	}
    	Implementacja imp = new Implementacja();
    	String resultString = Integer.toString(imp.nieksztaltek(getInput()));
    	Integer[] resultArray = new Integer[resultString.length()];
    	for (int i = 0; i < resultArray.length; i++){
    		resultArray[i] = Character.getNumericValue(resultString.charAt(i));
    	}
    	
    	for (int i = 0; i < inputArray.length; i++){
    		if (inputArray[i] != resultArray[i]){
    			switch (inputArray[i]){
    			case 3:
    				assertTrue(resultArray[i] == 8);
    				break;
    			case 7:
    				assertTrue(resultArray[i] == 1);
    				break;
    			case 6:
    				assertTrue(resultArray[i] == 9);
    			}
    		} else {
    			assertArrayEquals(resultArray, inputArray);
    		}
    	}
    }
	
	public Integer getInput() {
		return input;
	}
	public Integer getExpected() {
		return expected;
	}
}
