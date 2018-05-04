package mockitodemo

class Child(private val age: Int) : Parent(), Comparable<Child> {

    override fun compareTo(other: Child): Int {

        return if (age < other.age) {
            -1
        } else if (age > other.age) {
            1
        } else {
            0
        }
    }

    override fun equals(o: Any?): Boolean {
        if (this === o)
            return true
        if (o !is Child)
            return false

        val child = o as Child?

        return age == child!!.age

    }

    override fun hashCode(): Int {
        return age
    }
}
