/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import server.exceptions.StandardServerException;

/**
 *
 * @author januszczornik
 */
public class ListeningForConnectionTest {
    
    public ListeningForConnectionTest() {
    }
    
    @Before
    public void setUp() throws StandardServerException, IOException {
        serverSocket = new ServerSocket(2222);
    }
    
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
            fail("The test case is a prototype.");
    }

    /**
     * Test of terminateWithLambda method, of class ListeningForConnection.
     * @throws server.exceptions.StandardServerException
     */
    @Test
    public void testTerminateWithLambda() throws StandardServerException, InterruptedException {
        System.out.println("terminateWithLambda");
        ListeningForConnection instance = new ListeningForConnection(serverSocket);
        instance.terminateWithLambda();
        instance.join();
        if(instance.isRunning())
            fail("The test case is a prototype.");
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
    
    private ServerSocket serverSocket;
    
}
