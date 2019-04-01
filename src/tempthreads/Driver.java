package tempthreads;
import org.apache.logging.log4j.*;

public class Driver {
    private static Logger logger = LogManager.getLogger(Driver.class);

    public static void main(String[] args) {
        logger.debug("Inside Thread Driver Main");

        Thread01 thread1 = new Thread01();
        Thread02 thread2 = new Thread02();

        //always call START , never call RUN!!
        thread1.start();
        thread2.start();


        logger.debug("Leaving Thread Driver Main");
    }
}
