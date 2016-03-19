package ch4.ch4_1;

/**
 * Created by zwb on 16/3/17.
 */
public interface Buffer {
    public void set(int value)throws InterruptedException;
    public int get() throws InterruptedException;
}
