package src.stringPrograms;

public class ReverseString {

    public static void main(String[] args)
    {
        String s1 = "abcdef";
        String s2 = "abcde";
        System.out.println("String s1:"+s1);
        System.out.println("Reversed String s1:"+ reverseString(s1));
        System.out.println("Reversed String using char array s1:"+ reverseStringUsingCharArray(s1));

        System.out.println("String s2:"+s2);
        System.out.println("Reversed String s2:"+ reverseString(s2));
        System.out.println("Reversed String using char array s2:"+ reverseStringUsingCharArray(s2));
    }

    //O(n)
    public static String reverseString(String str)
    {
        if(str!=null && str.length()<=1)
        {
            return str;
        }

        String revStr=""; // can use string builder as well

        for(int i=str.length()-1; i>=0; i--)
        {
            revStr = revStr + str.charAt(i);
        }
        return revStr;
    }

    //O(n/2)
    public static String reverseStringUsingCharArray(String str)
    {
        if(str!=null && str.length()<=1)
        {
            return str;
        }
        char[] charArray = str.toCharArray();

        for (int i=0, j=charArray.length-1; i < charArray.length/2; i++,j--)
        {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return String.valueOf(charArray);
    }

    public static String reverseStringUsingStringBuilder(String str)
    {
        if(str!=null && str.length()<=1)
        {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);

        return sb.reverse().toString();
    }
}
