/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author janus
 */
public class NewGroupWindow extends JFrame {
    
    private final JPanel firstPanel;
    private final JPanel buttonPanel;
    private final JLabel groupName;
    private final JTextField groupNameField;
    private final JButton saveButton;
    private final JButton cancelButton;
    
    public NewGroupWindow() {
        this.setLayout(new GridLayout(2,0));
        
        firstPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel = new JPanel(new GridLayout(1,2));
        
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
}
