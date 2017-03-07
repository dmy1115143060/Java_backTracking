package LeetCode.BackTrack;
/**
 *  Given a collection of distinct numbers, return all possible permutations.For example,
    [1,2,3] have the following permutations:
    [
        [1,2,3],
        [1,3,2],
        [2,1,3],
        [2,3,1],
        [3,1,2],
        [3,2,1]
    ]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 思路：利用回溯法进行求解
 */
public class Permutations_46
{
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args)
    {
        int[] nums = {1,2,3};
        backTrack2(0, nums, new ArrayList<>());
        System.out.println(result);
    }

    public static void backTrack(int start, int nums[], List<Integer> list)
    {
        for(int i = start; i < nums.length; i++)
        {
            if(list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            if(list.size() == nums.length)
            {
                result.add(new ArrayList<>(list));
                System.out.println(list);
            }
            backTrack(start, nums, list);
            list.remove(list.size() - 1);//回退
        }
    }

    public static void backTrack2(int start, int nums[], List<Integer> list)
    {
        for(int i = start; i < nums.length; i++)
        {
            if(list.contains(nums[i]))
                continue;
            else
            {
                List<Integer> newList = new ArrayList<>();
                newList.add(nums[i]);
                if(newList.size() == nums.length)
                {
                    result.add(new ArrayList<>(newList));
                    System.out.println(newList);
                }
                backTrack(start, nums, newList);
            }
        }
    }
}
