package client.controller;

import client.model.Friend;
import client.model.ListOfFriends;
import client.view.ClientView;
import client.view.NewFriendWindow;
import client.view.NewGroupWindow;
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
    private final ListOfFriends LIST_OF_FRIENDS;
    
    /**
     * reference to CLIENT_VIEW
     */
    private final ClientView CLIENT_VIEW;
    
    /**
     * set that contains group names
     */
    private HashSet<String> GROUPS;
    
    /**
     * window to add new Friend
     */
    private final NewFriendWindow NFW;
    
    /**
     * widow to add group
     */
    private final NewGroupWindow NGW;
    
    
    /**
     * Constructor for controller
     * @param clientView reference to VlientView
     * @param listOfFriends reference to ListofFriends
     */
    public ClientController(ClientView clientView, ListOfFriends listOfFriends) {
        this.CLIENT_VIEW = clientView;
        this.LIST_OF_FRIENDS = listOfFriends;
        this.NFW = new NewFriendWindow();
        this.NGW = new NewGroupWindow();
        GROUPS = new HashSet<>();
        
        LIST_OF_FRIENDS.getListOfFriends().stream().forEach((f) -> {
            GROUPS.add(f.getGroup());
        });
        
        CLIENT_VIEW.addNodes(GROUPS);
        
        HashSet<Friend> friends = LIST_OF_FRIENDS.getListOfFriends();
        
        GROUPS.stream().forEach((group) -> {
            HashSet<String> friendsToAdd = new HashSet<>();
            friends.stream().filter((f) -> (f.getGroup().equals(group))).forEach((f) -> {
                friendsToAdd.add(f.getName());
            });
            CLIENT_VIEW.addNodes(friendsToAdd, group);
        });
        
        HashSet<String> friendsToAddWithoutGroups = new HashSet<>();
        friends.stream().forEach((friend) -> {
            friendsToAddWithoutGroups.add(friend.getName());
        });
        
        CLIENT_VIEW.addNodesWithoutGropus(friendsToAddWithoutGroups);
        
        CLIENT_VIEW.addNewFriendListener(new AddNewFriendListener());
        CLIENT_VIEW.addNewGroupListener(new AddNewGroupListener());
        
        NFW.addCancelButtonListener(new CancelButtonListenerForNfw());
    }
    
    
    /**
     * Class for adding a new friend
     */
    private class AddNewFriendListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            NFW.setVisible(true);
        }
    
    }
    
    
    /**
     * Class for Adding a new group
     */
    private class AddNewGroupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            NGW.setVisible(true);
        }
    
    }
    
    
    /**
     * Class for closing the NFW window
     */
    private class CancelButtonListenerForNfw implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            NFW.clearInput();
            NFW.dispose();
        }
        
    }
    
}
