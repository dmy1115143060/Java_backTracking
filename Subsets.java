package LeetCode.BackTrack;


import java.util.ArrayList;
import java.util.List;

/**
 *  Given a set of distinct integers, nums, return all possible subsets.
    Note: The solution set must not contain duplicate subsets.
    For example,
    If nums = [1,2,3], a solution is:
        [
            [3],
            [1],
            [2],
            [1,2,3],
            [1,3],
            [2,3],
            [1,2],
            []
        ]
 */
public class Subsets
{
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};
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
                result.add(new ArrayList<>(list));
                backTrack(i + 1, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
