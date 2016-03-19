package ch4.ch4_1;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zwb on 16/3/18.
 */
public class BlockingBuffer implements Buffer {
    private final ArrayBlockingQueue<Integer> buffer;

    public BlockingBuffer()
    {
        buffer = new ArrayBlockingQueue<Integer>(3);//handles synchronized automatically
    }

    public void set(int value) throws InterruptedException
    {
        buffer.put(value);
        System.out.printf("%s%2d\t%s%d\n","Producer writes ",value,"Buffer cells occupied: ",buffer.size());
    }

    public int get() throws InterruptedException
    {
        int readValue = buffer.take();//remove value from buffer
        System.out.printf("%s %2d\t%s%d\n", "Consumer reads ",readValue,"Buffer cells occupied: ",buffer.size());
        return readValue;
    }
}
