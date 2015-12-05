/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import java.util.Objects;

/**
 *
 * @author janus
 */
public class Friend {
    private final String group;
    private final String name;
    private String state;
    
    public Friend(String group, String name, String state) {
        this.group = group;
        this.name = name;
        this.state = state;
    }
    
    public String getGroup() {
        return group;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSate() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass())
            return false;
        Friend object = (Friend)obj;
        return (this.name == null ? object.getName() == null : this.name.equals(object.getName()));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }
}
