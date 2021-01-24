package priv.lyb.study.base.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author LiuYingBo 2021/01/24 15:08
 */
class LoggingException extends Exception {
    private Logger logger = Logger.getLogger("Exception");

    LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

}

public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught err " + e);
//            System.out.println("----------------------");
            System.out.println("Caught out " + e);
        }

//        try {
//            throw new LoggingException();
//        } catch (LoggingException e) {
//            System.err.println("Caught" + e);
//        }
    }
}
