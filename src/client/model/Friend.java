package client.model;

import java.util.Objects;

/**
 * Contains information about contact
 * @author Janusz Czornik
 * @version 1.0
 */
public class Friend {
    /**
     * name of group
     */
    private final String group;
    /**
     * name of user
     */
    private final String name;
    /**
     * state og user
     */
    private String state;
    
    
    /**
     * constructor for Friend
     * @param group name of group
     * @param name name of user
     * @param state state of user
     */
    public Friend(String group, String name, String state) {
        this.group = group;
        this.name = name;
        this.state = state;
    }
    
    
    /**
     * Get grup name
     * @return grup name
     */
    public String getGroup() {
        return group;
    }
    
    
    /**
     * Get user name
     * @return user name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get state
     * @return state
     */
    public String getSate() {
        return state;
    }
    
    /**
     * Set state
     * @param state state
     */
    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * overriding equels
     * @param obj another object
     * @return true if equels
     */
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass())
            return false;
        Friend object = (Friend)obj;
        return (this.name == null ? object.getName() == null : this.name.equals(object.getName()));
    }
    
    /**
     * geting a hash code of object
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }
}
