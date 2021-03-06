package server.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import server.exceptions.StandardServerException;

/**
 * Test class for client thread
 * @author Janusz Czornik
 */
public class NewClientThreadTest {
    
    /**
     * Standard constructor
     */
    public NewClientThreadTest() {
    }
    
     /**
     * Runs before every single method in this class
     * @throws server.exceptions.StandardServerException
     * @throws java.io.IOException
     */
    
    @Before
    public void setUp() throws StandardServerException, IOException {
        String [] args = new String[1];
        args[0] = "3333";
        serverConf = new ServerConfiguration(args);
        serverConf.startServer();
        clientSocket = new Socket("localhost", 3333);
    }
    
     /**
     * Runs after every single method in this class
     * @throws server.exceptions.StandardServerException
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    
    @After
    public void tearDown() throws StandardServerException, IOException, InterruptedException {
        serverConf.stopServer();
        clientSocket.close();
    }

    /**
     * Test of terminate method, of class NewClientThread.
     * @throws java.lang.Exception
     */
    @Test
    public void testTerminate() throws Exception {
        System.out.println("terminate");
        NewClientThread instance = new NewClientThread(clientSocket);
        instance.terminate();
        instance.join();
        if(instance.isRunning())
            fail("The test case is a prototype.");
    }

    /**
     * Test of writeToClient method, of class NewClientThread.
     */
    @Test
    public void testWriteToClient() {
        System.out.println("writeToClient");
        String message = "Message from server!";
        try {
            NewClientThread instance = new NewClientThread(clientSocket);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            instance.writeToClient(message);
            String messageFromServer = in.readLine();
            assertEquals(message, messageFromServer);
        } catch (IOException ex) {
            fail("Cannot send the message");
        }
    }

    /**
     * Test of run method, of class NewClientThread.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        NewClientThread instance;
        try {
            instance = new NewClientThread(clientSocket);
            instance.start();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            if(clientSocket.isConnected() == false)
                fail("Fail to connect to server!");
            
            String serverResponse;
            String phrase = "Is everything good?";
            out.println(phrase);
            serverResponse = in.readLine();
            assertEquals(serverResponse, phrase);
        } catch (IOException ex) {
            fail("Cannot create an instance of NewClientThread");
        }
    }
    
    /**
     * Socket for listen on
     */
    private ServerConfiguration serverConf;
    
    /**
     * Socket to comunicate throw
     */
    private Socket clientSocket;
}
