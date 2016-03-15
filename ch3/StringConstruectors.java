package ch3;

import java.lang.ref.SoftReference;

/**
 * Created by zwb on 16/3/11.
 */
public class StringConstruectors {
    public static void main(String[] args){

//        char[] charArrary = {'b', 'i', 'r', 't', 'h', ' ', 'd', 'a', 'y'};
//        String s = new String("hello");
//
//        //use String constructors
//        String s1 = new String();
//        String s2 = new String(s);
//        String s3 = new String(charArrary);
//        String s4 = new String(charArrary,6,3);
//
//        System.out.printf("s1=%s\ns2=%s\ns3=%s\ns4=%s\n",s1,s2,s3,s4);



//        String s1 = "hello there";
//        char[] charArray = new char[5];
//        //获取长度
//        System.out.println(s1.length());
//
//        System.out.println(s1.charAt(4));
//        //第四个参数为存储在数组中的首位置
//        s1.getChars(0,4,charArray,1);
//        for(char ch:charArray)
//            System.out.print(ch);


        //StringCompare
//        String s1 = new String("hello");
//        String s5 = new String("hello");
//        String s2 = "goodbye";
//        String s3 = "happy birthday";
//        String s4 = "Happy Birthday";
//        if(s1.equals("hello"))
//            System.out.println("s1 equals \"hello\"");
//        else
//            System.out.println("not equal");
//
//        if(s1=="hello")
//            System.out.println("true");
//        else
//            System.out.println("false");
//
//        if(s1.equals(s5))
//            System.out.println("true");
//
//        if(s1==s5)
//            System.out.println("true");



        String s = "abcdefghijklmnabcddeffer";
        System.out.println(s.substring(3,7));
        System.out.println(s.indexOf('e'));
        System.out.println(s.lastIndexOf('e'));
        System.out.println(s.substring(22));
        StringBuilder s1 = new StringBuilder("cwecweferfcer");
        System.out.println(s1.capacity());
        System.out.println(s1.length());
        System.out.println(s1.reverse());
        System.out.println(Character.isJavaIdentifierPart('b'));
        String[] str = s.split("d");
        for(String token:str)
            System.out.println(token);
    }
}
