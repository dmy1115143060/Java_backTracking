package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 利用回溯法求出一个字符串的的回文子串，并且保证这些回文子串可以构成原串
 */
public class Palindrome_Partitioning_131
{
    //利用Set来保存不同的回文子串组合序列
    private static List<List<String>> result = new ArrayList<>();
    private static String source = "abba";

    public static void main(String[] args)
    {
        backTrack(0, source, getPalindromeStr(source), new ArrayList<>());
        System.out.println("=======================================");
        for(List<String> l : result)
            System.out.println(l);
    }

    /**
     * @param start
     * @param palindromeList:保存所有的字符串的所有的子回文串
     * @param list：保存当前符合要求的子回文串
     */
    public static void backTrack(int start, String str, List<String> palindromeList, List<String> list)
    {
        for(int i = start; i < palindromeList.size(); i++)
        {
            if(list.size() < str.length() && str.startsWith(getStr(list)))
            {
                list.add(palindromeList.get(i));
                if(getStr(list).equals(str))
                    if(!result.contains(list))
                        result.add(new ArrayList<>(list));
                backTrack(start, str, palindromeList, list);
                list.remove(list.size() - 1);
            }
            else
                return;
        }
    }

    /**
     * 按照从前往后获取一个字符串的所有可能回文子串
     */
    public static List<String> getPalindromeStr(String str)
    {
        List<String> palindromeList = new ArrayList<>();

        for(int i = 0; i < str.length(); i++)
        {
            String s = Character.toString(str.charAt(i));
            if(!palindromeList.contains(s))
                palindromeList.add(s);
        }

        for(int i = 1; i < str.length(); i++)
            for(int j = i + 1; j <= str.length(); j++)
            {
                String s = str.substring(i, j);
                if(isPalindrome(s) && !palindromeList.contains(s))
                    palindromeList.add(s);

            }
        return palindromeList;
    }

    public static String getStr(List<String> list)
    {
        String str = "";
        for(String s : list)
            str += s;
        return str;
    }

    /**
     * 判断一个字符串是否是回文串
     */
    public static boolean isPalindrome(String str)
    {
        for(int i = 0, j = str.length()-1; i <= j; i++, j--)
        {
            if(str.charAt(i) != str.charAt(j))
               return false;
        }
        return true;
    }
}
