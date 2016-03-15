package ch3.ch3_1;

/**
 * Created by zwb on 16/3/14.
 */
public class ValidateStudent
{
    public static boolean validateStudentId(String studentId)
    {
        return studentId.matches("\\d*8");
    }

    public static boolean validateBirth(String birth)
    {
        return birth.matches("(\\d{4}-03-\\d{2})");
    }
}
