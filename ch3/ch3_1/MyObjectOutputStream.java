package ch3.ch3_1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Created by zwb on 16/3/15.
 * 重写了writeStreamHeader方法,在写入头部时不做操作
 */

class MyObjectOutputStream extends ObjectOutputStream {
    public MyObjectOutputStream() throws IOException{
        super();
    }

    public MyObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException{
        return;
    }
}
