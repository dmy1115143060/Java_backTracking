package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 求出一个字符串的所有的满足特定子序列的个数。如abcbc中满足abc子串的有3种（abc_ _）(ab_ _c)(a_ _bc)
 */
public class GetAllSubseq
{
    private static int count = 0;
    private static String pattern = "abc";

    public static void main(String[] args)
    {
        getSubstring("abcdabc",0, new ArrayList<>());
        System.out.println(count);
    }

    public static void getSubstring(String source, int start, List<String> list)
    {
        //1.遍历源串的所有字符
        for(int i = start; i < source.length(); i++)
        {
            if(list.size() < pattern.length())
            {
                List<String> newList = new ArrayList<>(list);
                newList.add(new String(Character.toString(source.charAt(i))));
                if(newList.size() == pattern.length())
                {
                   // System.out.println(getListString(newList));
                    if(getListString(newList).equals(pattern))
                        count ++;
                }
                System.out.println(newList);
                getSubstring(source,i + 1,newList);
            }
            else
                continue;
        }
    }

    public static String getListString(List<String> list)
    {
        String str = "";
        for(String s : list)
        {
            str += s;
        }
        return str;
    }
}
