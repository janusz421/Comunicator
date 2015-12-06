/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

/**
 *
 * @author janus
 */
public class ListOfFriends {
    private HashSet<Friend> listOfFriends;
    private final BufferedReader READER;
    private final String PATH_TO_CONTACTS = "src\\client\\model\\friends";
    private final Path PATH_TO_FILE = Paths.get(PATH_TO_CONTACTS);
    
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
    
    public HashSet<Friend> getListOfFriends() {
        return listOfFriends;
    }
}
