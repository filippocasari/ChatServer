package Assignment1.exercise3;

import java.util.Random;


public class SpawingThreads {

    private final int num_threads= 3;


    public SpawingThreads() throws InterruptedException {
        Thread[] Mythreads = new Thread[num_threads];
        for(int i =0; i < num_threads; i++){

            Runnable UserthreadFriend = new UserthreadFriend();
            Mythreads[i] = new Thread(UserthreadFriend);
            Mythreads[i].start();


        }
        for(int i =0; i < num_threads; i++){

            Mythreads[i].join();

        }



    }

    public static void main(String[] args) throws InterruptedException {
        SpawingThreads spawingThreads = new SpawingThreads();
    }
}
