package src.stringPrograms;

import src.dataStructures.queues.QueueUsingArray;
import src.dataStructures.stack.StackUsingLinkedList;

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

        System.out.println("Is Palindrome String:" + "hello" + " --> " + isPalindromeIgnoringPunctuationUsingStack("hello"));
        System.out.println("Is Palindrome String:" + "Don't Nod" + " --> " + isPalindromeIgnoringPunctuationUsingStack("Don't Nod"));
        System.out.println("Is Palindrome String:" + "I did!!! did I???" + " --> " + isPalindromeIgnoringPunctuationUsingStack("I did!!! did I???"));

        System.out.println("Is Palindrome String:" + "I did!!! did I???" + " --> " + isPalindromeIgnoringPunctuationUsingStackAndQueue("I did!!! did I???"));
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

    public static boolean isPalindromeIgnoringPunctuationUsingStack(String str)
    {
        if(str!=null && str.length()<=1)
        {
            return true;
        }
        StackUsingLinkedList stack = new StackUsingLinkedList();

        StringBuilder straightString = new StringBuilder();
        for (int i=0; i<str.length(); i++)
        {
            char chr = str.toLowerCase().charAt(i);
            if((chr >= 'a' && chr<='z')||(chr >= 'A' && chr<='Z'))
            {
                straightString.append(chr);
                stack.push(String.valueOf(chr));
            }
        }

        StringBuilder reverseString = new StringBuilder();

        while(stack.peek()!=null)
            reverseString.append(stack.pop());

        if(straightString.toString().equalsIgnoreCase(reverseString.toString()))
            return true;
        else
            return false;
    }

    public static boolean isPalindromeIgnoringPunctuationUsingStackAndQueue(String str)
    {
        if(str!=null && str.length()<=1)
        {
            return true;
        }
        StackUsingLinkedList stack = new StackUsingLinkedList();
        QueueUsingArray queue = new QueueUsingArray();

        StringBuilder straightString = new StringBuilder();
        for (int i=0; i<str.length(); i++)
        {
            char chr = str.toLowerCase().charAt(i);
            if((chr >= 'a' && chr<='z')||(chr >= 'A' && chr<='Z'))
            {
                straightString.append(chr);
                stack.push(String.valueOf(chr));
                queue.add(String.valueOf(chr));
            }
        }

        while(stack.peek()!=null)
        {
            if(!stack.pop().equalsIgnoreCase(queue.remove()))
                return false;
        }
        return true;
    }
}
