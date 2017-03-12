package LeetCode.BackTrack;


import java.util.ArrayList;
import java.util.List;
/**
 * 利用回溯法求出一个字符串的的回文子串，并且保证这些回文子串可以构成原串
 *  Given a string s, partition s such that every substring of the partition is a palindrome.
    Return all possible palindrome partitioning of s.
    For example, given s = "aab",
    Return
    [
        ["aa","b"],
        ["a","a","b"]
    ]
 */
public class Palindrome_Partitioning_131
{
    private List<String> currList;
    private List<List<String>> result;

    public static void main(String[] args)
    {
        Palindrome_Partitioning_131 solution = new Palindrome_Partitioning_131();
        System.out.println(solution.partition("aabaa"));
    }

    public List<List<String>> partition(String s)
    {
        currList = new ArrayList<>();
        result = new ArrayList<>();
        backTrack(s,0);
        return result;
    }

    public void backTrack(String str, int l)
    {
        if(currList.size() > 0 && l>=str.length())
            result.add(new ArrayList<>(currList));

        for(int i=l; i<str.length(); i++)
        {
            if(isPalindrome(str,l,i))//判断当前 l->i 这个子串是否是回文串
            {
                if(l == i) // l==i 说明当前子串长度为1，直接加入
                    currList.add(Character.toString(str.charAt(i)));
                else //不等，说明需要将子串加入（由判断条件决定此子串肯定是回文子串）
                    currList.add(str.substring(l,i+1));
                backTrack(str,i+1);//递归判断后续子串
                currList.remove(currList.size()-1);
            }
        }
    }

    /**
     * 判断一个字符串是否是回文串
     */
    public static boolean isPalindrome(String str, int l, int r)
    {
        if(l == r)
            return true;
        while(l < r)
        {
            if(str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}

