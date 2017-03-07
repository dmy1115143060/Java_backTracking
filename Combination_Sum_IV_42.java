package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Example:
 * nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)
 */

/**
 * 解题思路：利用回溯法解决，利用List来存储每个序列，同样最后的得到的序列也存储到List中.
 * 得到的序列只要不同均为合法解
 */
public class Combination_Sum_IV_42{
	
	public static void main(String[] args){
		
		int[] nums={1, 2, 3};
		int target = 4;
		int start = 0;
		Arrays.sort(nums);
		List<List<Integer>> targetSeq = new ArrayList<>();
		List<Integer> currentSeq = new ArrayList<>();
		getCombinationSumSeq(nums, target, start, targetSeq, currentSeq);
		System.out.println(targetSeq);
	}

	/**
	 * @param nums:输入的序列      [1, 2, 3]这里预先进行排序
	 * @param k:累加的元素个数
	 * @param n:得到的目标值
	 * @param start:当前可用数字序列的起始下标
	 * @param targetSeq:最终得到的满足target的目标序列的集合
	 * @param currentSeq:当前数字序列
	 */
	public static void getCombinationSumSeq(int[] nums, int target, int start, List<List<Integer>> targetSeq, 
						List<Integer> currentSeq){
		
		for(int i = start; i < nums.length; i++){
			
			if(nums[i] == target){
				
				List<Integer> newCurrentSeq = new ArrayList<>(currentSeq);
				newCurrentSeq.add(nums[i]);
				targetSeq.add(newCurrentSeq);
			}
			
			//当前数字比target小，此时将数字加入到currentSeq中，并且将target值更新为target-nums[i],
			//继续遍历start号元素(由于不同序列的元素也符合要求，因此每次都会从初始位置进行遍历)
			else if(nums[i] < target){
				
				List<Integer> newCurrentSeq = new ArrayList<>(currentSeq);
				newCurrentSeq.add(nums[i]);
				getCombinationSumSeq(nums, target - nums[i], start, targetSeq, newCurrentSeq);
			}
			else
				return;
		}
	}
}
