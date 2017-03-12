package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 用回溯法获得一个字符串的所有子串
 */
public class GetAllSubstring
{
    private static String source = "abcd";
    private static List<String> resultList = new ArrayList<>();

    public static void main(String[] args)
    {
        getAllSubstring(0, new ArrayList<>());
        System.out.println(resultList);
    }

    public static void getAllSubstring(int start, List<String> subList)
    {
        for(int i = start; i < source.length(); i++)
        {
           List<String> newSubList = new ArrayList<>(subList);

            newSubList.add(Character.toString(source.charAt(i)));

            int currentStrLength = getString(newSubList).length();
            int perStrLength = resultList.size() > 0 ? resultList.get(resultList.size()-1 ).length() : 0;

            //保证得到的是子串而非子序列，因为子串每次从一个字符往上累加，因此下一个子串要么是长度为1,要么长度比上个子串的长度要大
            if(currentStrLength == 1 || currentStrLength > perStrLength)
                resultList.add(getString(newSubList));

            //回溯遍历可以得到所有子序列
            getAllSubstring(i + 1, newSubList);
        }
    }

    public static String getString(List<String> list)
    {
        String str = "";
        for(String s : list)
            str += s;
        return str;
    }
}
