package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 *  find all unique combinations in C where the candidate numbers sums to T.
 *  The same repeated number may be chosen from C unlimited number of times.
 *
 * 	Note:
 *  All numbers (including target) will be positive integers.
 *  The solution set must not contain duplicate combinations.
 *
 * 	For example, given candidate set [2, 3, 6, 7] and target 7,
 * 	A solution set is:
 *	[
 * 	   [7],
 *	   [2, 2, 3]
 *	]

 /**
 * 解题思路：利用回溯法解决，利用List来存储每个序列，同样最后的得到的序列也存储到List中（不包含重复元素，但元素可以重复使用）
 */
public class Combination_Sum_I_39{
	
	public static void main(String[] args){
		
		int[] nums={2, 3, 6, 7};
		int target = 7;
		Arrays.sort(nums);
		List<List<Integer>> targetSeq = new ArrayList<>();
		List<Integer> currentSeq = new ArrayList<>();
		getCombinationSumSeq(nums, target, 0, targetSeq, currentSeq);
		System.out.println(targetSeq);
	}
	/**
	 * @param nums:输入的序列     [2, 3, 6, 7],这里预先进行排序
	 * @param target:得到的目标值      7
	 * @param start:当前可用数字序列的起始下标
	 * @param targetSeq:最终得到的满足target的目标序列的集合
	 * @param currentSeq:当前数字序列
	 */
	public static void getCombinationSumSeq(int[] nums, int target, int start, List<List<Integer>> targetSeq,
						List<Integer> currentSeq){
		
		for(int i = start; i < nums.length; i++ ){
			
			//1.当前遍历到的数字和target相等，则将这个数字加入到当前序列currentSeq中，并将currentSeq加入到目标序列集合targetSeq中
			if( nums[i] == target){
				
				List<Integer> newCurrentSeq = new ArrayList<>(currentSeq);
				newCurrentSeq.add(nums[i]);
				targetSeq.add(newCurrentSeq);
			}
			
			//2.当前数字比target小，此时将数字加入到currentSeq中，并且将target值更新为target-nums[i],继续遍历i号元素(由于元素可以重复使用)
			else if(nums[i] < target){
				
				List<Integer> newCurrentSeq = new ArrayList<>(currentSeq);
				newCurrentSeq.add(nums[i]);
				getCombinationSumSeq(nums, target - nums[i], i, targetSeq, newCurrentSeq);
			}
			else
				return;
		}
	}
}
