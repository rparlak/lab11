package pl.vistula.multithreads;

public class PriorityDemo {

    public static void main(String[] args) {
        int highPriorityWins = 0;

        for (int i = 0; i < 10; i++) {
            Priority mt1 = new Priority("High priority thread");
            Priority mt2 = new Priority("Thread with low priority");

            mt1.thread.setPriority(Thread.MAX_PRIORITY);
            mt2.thread.setPriority(Thread.MIN_PRIORITY);

            mt1.thread.start();
            mt2.thread.start();

            try {
                // Wait for threads to finish
                mt1.thread.join();
                mt2.thread.join();
            } catch (InterruptedException e) {
                System.out.println("The main thread was interrupted");
            }

            System.out.println("\nHigh priority thread counted to " + mt1.count);
            System.out.println("Low priority thread counted to " + mt2.count);

            if (mt1.count < mt2.count) {
                System.out.println("High priority thread finished first.");
                highPriorityWins++;
            } else {
                System.out.println("Low priority thread finished first.");
            }
        }

        System.out.println("\nHigh priority thread was the fastest " + highPriorityWins + " times out of 10.");
    }
}
