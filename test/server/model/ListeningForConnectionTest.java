package server.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import server.exceptions.StandardServerException;

/**
 * Test class for listening for connections
 * @author janusz czornik
 */
public class ListeningForConnectionTest {
    
    /**
     * Standard constructor
     */
    
    public ListeningForConnectionTest() {
    }
    
    /**
     * Runs before every single method in this class
     * @throws StandardServerException
     * @throws IOException 
     */
    @Before
    public void setUp() throws StandardServerException, IOException {
        serverSocket = new ServerSocket(2222);
    }
    
    /**
     * Runs after every single method in this class
     * @throws StandardServerException
     * @throws IOException
     * @throws InterruptedException 
     */
    @After
    public void tearDown() throws StandardServerException, IOException, InterruptedException {
        serverSocket.close();
    }

    /**
     * Test of terminate method, of class ListeningForConnection.
     * @throws server.exceptions.StandardServerException
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testTerminate() throws StandardServerException, InterruptedException {
        System.out.println("terminate");
        ListeningForConnection instance = new ListeningForConnection(serverSocket);
        instance.terminate();
        instance.join();
        if(instance.isRunning())
            fail("Terminate failed");
    }

    /**
     * Test of terminateWithLambda method, of class ListeningForConnection.
     * @throws server.exceptions.StandardServerException
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testTerminateWithLambda() throws StandardServerException, InterruptedException {
        System.out.println("terminateWithLambda");
        ListeningForConnection instance = new ListeningForConnection(serverSocket);
        instance.terminateWithLambda();
        instance.join();
        if(instance.isRunning())
            fail("terminateWithLambda failed");
    }

    /**
     * Test of run method, of class ListeningForConnection.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ListeningForConnection instance = new ListeningForConnection(serverSocket);
        instance.start();
        try {
            Socket clientSocket = new Socket("localhost", 2222);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = "Writing to server";
            out.println(message);
            String response = in.readLine();
            assertEquals(message, response);
        } catch (IOException ex) {
            fail("Run test feild!");
        }
    }
    
    /**
     * server socket used to listen on
     */
    private ServerSocket serverSocket;
    
}
