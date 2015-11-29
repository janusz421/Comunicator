/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

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
}
