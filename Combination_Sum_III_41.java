package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 *  Example 1:
 *  Input: k = 3, n = 7
 *	Output: [[1,2,4]]
 *
 *  Example 2:
 *	Input: k = 3, n = 9
 *	Output:[[1,2,6], [1,3,5], [2,3,4]]
 */

/**
 * 解题思路：利用回溯法解决，利用List来存储每个序列，同样最后的得到的序列也存储到List中.
 * 可以使用的元素取值范围为1-9（元素不可以重复使用），并且保证使用的元素个数为k个
 */
public class Combination_Sum_III_41{
	
	public static void main(String[] args){
		
		int[] nums={1, 2, 3, 4, 5, 6, 7, 8, 9};
		int k = 3;
		int n = 9;
		Arrays.sort(nums);
		List<List<Integer>> targetSeq = new ArrayList<>();
		List<Integer> currentSeq = new ArrayList<>();
		getCombinationSumSeq(nums, k, n, 0, targetSeq, currentSeq);
		System.out.println(targetSeq);
	}

	/**
	 * @param nums:输入的序列      [1, 2, 3, 4, 5, 6, 7, 8, 9]这里预先进行排序
	 * @param k:累加的元素个数
	 * @param n:得到的目标值
	 * @param start:当前可用数字序列的起始下标
	 * @param targetSeq:最终得到的满足target的目标序列的集合
	 * @param currentSeq:当前数字序列
	 */
	public static void getCombinationSumSeq(int[] nums, int k, int n, int start, List<List<Integer>> targetSeq, 
						List<Integer> currentSeq){
		
		for(int i = start; i < nums.length; i++){
			
			//1.当前遍历到的数字和target相等，则将这个数字加入到当前序列currentSeq中，
			//若currentSeq的长度和k相等则加入到目标序列集合targetSeq中
			if(nums[i] == n){
				
				List<Integer> newCurrentSeq = new ArrayList<>(currentSeq);
				newCurrentSeq.add(nums[i]);
				if(newCurrentSeq.size() == k)
					targetSeq.add(newCurrentSeq);
			}
			//2.当前数字比target小，此时将数字加入到currentSeq中，并且将target值更新为target-nums[i],
			//继续遍历i+1号元素(由于保证每个元素不能重复使用)
			else if(nums[i] < n){
				
				List<Integer> newCurrentSeq = new ArrayList<>(currentSeq);
				newCurrentSeq.add(nums[i]);
				getCombinationSumSeq(nums, k, n - nums[i], i + 1, targetSeq, newCurrentSeq);
			}
			//3.当前数字比target要大，此时说明这个数字后面元素均比target要大，无需再往后遍历，那么currentSeq中最近加入的元素会被弹出，
			//将弹出元素后面位置的元素加入
			else
				return;
		}
	   }
     }
