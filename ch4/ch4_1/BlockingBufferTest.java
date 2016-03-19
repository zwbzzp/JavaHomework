package ch4.ch4_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zwb on 16/3/18.
 */
public class BlockingBufferTest {
    public static void main(String[] args)
    {
        ExecutorService app = Executors.newCachedThreadPool();
        Buffer shareLocation = new BlockingBuffer();

        app.execute(new Producer(shareLocation));
        app.execute(new Consumer(shareLocation));

        app.shutdown();

    }
}
