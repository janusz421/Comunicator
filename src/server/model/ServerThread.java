package server.model;

import server.exceptions.StandardServerException;

/**
 * Abstract class that extends Thread and give the terminate function
 * @author Janusz Czornik
 * @version 1.0
 */
public abstract class ServerThread extends Thread {
    /**
     * Variable that store the thread state. If true thread continue otherwise stops
     */
    protected volatile boolean running = true;
    
    /**
     * Used to stop thread
     * @throws StandardServerException in case of fauiler
     */
    public void terminate() throws StandardServerException{
        running = false;
    }
    
    public boolean isRunning() {
        return running;
    }
    
    /**
     * Method that handle server thread. Need to be override
     */
    @Override
    public abstract void run();
}
