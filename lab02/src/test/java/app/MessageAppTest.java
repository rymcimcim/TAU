package app;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import messenger.MessageServiceSimpleImpl;

public class MessageAppTest {

	Messenger messenger = new Messenger(new MessageServiceSimpleImpl());

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Test
	public void checkSendingMessageInvalidServerValidMessage() {
		assertEquals(1, messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessageValidServerInvalidMessage() {
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void checkSendingMessageValidServerValidMessage() {
		assertThat(messenger.sendMessage(VALID_SERVER, VALID_MESSAGE),
				either(equalTo(0)).or(equalTo(1)));
	}
	
	@Test
	public void checkSendingMessageInvalidServerInvalidMessage() {
		assertEquals(2, messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void checkTestConnectionInvalidServer() {
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
		assertThat(messenger.testConnection(INVALID_SERVER), either(equalTo(0)).or(equalTo(1)));
	}
	
	@Test
	public void checkTestConnectionValidServer() {
		assertEquals(0, messenger.testConnection(VALID_SERVER));
		assertThat(messenger.testConnection(VALID_SERVER), either(equalTo(0)).or(equalTo(1)));
	}
}

