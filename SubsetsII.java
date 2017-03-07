package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  Given a collection of integers that might contain duplicates, nums, return all possible subsets.
    Note: The solution set must not contain duplicate subsets.
    For example,
    If nums = [1,2,2], a solution is:
    [
        [2],
        [1],
        [1,2,2],
        [2,2],
        [1,2],
        []
    ]
 */
public class SubsetsII
{
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args)
    {
        int[] nums = {4, 4, 4, 1, 4};
        Arrays.sort(nums);
        backTrack(0, nums, new ArrayList<>());
        result.add(new ArrayList<>());
        System.out.println(result);
    }

    public static void backTrack(int start, int[] nums, List<Integer> list)
    {
        for(int i = start; i < nums.length; i++)
        {
            if(list.size() < nums.length)
            {
                list.add(nums[i]);
                if(!result.contains(list))
                    result.add(new ArrayList<>(list));
                backTrack(i + 1, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
