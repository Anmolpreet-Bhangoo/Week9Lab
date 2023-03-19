package models;

import java.io.Serializable;

/**
 *
 * @author Anmolpreet
 */
public class Role implements Serializable{
    private int roleID;
    private String name;

    public Role() {
    }

    public Role(int roleID, String name) {
        this.roleID = roleID;
        this.name = name;
    }

    public int getRoleID() {
        return roleID;
    }

    public String getName() {
        return name;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString(){
        return this.name;
    }
    
}
