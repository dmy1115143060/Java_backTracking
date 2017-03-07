package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    For example,
    If n = 4 and k = 2, a solution is:
    [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
    ]
 */
public class Combinations_77
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String source = "";
        int n = input.nextInt();
        int k = input.nextInt();
        for (int i = 1; i <= n; i++)
            source += i;
        backTrack(source, 0, k, new ArrayList<>());
    }

    public static void backTrack(String source, int start, int k, List<Character> list)
    {
        for (int i = start; i < source.length(); i++)
        {
            if(list.size() < k)
            {
                List<Character> newList = new ArrayList<>(list);
                newList.add(source.charAt(i));
                if(newList.size() == k)
                {
                    for (char c : newList)
                        System.out.print(c);
                    System.out.println();
                }
                backTrack(source, i+1, k, newList);
            }
            else
                break;
        }
    }
}
