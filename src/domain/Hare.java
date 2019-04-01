package domain;
import org.apache.logging.log4j.*;

import java.awt.*;
import java.util.Random;

public class Hare extends RaceParticipant{

    public static void main(String[] args) {
        Hare bob = new Hare();

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
    private static Logger logger = LogManager.getLogger(Hare.class);
    private static final int DEFAULT_START_DISTANCE = 1;
    private static final int DEFAULT_SLEEP_PERCENT = 65;
    private static final int DEFAULT_TOP_SPEED = 8;
    private static final String LONG_SPACES = "        ";


    public Hare(){
        super();
        logger.debug("inside Hare default constructor");
        setInternalAttributes(DEFAULT_START_DISTANCE, DEFAULT_SLEEP_PERCENT, DEFAULT_TOP_SPEED);
    }

    public Hare(int startingDistance){
        super();
        logger.debug("inside Tortoise constructor 1-arg");
        setInternalAttributes(startingDistance, DEFAULT_SLEEP_PERCENT, DEFAULT_TOP_SPEED);
    }

    public Hare(int startingDistance, int sleepPercent){
        super();
        logger.debug("inside Tortoise constructor 2-arg");
        setInternalAttributes(startingDistance, sleepPercent, DEFAULT_TOP_SPEED);
    }
    public Hare(int startingDistance, int sleepPercent, int topSpeed){
        super();
        logger.debug("inside Tortoise constructor 3-arg");
        setInternalAttributes(startingDistance, sleepPercent, topSpeed);
    }




    private void setInternalAttributes(int startingDistance, int sleepPercent, int topSpeed) {
        this.totalDistance = startingDistance;
        this.sleepPercent = sleepPercent;
        this.topSpeed = topSpeed;
    }


    public Hare(Random generator, int startingDistance){
        this(generator, startingDistance, DEFAULT_SLEEP_PERCENT, DEFAULT_TOP_SPEED);
        //super();
        logger.debug("inside Tortoise generator constructor 2-arg");
        //setInternalAttributes(startingDistance, DEFAULT_SLEEP_PERCENT, DEFAULT_TOP_SPEED);
    }

    public Hare(Random generator, int startingDistance, int sleepPercent){
        this(generator, startingDistance, sleepPercent, DEFAULT_TOP_SPEED);
        //super();
        logger.debug("inside Tortoise generator constructor 3-arg");
        //setInternalAttributes(startingDistance, sleepPercent, DEFAULT_TOP_SPEED);
    }
    public Hare(Random generator, int startingDistance, int sleepPercent, int topSpeed){
        super(generator);
        logger.debug("inside Tortoise generator constructor 4-arg");
        setInternalAttributes(startingDistance, sleepPercent, topSpeed);
    }



    @Override
    public void paint(Graphics g, int y) {
        //HARE


        if (g != null)
        {
            g.setColor(Color.BLUE);
            g.fillOval(totalDistance, y, 10, 10);
            g.fillOval(totalDistance+3, y-7, 4, 10);
            g.fillOval(totalDistance+7, y-7, 4, 10);
        }

    }

    @Override
    public void display() {
        //String fakeOutput = LONG_SPACES.substring(0, totalDistance);
        String space = " ";
        String output = String.format("%0" + totalDistance + "d", 0).replace("0", space) + "\\/";
        //that last thing is supposed to be a hare lol
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

