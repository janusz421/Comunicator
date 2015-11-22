package server.view;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Graphical User Interface
 * @author Janusz Czornik
 * @version 1.0
 */
public class ServerView extends javax.swing.JFrame {

    /**
     * Creates new form ServerView
     */
    public ServerView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        stopButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        messageTextArea.setEditable(false);
        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        jScrollPane1.setViewportView(messageTextArea);

        stopButton.setText("Stop");

        startButton.setText("Start");
        startButton.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 262, Short.MAX_VALUE)
                        .addComponent(startButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stopButton)
                    .addComponent(startButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        startButton.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Displays error message passed in agrument in new window
     * @param errorMessage message to show
     */
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
    
    /**
     * Adding a listener for start button
     * @param listenerForStartButton action listener
     */
    public void addStartListener(ActionListener listenerForStartButton) {
        startButton.addActionListener(listenerForStartButton);
    }
    
    /**
     * Adding a listener for stop button
     * @param listenerForStopButton action listener
     */
    public void addStopListener(ActionListener listenerForStopButton) {
        stopButton.addActionListener(listenerForStopButton);
    }
    
    /**
     * Adding newtext to MessageTextArea
     * @param newText text to add
     */
    public void addToMessageTextArea(String newText) {
        if(messageTextArea.getText().isEmpty())
            messageTextArea.setText(messageTextArea.getText() + newText);
        
        else
            messageTextArea.setText(messageTextArea.getText() + '\n' + newText);
    }

}
