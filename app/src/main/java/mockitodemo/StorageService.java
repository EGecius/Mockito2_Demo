package mockitodemo;

public class StorageService {

    private String saved = "";

    public void save(final String myMessage) {
        saved = myMessage;
    }

	public String readSaved(String key) {
        return saved;
    }
}
