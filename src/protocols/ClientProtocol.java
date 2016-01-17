/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Protocol for client
 * @author Janusz Czornik
 * @version 1.0
 */
public class ClientProtocol {
    /**
     * Stream out
     */
    private final PrintWriter OUT;
    /**
     * Stream in
     */
    private final BufferedReader IN;
    /**
     * Empty string
     */
    private final String EMPTY_STRING = "";
    
    /**
     * Constructor
     * @param out stream out
     * @param in stream in
     */
    public ClientProtocol(PrintWriter out, BufferedReader in) {
         OUT = out;
         IN = in;
    }
    
    /**
     * Function to send message
     * @param message message to send
     * @return server response
     * @throws IOException if can't send
     */
    public String sendMessage(String message) throws IOException {
        OUT.println(ProtocolMessages.NEW_MESSAGE);
        if(IN.readLine().equals(ProtocolMessages.WAITING)) {
            OUT.println(message); 
            if(IN.readLine().equals(ProtocolMessages.SUCCESS))
                return IN.readLine();
        }
        
        return EMPTY_STRING;
    }
}
