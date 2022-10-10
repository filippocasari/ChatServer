package Assignment1.exercise3;


public class SpawningThreads {

    private int num_threads;


    public SpawningThreads(int num_threads) {

        this.num_threads = num_threads;

    }

    public void startSpawning() throws InterruptedException {
        Thread[] Threads = new Thread[num_threads];
        for (int i = 0; i < num_threads; i++) {

            Runnable UserthreadFriend = new UserthreadFriend();
            Threads[i] = new Thread(UserthreadFriend);
            Threads[i].start();

        }
        for (int i = 0; i < num_threads; i++) {

            Threads[i].join();

        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num_threads;
        try {
            if (args.length == 1) {

                num_threads = Integer.parseInt(args[0]);
                if (num_threads > 100) {
                    System.err.println("Okay, but too many threads for this purpose");
                    return;
                } else if (num_threads < 1) {
                    System.err.println("Okay, but too few threads for this purpose");
                    return;
                }
            } else {
                num_threads = 3;
            }
        } catch (NumberFormatException nfe) {
            System.err.println("error! Insert a number, not somewhat else");
            return;
        }

        SpawningThreads spawningThreads = new SpawningThreads(num_threads);
        spawningThreads.startSpawning();
    }
}
