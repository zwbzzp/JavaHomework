package ch3.ch3_1;

/**
 * Created by zwb on 16/3/14.
 */
public class CreateSequentialFileTest {
    public static void main(String[] args)
    {
        CreateSequentialFileTest test = new CreateSequentialFileTest();
//        test.addStudents();
        //根据学号改变对象内容
        test.updateStudents("1213132");
        test.readStudents();
//        String s = new String("hello");
//        String s1 = "hello";
//        System.out.println(s.equals("hello"));
    }

    public void addStudents()
    {
        CreateSequentialFile app = new CreateSequentialFile();
        app.openOutputFile(true);
        app.addStudents();
        app.closeOutputFile();
    }

    public void readStudents()
    {
        CreateSequentialFile app = new CreateSequentialFile();
        app.openInputFile();
        app.readStudents();
        app.closeInputFile();
    }


    public void updateStudents(String id)
    {
        CreateSequentialFile app = new CreateSequentialFile();
        app.openInputFile();
        app.updateStudents(id);
        app.closeInputFile();
    }
}
