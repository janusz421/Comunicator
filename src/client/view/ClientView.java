package client.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.HashSet;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 * Client view
 * @author Janusz Czornik
 * @version 1.0
 */
public class ClientView extends JFrame {
    /**
     * tabbed panel
     */
    private JTabbedPane tabbedPane;
    /**
     * tree without groups
     */
    private JTree treeWithoutGroups;
    /**
     * tree
     */
    private JTree tree;
    /**
     * top node without groups
     */
    private DefaultMutableTreeNode topWithoutGroups;
    /**
     * top node
     */
    private DefaultMutableTreeNode top;
    /**
     * nodes of groups
     */
    private HashSet<DefaultMutableTreeNode> groupNodes;
    /**
     * nodes of fiends
     */
    private HashSet<DefaultMutableTreeNode> friendNodes;
    
    /**
     * menu bar
     */
    private JMenuBar menuBar;
    /**
     * Menu item to add friend
     */
    private JMenuItem addFriend;
    /**
     * Menu item to add group
     */
    private JMenuItem addGroup;
    
    private JMenuItem connect;
    
    /**
     * constructor
     */
    public ClientView() {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(450, 260);
    }
    
    /**
     * Init components for window
     */
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
    
    
    /**
     * Init tabbed panel
     */
    private void initTabbedPane() {
        tabbedPane = new JTabbedPane();
    }
    
    /**
     * Init menu
     */
    private void initMenu() {
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        
        addFriend = new JMenuItem("Add new friend");
        addGroup = new JMenuItem("Add new group");
        connect = new JMenuItem("Connect to server");
        menu.add(addFriend);
        menu.add(addGroup);
        menu.add(connect);
        this.setJMenuBar(menuBar);
    }
    
    /**
     * Init tree
     */
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
    
    /**
     * Get set of groups
     * @return group nodes
     */
    public HashSet<DefaultMutableTreeNode> getGroups() {
        return groupNodes;
    }
    
    /**
     * Adding nodes
     * @param nodes nodes to add
     */
    public void addNodes(HashSet<String> nodes) {
        nodes.stream().forEach((nodeName) -> {
            groupNodes.add(new DefaultMutableTreeNode(nodeName));
        });
        
        groupNodes.stream().forEach((node) -> {
            top.add(node);
        });
    }
    
    /**
     * Adding nodes to given parent node
     * @param nodes nodes to add
     * @param parentNodeName name of parent node
     */
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
    
    /**
     * Adding nodes to view without group
     * @param friends nodes to add
     */
    public void addNodesWithoutGropus(HashSet<String> friends) {
        friends.stream().forEach(
                (friend) -> {
                    topWithoutGroups.add(new DefaultMutableTreeNode(friend));
                }
        );
    }
    
    public JTree getTree() {
        return this.tree;
    }
    
    /**
     * Adding listener to new friend
     * @param e action listener
     */
    public void addNewFriendListener(ActionListener e) {
        addFriend.addActionListener(e);
    }
    
    /**
     * Adding new group listener
     * @param e action listener
     */
    public void addNewGroupListener(ActionListener e) {
        addGroup.addActionListener(e);
    }
    
    public void addConnectListener(ActionListener e) {
        connect.addActionListener(e);
    }
    
    public void addTreeListener(MouseAdapter e) {
        tree.addMouseListener(e);
    }
    
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
