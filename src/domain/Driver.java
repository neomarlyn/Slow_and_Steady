package domain;

public class Driver extends Thread{
    public static void main(String[] args) {
        //Thread thread01 = bobsRace();
        //Thread thread02 = joesRace();
        Hare bob = new Hare();
        Tortoise joe = new Tortoise();
        do {
            bob.sprint();
            bob.display();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            {
                joe.sprint();
                joe.display();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("-------------------------------------------------------------------------------------");


    }while (bob.totalDistance < 60 && joe.totalDistance < 60);
        if (joe.totalDistance > bob.totalDistance){
            System.out.println("Joe the Tortoise wins!");
        }
        else{
            System.out.println("Bob the Hare wins!");
        }
    /*public static Thread bobsRace(){
        Hare bob = new Hare();
        Tortoise joe = new Tortoise();
        do {
            bob.sprint();
            bob.display();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            {
                joe.sprint();
                joe.display();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        } while (bob.totalDistance < 60);
        return thread01().stop;
    }
    public static Thread joesRace() {
        Tortoise joe = new Tortoise();
        do {
            joe.sprint();
            joe.display();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (joe.totalDistance < 60);
        joesRace().stop();*/
    }
}
