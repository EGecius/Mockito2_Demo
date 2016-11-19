package mockito2_demo;

public class Child extends MyParent implements Comparable<Child> {

	private final int age;

	public Child(final int age) {
		this.age = age;
	}

	@Override
	public int compareTo(final Child other) {

		if (age < other.age) {
			return -1;
		} else if (age > other.age) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Child))
			return false;

		final Child child = (Child) o;

		return age == child.age;

	}

	@Override
	public int hashCode() {
		return age;
	}
}
