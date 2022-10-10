package Assignment1.exercise3;

import java.util.Random;

import static java.lang.Thread.sleep;

public class UserthreadFriend implements Runnable {
    private String id = null;
    private final int max = 1000;
    private final int min = 0;

    public UserthreadFriend() {
        Random r = new Random();
        this.id = String.valueOf(r.nextInt((max - min) + 1) + min);

    }

    public void sayGoodBye() throws InterruptedException {
        Random r = new Random();


        //this.notifyAll();
        System.out.println("thread " + this.id + " this side. Good bye User!");
    }

    @Override
    public void run() {

        System.out.println("Hi kiddo, I am the thread " + this.id);
        Random r = new Random();
        int millisec = r.nextInt((4000 - min) + 1) + min;
        try {
            System.out.println("Here thread " + this.id + "! waiting " + millisec + " milliseconds until I will finish");
            sleep(millisec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            this.sayGoodBye();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
