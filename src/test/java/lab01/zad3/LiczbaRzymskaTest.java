package lab01.zad3;

import static org.junit.Assert.*;

import org.junit.Test;

public class LiczbaRzymskaTest {
	public LiczbaRzymskaTest(){}
	
	@Test
	public void paramIsNotZero(){
		LiczbaRzymska liczba = new LiczbaRzymska(1);
		assertTrue("Null!", liczba.getLiczba() > 0);
	}
	
	@Test
	public void testToString(){
		LiczbaRzymska liczba = new LiczbaRzymska(3);
		assertTrue("Not true!", liczba.toString().equals("III"));
	}
}
