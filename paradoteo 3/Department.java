package models;

import java.io.Serializable;

public class Department implements Serializable {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
