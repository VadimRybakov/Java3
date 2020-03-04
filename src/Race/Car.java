package Race;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_ID;
    static {
        CARS_ID = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cb;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cb) {
        this.race = race;
        this.speed = speed;
        CARS_ID++;
        this.name = "Участник #" + CARS_ID;
         this.cb = cb;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }
}
