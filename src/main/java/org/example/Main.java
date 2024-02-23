package org.example;

//TIP Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
// Вилки лежат на столе между каждой парой ближайших философов.
// Каждый философ может либо есть, либо размышлять.
// Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
// Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать).
public class Main {
    public static void main(String[] args) {
        Fork[] forks = new Fork[5];
        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork(i);
        }
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                philosophers[i] = new Philosopher("Философ №" + i, forks[4], forks[0]);
            } else {
                philosophers[i] = new Philosopher("Философ №" + i, forks[i - 1], forks[i]);
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(philosophers[i].getNamePhilosopher() + " сел за стол.");
            philosophers[i].start();
        }

    }
}