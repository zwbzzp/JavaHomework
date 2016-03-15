package ch3.ch3_1;

import java.io.Serializable;

/**
 * Created by zwb on 16/3/14.
 */
public class StudentSerializable implements Serializable
{
    private String studentId;
    private String name;
    private String birth;

    public StudentSerializable()
    {
        this("","","");
    }

    public StudentSerializable(String s, String s1, String s2)
    {
        setStudentId(s);
        setName(s1);
        setBirth(s2);

    }

    public void setStudentId(String id)
    {
        this.studentId = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setBirth(String birth)
    {
        this.birth = birth;
    }

    public String getStudentId()
    {
        return this.studentId;
    }

    public String getName()
    {
        return this.name;
    }

    public String getBirth()
    {
        return this.birth;
    }
}
