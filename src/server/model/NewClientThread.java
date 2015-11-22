package server.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import server.exceptions.StandardServerException;

/**
 * Class that implements functionality for client
 * @author Janusz Czornik
 * @version 1.0
 */
public class NewClientThread extends ServerThread{

    /**
     * socket used to comunicate with client
     */
    private final Socket clientSocket;
    /**
     * Variable to store all comunication with client
     */
    private String clientMessage;
    /**
     * Variable used to write through socket
     */
    private final PrintWriter out;
    /**
     * Variable used to read from socket
     */
    private final BufferedReader in;
    
    
    /**
     * Sets the value of client socket and inicialized out and in streams
     * @param clientSocket reference to client socket
     * @throws IOException if cannot open stream
     */
    public NewClientThread(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        this.clientMessage = "";
        out = new PrintWriter(this.clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
    }
    
    /**
     * Ending the thread
     * @throws StandardServerException if cannot close the socket
     */
    
    @Override
    public void terminate() throws StandardServerException {
        super.terminate();
        
        try {
            clientSocket.close();
        } catch (IOException ex) {
            throw new StandardServerException(ex.getMessage(), StandardServerException.ErrorCode.CLOSING_CLIENT_SOCKET);
        }
    }
    
    /**
     * Allows to comunicate with client
     * @param message message to send
     */
    public void writeToClient(String message) {
        out.println(message);
    }
    
    /**
     * Allow to get messages from client
     * @return client message
     */
    public String getClientMessage() {
        return clientMessage;
    }
    
    /**
     * The thread. Reads from client and send the message back
     */
    @Override
    public void run() {
        while(running) {
            try {
                clientMessage += in.readLine();
                out.println(clientMessage);
            } catch (IOException ex) {
                return;
            }
        }
    }
    
}
