package javase10.t02.connectpool;

import java.util.ResourceBundle;

public class DBResourceManager {
    private static DBResourceManager instance = new DBResourceManager();

    private ResourceBundle bundle = ResourceBundle.getBundle("javase10.t02.db");

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }
}
