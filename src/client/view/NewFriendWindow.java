/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author janus
 */
public class NewFriendWindow extends JFrame {
    private JLabel firstName;
    private JLabel lastName;
    private JLabel group;
    
    public NewFriendWindow() {
//        this.add(firstName);
//        this.add(lastName);
//        this.add(group);
//        
//        firstName.setText("Imię:");
//        lastName.setText("Nazwisko:");
//        group.setText("Nazwa grupy (może być puste):");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 200);
    }
}
