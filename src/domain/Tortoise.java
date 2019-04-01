package domain;
import org.apache.logging.log4j.*;

import java.awt.*;
import java.util.Random;

public class Tortoise extends RaceParticipant {

    public static void main(String[] args) {
        Tortoise bob = new Tortoise();

        do {
            bob.sprint();
            bob.display();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (bob.totalDistance < 60);
    }
    private static Logger logger = LogManager.getLogger(Tortoise.class);
    private static final int DEFAULT_START_DISTANCE = 0;
    private static final int DEFAULT_SLEEP_PERCENT = 15;
    private static final int DEFAULT_TOP_SPEED = 3;
    private static final String LONG_SPACES = "        ";


    public Tortoise(){
        super();
        logger.debug("inside Tortoise default constructor");
        setInternalAttributes(DEFAULT_START_DISTANCE, DEFAULT_SLEEP_PERCENT, DEFAULT_TOP_SPEED);
    }

    public Tortoise(int startingDistance){
        super();
        logger.debug("inside Tortoise constructor 1-arg");
        setInternalAttributes(startingDistance, DEFAULT_SLEEP_PERCENT, DEFAULT_TOP_SPEED);
    }

    public Tortoise(int startingDistance, int sleepPercent){
        super();
        logger.debug("inside Tortoise constructor 2-arg");
        setInternalAttributes(startingDistance, sleepPercent, DEFAULT_TOP_SPEED);
    }
    public Tortoise(int startingDistance, int sleepPercent, int topSpeed){
        super();
        logger.debug("inside Tortoise constructor 3-arg");
        setInternalAttributes(startingDistance, sleepPercent, topSpeed);
    }




    private void setInternalAttributes(int startingDistance, int sleepPercent, int topSpeed) {
        this.totalDistance = startingDistance;
        this.sleepPercent = sleepPercent;
        this.topSpeed = topSpeed;
    }


    public Tortoise(Random generator, int startingDistance){
        this(generator, startingDistance, DEFAULT_SLEEP_PERCENT, DEFAULT_TOP_SPEED);
        //super();
        logger.debug("inside Tortoise generator constructor 2-arg");
        //setInternalAttributes(startingDistance, DEFAULT_SLEEP_PERCENT, DEFAULT_TOP_SPEED);
    }

    public Tortoise(Random generator, int startingDistance, int sleepPercent){
        this(generator, startingDistance, sleepPercent, DEFAULT_TOP_SPEED);
        //super();
        logger.debug("inside Tortoise generator constructor 3-arg");
        //setInternalAttributes(startingDistance, sleepPercent, DEFAULT_TOP_SPEED);
    }
    public Tortoise(Random generator, int startingDistance, int sleepPercent, int topSpeed){
        super(generator);
        logger.debug("inside Tortoise generator constructor 4-arg");
        setInternalAttributes(startingDistance, sleepPercent, topSpeed);
    }



    @Override
    public void paint(Graphics g, int y) {
        //TORTOISE


        if (g != null)
        {
            g.setColor(Color.BLUE);
            g.fillArc(totalDistance, y, 20, 10, 0, 180);
            g.fillOval(totalDistance+17, y-3, 6, 6);
        }

    }

    @Override
    public void display() {
        //String fakeOutput = LONG_SPACES.substring(0, totalDistance);
        String space = " ";
        String output = String.format("%0" + totalDistance + "d", 0).replace("0", space) + "O~";
        //that last thing is supposed to be a tortoise lol
        System.out.println(output);
    }

    @Override
    public int sprint() {
        int sleep = generator.nextInt(100);
        int sprintDistance = 0;

        if(sleep > sleepPercent)
        {
            //this means he's sprinting not sleeping
            sprintDistance = generator.nextInt(topSpeed) + 1;
        }
        totalDistance += sprintDistance;

        return sprintDistance;
    }
}
