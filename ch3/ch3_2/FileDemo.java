package ch3.ch3_2;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Scanner;
import java.util.logging.ErrorManager;

/**
 * Created by zwb on 16/3/14.
 */
public class FileDemo
{
    private BufferedInputStream input;
    private BufferedOutputStream output;
    public static void main(String[] args)
    {
        String inPath = "/Users/zwb/IdeaProjects/JavaHomework/src/ch3/ch3_1";
        String outPath = "/Users/zwb/IdeaProjects/JavaHomework/src/ch3/ch3_3";
        FileDemo f = new FileDemo();
        f.copyJavaFile(inPath, outPath);
    }

    public void copyJavaFile(String fromPath, String toPath)
    {
        File name = new File(fromPath);
        if(name.exists())
        {
            if(name.isDirectory())
            {
//                String[] directory = name.list();
                File[] files = name.listFiles();
                for(File file:files)
                {
                    if(file.isFile())
                    {
                        String fileName = file.getName();
                        String pathName = toPath+File.separator+fileName.replaceAll(".java",".j");
                        if(fileName.endsWith(".java"))
                        {
                            System.out.println(fileName);
                            File dest = new File(pathName);
                            File destPar = dest.getParentFile();
                            if(!destPar.exists())
                                destPar.mkdirs();
                            if(!dest.exists())
                            {
                                try {
                                    dest.createNewFile();
                                }
                                catch (IOException ioException){
                                    System.out.println("Unable to create new file.");
                                }
                            }
                            copyFile(file,dest);

                        }
                    }

                }
            }

        }
    }

    public void copyFile(File src, File dest)
    {
        try {
            input = new BufferedInputStream(new FileInputStream(src));
            output = new BufferedOutputStream(new FileOutputStream(dest));
            byte[] buffer = new byte[input.available()];
            while (input.read(buffer)!= -1)
            {
                output.write(buffer);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            closeInputFile();
            closeOutput();
        }
    }

    public void closeInputFile()
    {
        try {
            if(input!=null){
                input.close();
                System.out.println("Close successfully.");
            }
        }catch (IOException ioExcption)
        {
            System.out.println("Error closing a file.");
        }
    }

    public void closeOutput()
    {
        try {
            if(output!=null){
                output.close();
                System.out.println("Close successfully.");
            }
        }catch (IOException e){
            System.out.println("Error closing a file");
        }
    }
}
