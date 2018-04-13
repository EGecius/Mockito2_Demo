package mockitodemo.custommatchers;

import org.mockito.ArgumentMatcher;

import java.util.List;

public final class ListContains<T> implements ArgumentMatcher<List> {

	private final T object;

	ListContains(final T object) {
		this.object = object;
	}

	@Override
	public boolean matches(final List list) {
		return list.contains(object);
	}
}
