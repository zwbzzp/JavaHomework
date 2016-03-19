package ch4.ch4_2;

/**
 * Created by zwb on 16/3/19.
 */
public class Authors {
    private int ID;
    private String firstName;
    private String lastName;

    public Authors()
    {
        this.ID=0;
        this.firstName="";
        this.lastName="";

    }

    public Authors(int id, String firstName, String lastName) {
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId()
    {
        return ID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setId(int id)
    {
        this.ID = id;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

}
