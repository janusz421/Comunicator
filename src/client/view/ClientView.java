/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import client.model.Friend;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author janus
 */
public class ClientView extends JFrame {
    private JTree tree;
    private DefaultMutableTreeNode top;
    private HashSet<DefaultMutableTreeNode> groupNodes;
    private HashSet<DefaultMutableTreeNode> friendNodes;
    private JMenuBar menuBar;
    private JMenuItem addFriend;
    private JMenuItem addGroup;
    private JMenuItem menageGroups;
    
    public ClientView() {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(450, 260);
    }
    
    private void initComponents() {
        initMenu();
        initTree();
        JScrollPane treeScrollPanel = new JScrollPane(tree);
        this.add(treeScrollPanel);
    }
    
    private void initMenu() {
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        
        addFriend = new JMenuItem("Add new friend");
        addGroup = new JMenuItem("Add new group");
        menageGroups = new JMenuItem("Menage goups");
        menu.add(addFriend);
        menu.add(addGroup);
        menu.add(menageGroups);
        this.setJMenuBar(menuBar);
    }
    
    private void initTree() {
        groupNodes = new HashSet<>();
        top = new DefaultMutableTreeNode("Friends");
        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    }
    
    public HashSet<DefaultMutableTreeNode> getGroups() {
        return groupNodes;
    }
    
    public void addNodes(HashSet<String> nodes) {
        nodes.stream().forEach((nodeName) -> {
            groupNodes.add(new DefaultMutableTreeNode(nodeName));
        });
        
        groupNodes.stream().forEach((node) -> {
            top.add(node);
        });
    }
    
    public void addNodes(HashSet<String> nodes, String parentNodeName) {
        for (DefaultMutableTreeNode object : groupNodes) {
            if(parentNodeName.equals(object.toString())) {
                nodes.stream().forEach((node) -> {
                    object.add(new DefaultMutableTreeNode(node));
                });
                break;
            }
        }
    }
}
