package client.controller;

import client.model.Friend;
import client.model.ListOfFriends;
import client.view.ClientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

/**
 * Controlls comunication between View and Model
 * @author Janusz Czornik
 * @version 1.0
 */
public class ClientController {
    
    /**
     * List of friends
     */
    private final ListOfFriends listOfFriends;
    
    /**
     * reference to clientView
     */
    private final ClientView clientView;
    
    /**
     * set that contains group names
     */
    private HashSet<String> groups;
    
    
    /**
     * Constructor for controller
     * @param clientView reference to VlientView
     * @param listOfFriends reference to ListofFriends
     */
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
        
        HashSet<String> friendsToAddWithoutGroups = new HashSet<>();
        friends.stream().forEach((friend) -> {
            friendsToAddWithoutGroups.add(friend.getName());
        });
        
        clientView.addNodesWithoutGropus(friendsToAddWithoutGroups);
        
        clientView.addNewFriendListener(new AddNewFriendListener());
        clientView.addNewGroupListener(new AddNewGroupListener());
        clientView.addMenageGroupListener(new AddMenageGroupListener());
    }
    
    
    /**
     * Class for adding a new friend
     */
    private class AddNewFriendListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Add Friends");
        }
    
    }
    
    
    /**
     * Class for Adding a new group
     */
    private class AddNewGroupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Add Groups");
        }
    
    }
    
    
    /**
     * Class for managing a group
     */
    private class AddMenageGroupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Manage Groups");
        }
    
    }
    
}
