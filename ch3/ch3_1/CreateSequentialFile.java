package ch3.ch3_1;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Created by zwb on 16/3/14.
 */
public class CreateSequentialFile
{
    private ObjectInputStream input;
    private ObjectOutputStream output;


    //输出对象到文件操作
    public void openOutputFile(boolean methods)
    {
        try {
            File f = new File("student.ser");
//            System.out.println(f.length());
            //FileOutputStream构造函数默认第二个参数为false,覆盖文件;true为append
            FileOutputStream fs = new FileOutputStream(f, methods);
//            System.out.println(f.length());
            //如果是第一次写入,正常操作,如果非第一次写入,调用自定义方法
            if(f.length()<1){
                System.out.println("Empty file.");
                output = new ObjectOutputStream(fs);
            }
            else{
                System.out.println("Non-empty file.");
                output = new MyObjectOutputStream(fs);
            }

        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file.");
        }
    }


    public void addStudents()
    {
        StudentSerializable student;
        String studentId;
        String name;
        String birth;

        Scanner input = new Scanner(System.in);
        System.out.printf("%s\n%s\n%s\n\n",
                "To terminate input,type the end-of-file indicator",
                "when you are promoted to enter input.",
                "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
                "On Windows type <ctrl> z then press Enter");

        System.out.printf("%s\n%s",
                "Enter studentId, name, birth.",
                "?");

        while (input.hasNext())
        {
            try {
                studentId = input.next();
                name = input.next();
                birth = input.next();

                student = new StudentSerializable(studentId, name, birth);
                output.writeObject(student);
            }
            catch (IOException ioException)
            {
                System.out.println("Error writing to file");
                return;
            }
            catch (NoSuchElementException elementException)
            {
                System.out.println("Invalid input. Please try again.");
                input.next();
            }

            System.out.printf("%s\n%s",
                    "Enter studentId, name, birth.", "?");
        }
    }


    public void closeOutputFile()
    {
        try {
            if(output != null)
                output.close();
            System.out.println("Close successfully.");
        }
        catch (IOException ioException)
        {
            System.out.println("Error closing file.");
            System.exit(1);
        }
    }

    //从文件读入对象操作
    public void openInputFile()
    {
        try {
            input = new ObjectInputStream(new FileInputStream("student.ser"));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file");
        }
    }

    public void readStudents()
    {
        StudentSerializable student = new StudentSerializable();
        System.out.printf("%-15s%-15s%-15s\n","StudentId", "Name", "Birthday");

        try {
            while (true)
            {
                student = (StudentSerializable) input.readObject();
                String id = student.getStudentId();
                String name = student.getName();
                String bir = student.getBirth();
//                if(ValidateStudent.validateStudentId(id)&&ValidateStudent.validateBirth(bir))
//                {
//                    System.out.printf("%-15s%-15s%-15s\n",
//                            student.getStudentId(), student.getName(), student.getBirth());
//                }
                System.out.printf("%-15s%-15s%-15s\n",
                        student.getStudentId(), student.getName(), student.getBirth());
            }
        }
        catch (EOFException endOfFileException)
        {
            return;
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            System.out.println("Unable to create object.");
        }
        catch (IOException ioException)
        {
            System.out.println("Error during read from file.");
        }
    }

    public void updateStudents(String id)
    {
        StudentSerializable student = new StudentSerializable();
        ArrayList<StudentSerializable> lists = new ArrayList();
        boolean methods = false;
        try {
            while (true) {
                student = (StudentSerializable) input.readObject();
//                System.out.println(student.getStudentId().equals(id));
                if (student.getStudentId().equals(id)) {
                    student.setName("zwbb");
                }
                lists.add(student);
            }
        }

        catch (EOFException e){
            return;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            openOutputFile(false);
            for(StudentSerializable list:lists)
            {
                try {
                    output.writeObject(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            closeOutputFile();
        }
    }

    public void closeInputFile(){
        try {
            if(input != null)
                input.close();
            System.out.println("Close successfully.");
        }
        catch (IOException ioException)
        {
            System.out.println("Error closing file.");
            System.exit(1);
        }
    }
}
