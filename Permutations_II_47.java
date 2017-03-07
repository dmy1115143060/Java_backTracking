package LeetCode.BackTrack;


import java.util.*;
/**
 *  Given a collection of numbers that might contain duplicates, return all possible unique permutations.For example,
    [1,1,2] have the following unique permutations:
    [
        [1,1,2],
        [1,2,1],
        [2,1,1]
    ]
 */
public class Permutations_II_47
{
    private static String source = "1122";
    //利用map来保存每个字符的总个数
    private static Map<Character, Integer> occurCount = new HashMap<>();
    //利用set来保存出现的序列的唯一性
    private static Set<List<Character>> set = new HashSet<>();

    public static void main(String[] args)
    {
       initOccurCount();
       backTrack(0, new ArrayList<>());
       for(List<Character> l : set)
           System.out.println(l);
    }

    public static void initOccurCount()
    {
        for(int i = 0; i < source.length(); i++)
        {
            char c = source.charAt(i);
            int count = 1;
            if(occurCount.containsKey(c))
            {
                count = occurCount.get(c) + 1;
            }
            occurCount.put(c, count);
        }
    }

    public static void backTrack(int start, List<Character> list)
    {
        for(int i = 0; i < source.length(); i++)
        {
            char c = source.charAt(i);
            //如果当前字符在list中的个数小于在原串中的个数，则继续执行，否则跳过该字符
            if(count(c, list) < occurCount.get(c))
            {
                List<Character> newList = new ArrayList<>(list);
                newList.add(c);
                if (newList.size() == source.length() )
                    set.add(newList);
                    //System.out.println(newList);
                backTrack(start, newList);

            }
            else
                continue;
        }
    }

    /*
    * public static void backTrack(int start, int[] nums, List<Integer> list)
    {
        for(int i = start; i < nums.length; i++)
        {
            if(list.size() < nums.length && getCount(nums[i], list) < occurCount.get(nums[i]))
            {
                list.add(nums[i]);
                if(list.size() == nums.length)
                    result.add(new ArrayList<>(list));
                backTrack(start, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
    * */

    //判断当前字符c在list中的个数
    public static int count(char c, List<Character> list)
    {
        int count = 0;
        for(char temp : list)
            if(temp == c)
                count++;
        return  count;
    }
}

/**
 *  public class Solution
    {
        public List<List<Integer>> permuteUnique(int[] nums)
        {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
            return list;
        }

        private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used)
        {
            if(tempList.size() == nums.length)
            {
                list.add(new ArrayList<>(tempList));
            }
            else
            {
                for(int i = 0; i < nums.length; i++)
                {
                    if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                        used[i] = true;
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums, used);
                    used[i] = false;
                    tempList.remove(tempList.size() - 1);
            }
        }
    }
 */
