package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
   By listing and labeling all of the permutations in order,
   We get the following sequence (ie, for n = 3):
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
 Given n and k, return the kth permutation sequence.
 */
public class Permutation_Sequence_60
{

    private static List<String> resultList = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n, k;
        String source = "";
        n = input.nextInt();
        k = input.nextInt();
        for(int i = 1; i <= n; i++)
            source += i;
        backTrack(source,0, new ArrayList<>());

        for(String s : resultList)
            if(s.startsWith(k + ""))
                System.out.println(s);
    }

    public static void backTrack(String source, int start, List<Character> list)
    {
        for(int i = 0; i < source.length(); i++)
        {
            if( !list.contains(source.charAt(i)))
            {
                List<Character> newList = new ArrayList<>(list);
                newList.add(source.charAt(i));
                if(newList.size() == source.length())
                    resultList.add(getString(newList));
                backTrack(source, start, newList);
            }
            else
                continue;
        }
    }

    public static String getString(List<Character> list)
    {
        String s = "";
        for (char c : list)
        {
            s += Character.toString(c);
        }
        return s;
    }
}
