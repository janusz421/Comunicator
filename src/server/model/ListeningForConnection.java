package server.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import server.exceptions.StandardServerException;

/**
 * Class that allows for listening for new clients and create a new instance of NewClientThread if any appears
 * @author Janusz Czornik
 * @version 1.0
 */
public class ListeningForConnection extends ServerThread {
    /**
     * ServerSocket on which program will be listening for new peers 
     */
    private final ServerSocket serverSocket;
    /**
     * ArrayList to store threads for new clients
     */
    private final ArrayList<NewClientThread> newClientList;
    
    /**
     * Class constructor
     * @param serverSocket referece to ServerSocket
     */
    public ListeningForConnection(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        newClientList = new ArrayList<>();
    }
    
    /**
     * Set the value of running to false and ends the thread. It also terminate all threads stored in newClientList
     * @throws StandardServerException in case of any setbacks
     */
    @Override
    public void terminate() throws StandardServerException {
        super.terminate();
        for(NewClientThread client : newClientList) {
            client.terminate();
        }
        
        try {
            serverSocket.close();
        } catch (IOException ex) {
            throw new StandardServerException(ex.getMessage(), StandardServerException.ErrorCode.CLOSING_SERVER_SOCKET);
        }
    }
    
    /**
     * Set the value of running to false and ends the thread. It also terminate all threads stored in newClientList.
     * The method has been depreceated and should not be use anymore.
     * @throws StandardServerException in case of any setbacks
     */
    @Deprecated
    public void terminateWithLambda() throws StandardServerException {
        super.terminate();
        newClientList.forEach((NewClientThread client) -> {
            try {
                client.terminate();
            } catch (StandardServerException ex) {
            }
        });
        
        try {
            serverSocket.close();
        } catch (IOException ex) {
            throw new StandardServerException(ex.getMessage());
        }   
    }
    
    
    /**
     * Starts listening on given port and create a new instance of NewClientThread if needed.
     * All NewClientThread are store in new client list 
     */
    @Override
    public void run() {
        while(running) {
            try {
                newClientList.add(new NewClientThread(serverSocket.accept()));
                newClientList.get(newClientList.size()-1).start();
            } catch (IOException ex) {
                return;
            }
        }
    }
    
}
