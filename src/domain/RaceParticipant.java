package domain;
import org.apache.logging.log4j.*;

import java.awt.*;
import java.util.Random;


public abstract class RaceParticipant{
    private static Logger logger = LogManager.getLogger(RaceParticipant.class);

    protected int topSpeed;
    protected int totalDistance;
    protected int sleepPercent;
    protected Random generator;

    public RaceParticipant(){
        logger.debug("inside race participant constructor");
        generator = new Random(System.currentTimeMillis());
    }
    public RaceParticipant(Random generator){
        logger.debug("inside race participant 1-arg constructor");
        this.generator = generator;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setSleepPercent(int sleepPercent) {
        this.sleepPercent = sleepPercent;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getSleepPercent() {
        return sleepPercent;
    }

    public abstract void paint(Graphics g, int y);

    public abstract void display();

    public abstract int sprint();
}
