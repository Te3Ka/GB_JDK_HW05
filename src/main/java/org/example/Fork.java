package org.example;

public class Fork {
    private int num;
    private volatile boolean busyNow = false;

    public Fork(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public boolean isBusyNow() {
        return busyNow;
    }

    public void setBusyNow(boolean busyNow) {
        this.busyNow = busyNow;
    }
}
