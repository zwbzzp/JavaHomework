package ch3.ch3_1;

/**
 * Created by zwb on 16/3/14.
 */
public class CreateSequentialFileTest {
    public static void main(String[] args)
    {
        CreateSequentialFileTest test = new CreateSequentialFileTest();
//        test.addStudents();
        test.readStudents();
    }

    public void addStudents()
    {
        CreateSequentialFile app = new CreateSequentialFile();
        app.openOutputFile();
        app.addStudents();
        app.closeOutputFile();
    }

    public void readStudents()
    {
        CreateSequentialFile app = new CreateSequentialFile();
        app.openInputFile();
        app.readStudents();;
        app.closeInputFile();
    }
}
