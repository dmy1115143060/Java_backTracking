package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.List;
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
    private int count = 0;
    private int[] nums;
    private StringBuilder sb = new StringBuilder();

    public static void main(String[] args)
    {
        System.out.println(new Permutation_Sequence_60().getPermutation(10,20));
    }

    public String getPermutation(int n, int k)
    {
        nums = new int[n];

        int fac = 1;
        for(int i=2; i<n; i++)
            fac *= i;
        for(int i=0; i<n; i++)
            nums[i] = i+1;

        //计算k是属于第几组，对于n!来说，可以看成分成 n 组，每一组有 (n-1)！个数，第一组起始数字 1，第二组起始数字 2，第 i 组起始数字 i
        //classNO 对应的组起始数字应该为 classNO,在数组中下标应该为 classNO-1
        int classNO = 0;
        for(int level = 1; level<=n; level++)
        {
            if(k <= level * fac)
            {
                classNO = level;
                break;
            }
        }

        //此时将classNO对应的元素放在起始位置,即进行移位
        for(int i=classNO-2; i>=0; i--)
            nums[i+1] = nums[i];
        nums[0] = classNO;

        count = 0;
        backTrack(0, new ArrayList<>(), n, k - (classNO-1)*fac, new boolean[n]);
        return sb.toString();
    }

    public void backTrack(int start, List<Integer> list, int n, int k, boolean[] used)
    {
        if(count == k) //当遍历到符合条件的第 k 个元素时，退出
            return;

        for(int i=start; i<n; i++)
        {
            if(used[i]) //当前元素被使用过，则尝试下一个元素
                continue;

            used[i] = true; //标记元素被使用过
            list.add(nums[i]);
            if(list.size() == n)
            {
                count++;
                if(count == k)
                    for(Integer num : list)
                        sb.append(num);
                //System.out.println(list);
            }

            backTrack(start, list, n, k, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
