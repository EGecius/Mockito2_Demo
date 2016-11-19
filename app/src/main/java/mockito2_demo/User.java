package mockito2_demo;

import java.util.ArrayList;
import java.util.Collection;

public final class User {

	private final WebService webService;

	public User(final WebService webService) {
		this.webService = webService;
	}

	public void sendMessage(final String message) {
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

	public void sendMyParent(final MyParent myParent) {
		webService.sendMyParent(myParent);
	}
}
