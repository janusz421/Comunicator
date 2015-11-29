/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author janus
 */
public class ClientView extends JFrame {
    private JTree tree;
    
    public ClientView() {
        setJMenuBar(initMenu());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(450, 260);
    }
    
    private void initComponents() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Groups");
        createNodes(top);
    }
    
    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode group = null;
        DefaultMutableTreeNode person = null;
    }
    
    private JMenuBar initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        
        menu.add(new JMenuItem("Add new friend"));
        menu.add(new JMenuItem("Add new group"));
        menu.add(new JMenuItem("Menage goups"));
        
        return menuBar;
    }
}
