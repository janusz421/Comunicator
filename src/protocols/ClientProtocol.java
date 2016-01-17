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
 *
 * @author Janusz Czornik
 * @version 1.0
 */
public class ClientProtocol {
    private final PrintWriter OUT;
    private final BufferedReader IN;
    private final String EMPTY_STRING = "";
    public ClientProtocol(PrintWriter out, BufferedReader in) {
         OUT = out;
         IN = in;
    }
    
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
