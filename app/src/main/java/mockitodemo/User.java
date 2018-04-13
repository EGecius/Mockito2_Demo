package mockitodemo;

import java.util.ArrayList;
import java.util.Collection;

public class User {

	private final WebService webService;
	private final StorageService storageService;

	public User(final WebService webService) {
		this.webService = webService;
		this.storageService = new StorageService();
	}

	public User(final WebService webService, final StorageService storageService) {
		this.webService = webService;
		this.storageService = storageService;
	}

	public void sendMessageInList(final String message) {
		ArrayList<Object> list = new ArrayList<>();
		list.add(message);
		webService.sendMessages(list);
	}

	public void sendInteger(final Integer integer) {
		webService.sendInteger(integer);
	}

	public void sendObject(final Object object) {
		webService.sendObject(object);
	}

	public void sendCollection(final Collection<Object> collection) {
		webService.sendCollection(collection);
	}

	public void sendCollectionOfStrings(final Collection<String> strings) {
		webService.sendCollection(strings);
	}

	public void sendMyParent(final Parent parent) {
		webService.sendMyParent(parent);
	}

	public void sendMessage(final String message) {
		webService.sendMessage(message);
	}

	public void sendArray(final String[] strings) {
		webService.sendArray(strings);
	}

	public void sendAndSaveMessage(final String myMessage) {
		webService.sendMessage(myMessage);
		storageService.save(myMessage);
	}

	public void sendSaved(String key) {
        String saved = storageService.readSaved(key);
        webService.sendMessage(saved);
    }
}
