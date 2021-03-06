package app;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import messenger.MessageService;
import messenger.ConnectionStatus;
import messenger.MalformedRecipientException;
import messenger.SendingStatus;

public class EasyMockTest extends EasyMockSupport {

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	private final Exception ex = new MalformedRecipientException();
	
	@Rule
    public EasyMockRule rule = new EasyMockRule(this);
	
	@Mock
    private MessageService mock;
	
	@TestSubject
    private MessengerEasyMock classUnderTest = new MessengerEasyMock();
	
	@Test
    public void checkConnectionInValid() {
        expect(mock.checkConnection(INVALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
        
        replayAll();
        
        assertEquals(1, classUnderTest.testConnection(INVALID_SERVER));
        
        verifyAll();
    }
	
	@Test
    public void checkConnectionValid() {
        expect(mock.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS);
        
        replayAll();
        
        assertEquals(0, classUnderTest.testConnection(VALID_SERVER));
        
        verifyAll();
    }
	
	@Test
    public void invalidServerValidMessage() throws MalformedRecipientException {
        expect(mock.send(INVALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR);
        

        replayAll();
        
        assertEquals(1, classUnderTest.sendMessage(INVALID_SERVER, VALID_MESSAGE));

        verifyAll();
    }
	
	@Test
    public void invalidServerInvalidMessage() throws MalformedRecipientException {
		expect(mock.send(INVALID_SERVER, INVALID_MESSAGE)).andThrow(ex);
        
        replayAll();
        
        assertEquals(2, classUnderTest.sendMessage(INVALID_SERVER, INVALID_MESSAGE));

        verifyAll();
    }
	
	@Test
    public void validServerInvalidMessage() throws MalformedRecipientException {
		expect(mock.send(VALID_SERVER, INVALID_MESSAGE)).andThrow(ex);
        
        replayAll();
        
        assertEquals(2, classUnderTest.sendMessage(VALID_SERVER, INVALID_MESSAGE));

        verifyAll();
    }
	
	@Test
    public void validServerValidMessage() throws MalformedRecipientException {
		expect(mock.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENT);
        
        replayAll();
        
        assertEquals(0, classUnderTest.sendMessage(VALID_SERVER, VALID_MESSAGE));

        verifyAll();
    }
	
	
}
