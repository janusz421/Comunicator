package server.model;

import java.io.IOException;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import server.exceptions.StandardServerException;

/**
 * Tests for server configuration class
 * @author Janusz Czornik
 */
public class ServerConfigurationTest {
    
    /**
     * Constructor for test
     */
    public ServerConfigurationTest() {
        instance = null;
    }
    
    /**
     * Closing server connection in case it was running
     */
    @After
    public void dispose() {
        try {
            instance.stopServer();
        } catch (StandardServerException | IOException | InterruptedException ex) {
        }
    }
    /**
     * Test of startServer method, of class ServerConfiguration.
     */
    @Test
    public void testStartServerWithGoodPort() {
        System.out.println("startServer");
        String[] args = new String[1];
        args[0] = "4444";
        instance = new ServerConfiguration(args);
        try {
            instance.startServer();
        } catch (StandardServerException | IOException ex) {
            fail("The test case is a prototype.");
        }
        System.out.println("Test succeed");
    }
    
    /**
     * Test for wrong port number
     */
    
    @Test
    public void testStartServerWithWrongPort()  {
        System.out.println("startServer");
        String[] args = new String[1];
        args[0] = "0";
        instance = new ServerConfiguration(args);
        try {
            instance.startServer();
        } catch (StandardServerException | IOException ex) {
            System.out.println("Test succeed");
            return;
        }
        fail("The test case is a prototype.");
    }
    
    /**
     * Test for max port number
     */
    
    @Test
    public void testStartServerWithMaxPort()  {
        System.out.println("startServer");
        String[] args = new String[1];
        args[0] = "65355";
        instance = new ServerConfiguration(args);
        try {
            instance.startServer();
        } catch (StandardServerException | IOException ex) {
               fail("The test case is a prototype.");
        }
        System.out.println("Test succeed");
    }
    
    /**
     * Test for max + 1 port number
     */
    
    @Test
    public void testStartServerWithMaxPlusOnePort()  {
        System.out.println("startServer");
        String[] args = new String[1];
        args[0] = "65536";
        instance = new ServerConfiguration(args);
        try {
            instance.startServer();
        } catch (StandardServerException | IOException ex) {
            System.out.println("Test succeed");
            return;
        }
        fail("The test case is a prototype.");
    }
    
    /**
     * Test start server with running server
     */
    
    @Test
    public void testStartServerWithRunningServer()  {
        System.out.println("startServer");
        String[] args = new String[1];
        args[0] = "4444";
        instance = new ServerConfiguration(args);
        try {
            instance.startServer();
        } catch (StandardServerException | IOException ex) {
            fail("Cannot get running server");
        }
        
    }

    /**
     * Test of stopServer method, of class ServerConfiguration.
     */
    @Test
    public void testStopWithRunningServerServer() {
        System.out.println("stopServer");
        String[] args = new String[1];
        args[0] = "4444";
        instance = new ServerConfiguration(args);
        try {
            instance.startServer();
        } catch (StandardServerException | IOException ex) {
            fail("Cannot get running server!");
        }
        try {
            instance.stopServer();
        } catch (StandardServerException | IOException | InterruptedException ex) {
            fail("The test case is a prototype.");
        }
        System.out.println("Test succeed"); 
    }
    
    /**
     * Test of stopServer method, of class ServerConfiguration without running server
     */
    @Test
    public void testStopWithoutRunningServerServer() {
        System.out.println("stopServer");
        String[] args = new String[1];
        args[0] = "4444";
        instance = new ServerConfiguration(args);
        try {
            instance.stopServer();
        } catch (StandardServerException | IOException | InterruptedException ex) {
            System.out.println("Test succeed");
            return;
        }
        fail("The test case is a prototype.");
    }
    
    private ServerConfiguration instance;
    
}
