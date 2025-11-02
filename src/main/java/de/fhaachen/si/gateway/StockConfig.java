package de.fhaachen.si.gateway;

import java.util.ResourceBundle;

public class StockConfig {

    private final String endpoint;
    private final String username;
    private final String password;

    public StockConfig() {
        ResourceBundle bundle = ResourceBundle.getBundle("stock");
        this.endpoint = bundle.getString("erp.endpoint");
        this.username = bundle.getString("erp.username");
        this.password = bundle.getString("erp.password");
    }

    public String endpoint() {
        return endpoint;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }
}