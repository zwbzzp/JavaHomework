package ch4.ch4_1;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zwb on 16/3/18.
 */
public class CircularBuffer implements Buffer {
    private final ArrayBlockingQueue<Integer> buffer;
    //限制buffer池的容量为3
    private final int capacity = 3;

    public CircularBuffer()
    {
        buffer = new ArrayBlockingQueue<Integer>(capacity);
    }

    public void displayState(String operation)
    {
        System.out.printf("%-40s\t\t%d\n\n", operation, buffer.size());
    }

    //place value into buffer
    public synchronized void set(int value) throws InterruptedException{
        while (buffer.size()>=capacity)
        {
            System.out.println("Producer tries to write.");
            displayState("Buffer full.Producer waits.");
            wait();
        }

        buffer.put(value);
        displayState("Producer writes "+value);
        notifyAll();//tell waiting threads to enter runnable state

    }

    //return value from buffer
    public synchronized int get() throws InterruptedException
    {
        while (buffer.isEmpty())
        {
            System.out.println("Consumer tries to read.");
            displayState("Buffer empty.Consumer waits.");
            wait();
        }

        int readValue  = buffer.take();
        displayState("Consumer reads "+readValue);
        notifyAll();
        return readValue;
    }


}
