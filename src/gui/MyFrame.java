package gui;

import org.apache.logging.log4j.*;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private static Logger logger = LogManager.getLogger(MyFrame.class);
    private Graphics g;

    public MyFrame() {
        logger.debug("inside myframe constructor ertplusysevensixp");

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.g = g;
        logger.debug("inside myframe paint no homo");


        logger.debug("about to call doit no homo");

        DOIT();

        logger.debug("back from doit no homo");


    }

    public void DOIT(){
        logger.debug("inside myframe DOIT also no homo");
        g.setColor(Color.BLACK);
        for (int x = 0; x<this.getWidth(); x += 20){
            logger.debug("draw circle at " + x);
            try {
                Thread.sleep(550);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            g.drawOval(x, 200, 20, 20);
        }

    }
}
