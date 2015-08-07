package by.prohorov.resource;

import java.util.ResourceBundle;

public class DataBaseManager {
    private final static ResourceBundle resourceBundle =
            ResourceBundle.getBundle("resources.dataBase");

    private DataBaseManager() {}

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
