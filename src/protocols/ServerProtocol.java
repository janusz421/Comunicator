
package protocols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Server protocol
 * @author Janusz Czornik
 * @version 1.0
 */
public class ServerProtocol {
    /**
     * Stream for out
     */
    private final PrintWriter OUT;
    /**
     * Stream for in
     */
    private final BufferedReader IN;
    /**
     * Empty message
     */
    private final String EMPTY_MESSAGE = "";
    
    
    /**
     * Constructor
     * @param out stream for out
     * @param in stream for in
     */
    public ServerProtocol(PrintWriter out, BufferedReader in) {
        this.OUT = out;
        this.IN = in;
    }
    
    /**
     * Function to comunicate with client
     * @return message send by client
     * @throws IOException if problem with comunication
     */
    public String startComunication() throws IOException {
        String message = IN.readLine();
        if(message.equals(ProtocolMessages.NEW_MESSAGE)) {
            OUT.println(ProtocolMessages.WAITING);
            message = IN.readLine();
            OUT.println(ProtocolMessages.SUCCESS);
            return message;
        }
        
        else
            OUT.println(ProtocolMessages.FAILURE);
        return EMPTY_MESSAGE;
    }
}
