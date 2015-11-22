package server.model;


/**
 * Class that contains info about program
 * @author Janusz Czornik
 * @version 1.0
 */

public class AuthorInfo {
    
    /**
     * Info about author
     */
    private final static String AUTHOR = "Janusz Czornik";
    /**
     * Info about version
     */
    private final static String VERSION = "1.0";
    /**
     * Info about copyrights
     */
    private final static String COPYRIGHTS = "freeware";
    
    /**
     * Return author name
     * @return AUTHOR name 
     */
    public static String getAuthor() {
        return AUTHOR;    
    }
    
    /**
     * Returns version number in string
     * @return VERSION
     */
    public static String getVersion() {
        return VERSION;
    }
    
    /**
     * Returns copyrights
     * @return COPYRIGHTS
     */
    public static String getCopyrights() {
        return COPYRIGHTS;
    }
}
