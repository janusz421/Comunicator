/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.model.ListOfFriends;
import client.view.ClientView;
import java.util.HashSet;

/**
 *
 * @author janus
 */
public class ClientController {
    private ListOfFriends listOfFriends;
    private final ClientView clientView;
    private HashSet<String> groups;
    private HashSet<String> friends;
    
    public ClientController(ClientView clientView, ListOfFriends listOfFriends) {
        this.clientView = clientView;
        this.listOfFriends = listOfFriends;
        groups = new HashSet<>();
        friends = new HashSet<>();
        
        listOfFriends.getListOfFriends().stream().forEach((f) -> {
            groups.add(f.getGroup());
            friends.add(f.getName());
        });
        
        clientView.addNodes(groups);
        clientView.addNodes(friends, "znajomi");
    }
    
    
}
