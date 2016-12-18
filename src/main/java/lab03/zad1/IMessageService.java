package lab03.zad1;

public interface IMessageService {
	ConnectionStatus checkConnection(String server);
	SendingStatus send(String server, String contents) throws MalformedRecipientException;
}
