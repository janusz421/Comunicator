/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author janus
 */
public class NewFriendWindow extends JFrame {
    private final JPanel firstRow;
    private final JPanel secondRow;
    private final JPanel thirdRow;
    private final JPanel buttonRow;
    
    private final JLabel firstName;
    private final JLabel lastName;
    private final JLabel group;
    
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField groupField;
    
    private final JButton saveButton;
    private final JButton cancelButton;
    
    
    public NewFriendWindow() {
        this.setLayout(new GridLayout(4, 0, 0,10));
        firstRow = new JPanel();
        firstRow.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        firstRow.setLayout(new GridLayout(1, 2));
        secondRow = new JPanel();
        secondRow.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        secondRow.setLayout(new GridLayout(1, 2));
        thirdRow = new JPanel();
        thirdRow.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        thirdRow.setLayout(new GridLayout(1, 2));
        buttonRow = new JPanel();
        
        firstName = new JLabel("Imię:");
        lastName = new JLabel("Nazwisko:");
        group = new JLabel("Nazwa grupy:");
        
        firstNameField = new JTextField();
        firstNameField.setSize(new Dimension(100,20));
        lastNameField = new JTextField();
        lastNameField.setSize(new Dimension(100,20));
        groupField = new JTextField();
        groupField.setSize(new Dimension(100,20));
        
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        
        firstRow.add(firstName);
        firstRow.add(firstNameField);
        
        secondRow.add(lastName);
        secondRow.add(lastNameField);
        
        thirdRow.add(group);
        thirdRow.add(groupField);
        
        buttonRow.add(saveButton);
        buttonRow.add(cancelButton);
        
        this.add(firstRow);
        this.add(secondRow);
        this.add(thirdRow);
        this.add(buttonRow);
        
        firstRow.setLocation(0, 0);
        secondRow.setLocation(0, 50);
        thirdRow.setLocation(0, 100);
        buttonRow.setLocation(0, 150);
        
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 200);
        this.setResizable(false);
    }
    
    public void addSaveButtonListener(ActionListener e) {
        saveButton.addActionListener(e);
    }
    
    public void addCancelButtonListener(ActionListener e) {
        cancelButton.addActionListener(e);
    }
}
