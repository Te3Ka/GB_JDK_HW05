package org.example;

import java.util.Random;

public class Philosopher extends Thread {
    private final String namePhilosopher;
    private int satiety = 3;
    private boolean eatingNow = false;
    private final Fork leftFork;
    private final Fork rightFork;
    Random random = new Random();

    public String getNamePhilosopher() {
        return namePhilosopher;
    }

    public Philosopher(String namePhilosopher, Fork leftFork, Fork rightFork) {
        this.namePhilosopher = namePhilosopher;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            sleep(random.nextInt(500, 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (eatingNow) {
            try {
                reflection();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        while (satiety > 0) {
            if (!leftFork.isBusyNow() && !rightFork.isBusyNow() && !eatingNow) {
                try {
                    eating();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    reflection();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(getNamePhilosopher() + " наелся и покидает стол.");
    }

    public void eating() throws InterruptedException {
        leftFork.setBusyNow(true);
        rightFork.setBusyNow(true);
        System.out.println(getNamePhilosopher() + " ест лапшу. Использует вилки "
                + leftFork.getNum() + " и " + rightFork.getNum());
        satiety--;
        eatingNow = true;
        sleep(random.nextInt(1000, 3000));
        leftFork.setBusyNow(false);
        rightFork.setBusyNow(false);
        System.out.println(getNamePhilosopher() + " кладёт вилки "
                + leftFork.getNum() + " и " + rightFork.getNum() + " на стол.");
    }

    public void reflection() throws InterruptedException {
        System.out.println(getNamePhilosopher() + " предаётся размышлениям.");
        if (eatingNow) {
            eatingNow = false;
        }
        sleep(random.nextInt(500, 2000));
    }
}
