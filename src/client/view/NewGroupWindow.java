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
 * New window for adding group
 * @author Janusz Czornik
 * @version 1.0
 */
public class NewGroupWindow extends JFrame {
    
    /**
     * Panel for first row
     */
    private final JPanel firstPanel;
    /**
     * Panel for second row
     */
    private final JPanel buttonPanel;
    /**
     * Label for group name
     */
    private final JLabel groupName;
    /**
     * Field to write group name
     */
    private final JTextField groupNameField;
    /**
     * save button
     */
    private final JButton saveButton;
    /**
     * cancel button
     */
    private final JButton cancelButton;
    
    
    /**
     * constructor
     */
    public NewGroupWindow() {
        this.setLayout(new GridLayout(2,0));
        
        firstPanel = new JPanel(new GridLayout(1, 2));
        firstPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        buttonPanel = new JPanel();
        
        groupName = new JLabel("Group name:");
        groupNameField = new JTextField();
        groupNameField.setSize(new Dimension(100,20));
        
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        
        this.add(firstPanel);
        this.add(buttonPanel);
        
        firstPanel.add(groupName);
        firstPanel.add(groupNameField);
        
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(400, 100));
        this.setResizable(false);
    }
    
    /**
     * Metod to add action listener to cancel button
     * @param e action listener
     */
    public void addCancelListener(ActionListener e) {
        cancelButton.addActionListener(e);
    }
    
    
    /**
     * Metod to add listener to save button
     * @param e action listener
     */
    public void addSaveListener(ActionListener e) {
        saveButton.addActionListener(e);
    }
}
