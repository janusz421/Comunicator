package server.exceptions;

/**
 * Exceptions genereating by server
 * @author Janusz Czornik
 * @version 1.0
 */
public class StandardServerException extends Exception{

    /**
     * Standard constructor
     */
    public StandardServerException() {
    }
    
    /**
     * Constructor with parametr
     * @param ex message for exception
     * @param errorCode enum error code
     */
    public StandardServerException(String ex, ErrorCode...errorCode) {
        super(ex);
        if(errorCode.length != 0)
            this.errorCode = errorCode[0].getErrorCode();
        else
            this.errorCode = ErrorCode.UNKNOWN_ERROR.getErrorCode();
    }
    
    /**
     * Returns error code
     * @return number of error
     */
    
    public int getErrorCode() {
        return errorCode;
    }
    
    /**
     * Enum type to handle server error codes
     */
    public enum ErrorCode {
        /**
         * Unknown error code
         */
        UNKNOWN_ERROR(0),
        /**
         * Wrong port number code
         */
        WRONG_PORT_NO(1), 
        /**
         * Server is running code
         */
        SERVER_RUNNING(2), 
        /**
         * Server is not running code
         */
        SERVER_NOT_RUNNING(3), 
        /**
         * Cannot close client socket code
         */
        CLOSING_CLIENT_SOCKET(4), 
        /**
         * Closing server socket code
         */
        CLOSING_SERVER_SOCKET(5);
        
        
        /**
         * Returns error code
         * @return code of error
         */
        private int getErrorCode() {
            return code;
        }
        
        /**
         * Standard constructor
         * @param code number of error
         */
        private ErrorCode(int code) {
            this.code = code;
        }
        
        /**
         * Error code
         */
        private final int code;
    }
    /**
     * Int value of error code
     */
    private int errorCode;
}
