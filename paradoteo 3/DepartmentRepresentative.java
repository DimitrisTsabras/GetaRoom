package models;

import java.io.Serializable;

public class DepartmentRepresentative extends User implements Serializable {
    private Department department;

    public DepartmentRepresentative(int id, UserProfile profile, Department department) {
        super(id, profile);
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}
