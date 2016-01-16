
package protocols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Janusz Czornik
 * @version 1.0
 */
public class ServerProtocol {
    private final PrintWriter OUT;
    private final BufferedReader IN;
    private final String EMPTY_MESSAGE = "";
    
    public ServerProtocol(PrintWriter out, BufferedReader in) {
        this.OUT = out;
        this.IN = in;
    }
    
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
