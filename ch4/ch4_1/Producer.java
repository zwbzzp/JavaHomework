package ch4.ch4_1;

import java.util.Random;

/**
 * Created by zwb on 16/3/17.
 */
public class Producer implements Runnable{
    //final修饰引用类型的变量时,变量无法指向其他对象
    private final static Random generator = new Random();
    private final Buffer sharedLocation;

    public Producer(Buffer shared)
    {
        sharedLocation = shared;
    }

    public void run()
    {
        int sum = 0;
        for(int count=1; count<=10; count++)
        {
            try {
                Thread.sleep(generator.nextInt(3000));
                sharedLocation.set(count);
                sum += count;
//                System.out.printf("\t%2d\n",sum);
            }
            catch (InterruptedException exception)
            {
                exception.printStackTrace();
            }
        }
        System.out.println("Producer done producing\nTerminating Prodeuce");
    }
}
