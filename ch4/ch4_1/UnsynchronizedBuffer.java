package ch4.ch4_1;

/**
 * Created by zwb on 16/3/17.
 */
public class UnsynchronizedBuffer implements Buffer {
    private int buffer = 0;

    public void set(int value) throws InterruptedException
    {
        System.out.printf("Producer writes\t%2d",value);
        buffer = value;
    }

    public int get() throws InterruptedException
    {
        System.out.printf("Consumer reads\t%2d",buffer);
        return buffer;
    }
}
