package mockitodemo

open class StorageService {

    private var saved = ""

    open fun save(myMessage: String) {
        saved = myMessage
    }

    open fun readSaved(key: String): String {
        return saved
    }
}
