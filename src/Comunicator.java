import server.view.ServerView;
import server.model.ServerConfiguration;
import server.controller.ServerController;
import server.view.InfoView;

/**
 * Main class of program
 * @author Janusz Czornik
 * @version 1.0
 */
public class Comunicator {

    /**
     * Main function
     * @param args the command line arguments (should be number of port to open and listen on)
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerView serverView = new ServerView();
        ServerConfiguration serverConf = new ServerConfiguration(args);
        ServerController serverController = new ServerController(serverView, serverConf);
        InfoView infoView = new InfoView();
        
        serverView.setVisible(true);
        infoView.setVisible(true);
    }
    
}
