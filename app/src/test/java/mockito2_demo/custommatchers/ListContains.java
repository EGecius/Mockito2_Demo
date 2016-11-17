package mockito2_demo.custommatchers;

import org.mockito.ArgumentMatcher;

import java.util.List;

final class ListContains<T> implements ArgumentMatcher<List> {

	private final T object;

	ListContains(final T object) {
		this.object = object;
	}

	@Override
	public boolean matches(final List list) {
		return list.contains(object);
	}
}
