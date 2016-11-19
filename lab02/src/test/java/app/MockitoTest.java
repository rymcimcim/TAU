package app;

import static org.junit.Assert.*;

import org.junit.Before;
import static org.mockito.Mockito.*;
import org.junit.Test;

import messenger.MalformedRecipientException;
import app.Messenger;
import messenger.SendingStatus;
import messenger.MessageService;

public class MockitoTest {
	// SUT
	private Messenger Messenger;
	private MessageService mock;
		
	@Before
	public void setUp() {
	mock = mock(MessageService.class);
		Messenger = new Messenger(mock);
	}
			

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Test
	public void checkSendingMessage() throws MalformedRecipientException {

		when(mock.send(INVALID_SERVER, INVALID_MESSAGE)).thenReturn(SendingStatus.SENDING_ERROR);    
	    when(mock.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENT);
	    when(mock.send(INVALID_SERVER, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
	    when(mock.send(VALID_SERVER, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
	       
	    assertEquals(1,Messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE));
	    assertEquals(0,Messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	    assertEquals(2,Messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE));
	    assertEquals(2,Messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	    
		verify(mock);	
			
	}
}
