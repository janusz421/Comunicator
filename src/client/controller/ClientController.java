/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.model.Friend;
import client.model.ListOfFriends;
import client.view.ClientView;
import java.util.HashSet;

/**
 *
 * @author janus
 */
public class ClientController {
    private final ListOfFriends listOfFriends;
    private final ClientView clientView;
    private HashSet<String> groups;
    
    public ClientController(ClientView clientView, ListOfFriends listOfFriends) {
        this.clientView = clientView;
        this.listOfFriends = listOfFriends;
        groups = new HashSet<>();
        
        listOfFriends.getListOfFriends().stream().forEach((f) -> {
            groups.add(f.getGroup());
        });
        
        clientView.addNodes(groups);
        
        HashSet<Friend> friends = listOfFriends.getListOfFriends();
        
        groups.stream().forEach((group) -> {
            HashSet<String> friendsToAdd = new HashSet<>();
            friends.stream().filter((f) -> (f.getGroup().equals(group))).forEach((f) -> {
                friendsToAdd.add(f.getName());
            });
            clientView.addNodes(friendsToAdd, group);
        });
    }
    
    
}
