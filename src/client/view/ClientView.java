/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import java.util.HashSet;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author janus
 */
public class ClientView extends JFrame {
    private JTabbedPane tabbedPane;
    private JTree treeWithoutGroups;
    private JTree tree;
    private DefaultMutableTreeNode topWithoutGroups;
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
        initTabbedPane();
        initTree();
        initTreeWithoutGroups();
        JScrollPane treeScrollPanel = new JScrollPane(tree);
        JScrollPane treeWithoutGroupsPanel = new JScrollPane(treeWithoutGroups);
        tabbedPane.addTab("List with groups",treeScrollPanel);
        tabbedPane.addTab("List without groups", treeWithoutGroupsPanel);
        this.add(tabbedPane);
    }
    
    private void initTabbedPane() {
        tabbedPane = new JTabbedPane();
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
    
    private void initTreeWithoutGroups() {
        topWithoutGroups = new DefaultMutableTreeNode("Friends");
        treeWithoutGroups = new JTree(topWithoutGroups);
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
    
    public void addNodesWithoutGropus(HashSet<String> friends) {
        friends.stream().forEach(
                (friend) -> {
                    topWithoutGroups.add(new DefaultMutableTreeNode(friend));
                }
        );
    }
}
