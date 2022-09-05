package src.geeksForGeeksProblems.easy;

import src.dataStructures.queues.QueueUsingArray;
import src.dataStructures.stack.StackUsingLinkedList;

import java.util.HashMap;
import java.util.Map;

public class StringProblems {

    public static void main(String[] args)
    {
        // reverse string
        String s1 = "abcdef";
        System.out.println("String s1:"+s1);
        System.out.println("Reversed String s1:"+ reverseString(s1));
        System.out.println("Reversed String using char array s1:"+ reverseStringUsingCharArray(s1));

        String s2 = "abcde";
        System.out.println("String s2:"+s2);
        System.out.println("Reversed String s2:"+ reverseString(s2));
        System.out.println("Reversed String using char array s2:"+ reverseStringUsingCharArray(s2));

        // palindrome
        System.out.println("Is Palindrome String:" + "hello" + " --> " + isPalindromeIgnoringPunctuationUsingStack("hello"));
        System.out.println("Is Palindrome String:" + "Don't Nod" + " --> " + isPalindromeIgnoringPunctuationUsingStack("Don't Nod"));
        System.out.println("Is Palindrome String:" + "I did!!! did I???" + " --> " + isPalindromeIgnoringPunctuationUsingStack("I did!!! did I???"));
        System.out.println("Is Palindrome String:" + "I did!!! did I???" + " --> " + isPalindromeIgnoringPunctuationUsingStackAndQueue("I did!!! did I???"));

        // find last index of 1
        String s = "111111";
        System.out.println(lastIndex(s));

        //Function to locate the occurrence of the string x in the string s.
        System.out.println(strstr("ccdeecbdfedcbabfdfaebdaf", "fecfacbccfe"));
        System.out.println(strstrSpaceOptimized("GeeksForGeeks", "For"));

        //Anagram of String
        System.out.println("Anagram:"+ remAnagrams("basgadhbfgvhads","sjdhgvbjdsbhvbvd"));
    }

    public static int remAnagrams(String s,String s1)
    {
        //add code here.
        int[] countArray= new int[26];

        for (char c : s.toCharArray()) {
            countArray[c - 'a']++;
        }

        for (char c : s1.toCharArray()) {
            countArray[c - 'a']--;
        }

        int count = 0;
        for(int i=0; i<26; i++)
            count = count + Math.abs(countArray[i]);
        return count;
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

    public static int lastIndex( String s) {
        char[] chars = s.toCharArray();
        for (int i=chars.length-1; i >= 0 ; i--) {
            if(chars[i] == '1')
                return i;
        }
        return -1;
    }

    //Function to locate the occurrence of the string x in the string s.
    // Time - O(s*x), Space - O(s+x)
    public static int strstr(String s, String x)
    {
        char[] charS = s.toCharArray();
        char[] charX = x.toCharArray();

        for(int i=0; i<charS.length; i++)
        {
            if(charS[i]==charX[0])
            {
                boolean matchFound=true;
                for(int z=1,j=i+1; z<charX.length; z++,j++)
                {
                    if(j>=charS.length || charX[z]!=charS[j])
                    {
                        matchFound=false;
                        break;
                    }
                }

                if(matchFound)
                {
                    return i;
                }
            }
        }
        return -1;
    }

    //Time is O(s*x),, Space O(1)
    public static int strstrSpaceOptimized(String s, String x)
    {
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)==x.charAt(0))
            {
                boolean matchFound=true;
                for(int z=1,j=i+1; z<x.length(); z++,j++)
                {
                    if(j>=s.length() || x.charAt(z)!=s.charAt(j))
                    {
                        matchFound=false;
                        break;
                    }
                }

                if(matchFound)
                {
                    return i;
                }
            }
        }
        return -1;
    }
}
