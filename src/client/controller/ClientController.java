/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.model.ListOfFriends;
import client.view.ClientView;

/**
 *
 * @author janus
 */
public class ClientController {
    private ListOfFriends listOfFriends;
    private final ClientView clientView;
    
    public ClientController(ClientView clientView, ListOfFriends listOfFriends) {
        this.clientView = clientView;
        this.listOfFriends = listOfFriends;
    }
    
    
}
