package Race;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {
    private static int CARS_ID;
    static {
        CARS_ID = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cb;
    private int countStages = 0;
    private AtomicBoolean isWinner;
    private CountDownLatch cdStart;
    private CountDownLatch cdFinish;
    private Date date = new Date();
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cb, AtomicBoolean isWinner, CountDownLatch start, CountDownLatch finish) {
        this.race = race;
        this.speed = speed;
        CARS_ID++;
        this.name = "Участник #" + CARS_ID;
        this.cb = cb;
        this.isWinner = isWinner;
        cdStart = start;
        cdFinish = finish;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdStart.countDown();
            cb.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            if(race.getStages().get(i).checkStage()) countStages++;
            if (countStages == 3 && !isWinner.get()) {
                System.out.println(this.name + " " + date.toString());
                System.out.println(this.name + " - WIN");
                isWinner.set(true);
            }
            cdFinish.countDown();
        }
    }
}
