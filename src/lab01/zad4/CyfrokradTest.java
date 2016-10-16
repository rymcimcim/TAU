package lab01.zad4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CyfrokradTest {
	private Integer input;
    private Integer expected;

    public CyfrokradTest(Integer input, Integer expected) {
        this.input= input;
        this.expected= expected;
    }
	
	Implementacja imp = new Implementacja();
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 1, null }, { 2, null }, { 55, 5 }, { 999, 99 }, { 2222, 222 }, { 2324, 224 }
           });
    }
	
//	@Test
//	public void checkNullOrSame(){
//		assertEquals(getExpected(), imp.cyfrokrad(getInput()));
//	}
	
	@Test
	public void checkCyfrokrad(){
		
		String inputString = Integer.toString(getInput());
		Integer input = imp.cyfrokrad(getInput());
		
		if (inputString.length() == 1) {
			assertTrue(getExpected() == input);
		} else {
			Integer[] inputStringArray = new Integer[inputString.length()];
			for (int i = 0; i < inputStringArray.length; i++){
				inputStringArray[i] = Character.getNumericValue(inputString.charAt(i));
			}
			
			
			String resultString = Integer.toString(input);
			Integer[] resultArray = new Integer[resultString.length()];
			for (int i = 0; i < resultArray.length; i++){
				resultArray[i] = Character.getNumericValue(resultString.charAt(i));
			}
			
			int contains = 0;
			for (int i = 0; i < resultArray.length; i++) {
				if (Arrays.asList(inputStringArray).contains(resultArray[i])){
					contains += 1;
				}
			}
			assertTrue(contains == resultArray.length);
		}
	}

	public Integer getInput() {
		return input;
	}

	public Integer getExpected() {
		return expected;
	}
}
