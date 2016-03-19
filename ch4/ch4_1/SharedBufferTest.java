package ch4.ch4_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zwb on 16/3/17.
 */
public class SharedBufferTest {
    public static void main(String[] args)
    {
        ExecutorService app = Executors.newCachedThreadPool();

        Buffer shareLocation = new UnsynchronizedBuffer();

        System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
        System.out.println("------\t\t-----\t---------------\t---------------\n");

        app.execute(new Producer(shareLocation));
        app.execute(new Consumer(shareLocation));

        app.shutdown();
    }
}
