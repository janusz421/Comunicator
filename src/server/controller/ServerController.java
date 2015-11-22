package server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import server.exceptions.StandardServerException;
import server.model.ServerConfiguration;
import server.view.ServerView;

/**
 * Class that allows for comunication between View and Model
 * @author Janusz Czornik
 * @version 1.0
 */
public class ServerController {
    /**
     * Reference to user interface class
     */
    private final ServerView serverView;
    /**
     * Reference to server configuration class
     */
    private final ServerConfiguration serverConfig;
    
    /**
     * Constructor of ServerController. It handles the communication between the user interface and controllers.
     * @param serverView agrument giving access to user interface functions
     * @param serverConfig argument giving access tp serverConfiguration functions
     */
    public ServerController(ServerView serverView, ServerConfiguration serverConfig) {
        this.serverView = serverView;
        this.serverConfig = serverConfig;
        
        this.serverView.addStartListener(new StartButtonListener());
        this.serverView.addStopListener(new StopButtonListener());
        this.serverView.addToMessageTextArea("Server is currently: " + serverConfig.getServerStatus());
    }
    
    /**
     * Handling actions caused by clicking star button
     */
    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean error = false;
            try {
                serverConfig.startServer();
            } catch (StandardServerException ex) {
                if(ex.getErrorCode() == 0)
                    serverView.displayErrorMessage(ex.getMessage());
                else
                    serverView.displayErrorMessage(ex.getMessage() + " \nError code: " + ex.getErrorCode());
                error = true;
            } catch (Exception ex) {
                serverView.displayErrorMessage(ex.getMessage());
                error = true;
            }
            
            if(!error) {
                serverView.addToMessageTextArea("Server is currently: " + serverConfig.getServerStatus());
            }
        }
        
    }
    
    /**
     * Handling actions caused by clicking stop button
     */
    
    private class StopButtonListener implements ActionListener {
        
        /**
         * Handle action
         * @param e event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean error = false;
            try {
                serverConfig.stopServer();
            } catch (StandardServerException ex) {
                error = true;
                if(ex.getErrorCode() == 0)
                    serverView.displayErrorMessage(ex.getMessage());
                else
                    serverView.displayErrorMessage(ex.getMessage() + " \nError code: " + ex.getErrorCode());
            } catch (Exception ex) {
                error = true;
                serverView.displayErrorMessage(ex.getMessage());
            }
            
            if(!error) {
                serverView.addToMessageTextArea("Server is currently: " + serverConfig.getServerStatus());
            }
        }
        
    }
}
