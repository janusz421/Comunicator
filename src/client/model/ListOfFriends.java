package client.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

/**
 * Class for list of friends
 * @author Janusz Czornik
 */
public class ListOfFriends {
    
    /**
     * containing a list of friends
     */
    private HashSet<Friend> listOfFriends;
    /**
     * Reader for file with contacts
     */
    private final BufferedReader READER;
    
    /**
     * path to contacts
     */
    private final String PATH_TO_CONTACTS = "src\\client\\model\\friends";
    /**
     * path object
     */
    private final Path PATH_TO_FILE = Paths.get(PATH_TO_CONTACTS);
    
    
    /**
     * Constructor
     * @throws IOException if cannot open file
     */
    public ListOfFriends() throws IOException {
        listOfFriends = new HashSet<>();
        READER = Files.newBufferedReader(PATH_TO_FILE, Charset.defaultCharset());
        String line;
        while((line = READER.readLine())!= null) {
            String[] data;
            data = line.split(" ");
            if(data.length == 3) {
                listOfFriends.add(new Friend(data[0], data[1], data[2]));
            }
        }
    }
    
    
    /**
     * get a list of friends
     * @return list of friends
     */
    public HashSet<Friend> getListOfFriends() {
        return listOfFriends;
    }
}
