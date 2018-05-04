package mockitodemo


open class WebService<T> {

    open fun sendMessages(list: List<Any>) {

    }

    open fun sendInteger(integer: Int?) {

    }

    open fun sendObject(myObject: Any) {

    }

    open fun sendCollection(collection: Collection<T>) {

    }

    open fun sendMyParent(parent: Parent) {

    }

    open fun sendMessage(matches: String) {

    }

    open fun sendArray(strings: Array<String>) {

    }
}
