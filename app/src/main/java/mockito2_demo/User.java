package mockito2_demo;

import java.util.ArrayList;

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

	public void sendInteger(final int integer) {
		webService.sendInteger(integer);
	}

	public void sendObject(final Object object) {
		webService.sendObject(object);
	}
}
