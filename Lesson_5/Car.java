package Lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
  private static int CARS_COUNT;
  private static int place = 1;

  static {
    CARS_COUNT = 0;
  }

  private Race race;
  private int speed;
  private String name;
  private CyclicBarrier barrier;
  private int myPlace;

  public String getName() {
    return name;
  }

  public int getSpeed() {
    return speed;
  }

  public int getMyPlace() {
    return myPlace;
  }

  public Car(Race race, int speed, CyclicBarrier barrier) {
    this.race = race;
    this.speed = speed;
    this.barrier = barrier;
    CARS_COUNT++;
    this.name = "Участник #" + CARS_COUNT;
  }

  private synchronized void placeMe() {
    myPlace = place++;
  }

  @Override
  public void run() {
    try {
      System.out.println(this.name + " готовится");
      Thread.sleep(500 + (int) (Math.random() * 800));
      System.out.println(this.name + " готов");
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      barrier.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < race.getStages().size(); i++) {
      race.getStages().get(i).go(this);
    }
    placeMe();
    System.out.println(this.name + " занимает " + myPlace + " место!");
  }
}
