package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 * in C where the candidate numbers sums to T.Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.

 *	For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 *	A solution set is:
 *	[
 * 		[1, 7],
 *		[1, 2, 5],
 *	    [2, 6],
 * 		[1, 1, 6]
 *	]
 */
/**
 * 解题思路：利用回溯法解决，利用List来存储每个序列，同样最后的得到的序列也存储到List中.（包含重复元素，但元素不可重复使用）
 * @author 3
 *
 */
public class Combination_Sum_II_40{
	
	public static void main(String[] args){
		
		int[] nums={10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		Arrays.sort(nums);
		List<List<Integer>> targetSeq = new ArrayList<>();
		List<Integer> currentSeq = new ArrayList<>();
		getCombinationSumSeq(nums, target, 0, targetSeq, currentSeq);
		System.out.println(targetSeq);
	}
	/**
	 * @param nums:输入的序列      [1, 1, 2, 5, 6, 7, 10],这里预先进行排序
	 * @param target:得到的目标值      8
	 * @param start:当前可用数字序列的起始下标
	 * @param targetSeq:最终得到的满足target的目标序列的集合
	 * @param currentSeq:当前数字序列
	 */
	public static void getCombinationSumSeq(int[] nums, int target, int start, List<List<Integer>> targetSeq, 
						List<Integer> currentSeq){
		for(int i = start; i < nums.length; i++)
		{
			//当连续若干数字相同时，需要排除重复的序列（序列可能包含重复元素）
			if(i > start && nums[i] == nums[i-1])
				continue;
			
			//1.当前遍历到的数字和target相等，则将这个数字加入到当前序列currentSeq中，并将currentSeq加入到目标序列集合targetSeq中
			if(nums[i] == target){
				
				//先获取当前除num[i]的前面的数字序列
				List<Integer> newCurrentSeq = new ArrayList<>(currentSeq);
				newCurrentSeq.add(nums[i]);
				System.out.println(newCurrentSeq);
				targetSeq.add(newCurrentSeq);
			}
			
			//2.当前数字比target小，此时将数字加入到currentSeq中，并且将target值更新为target-nums[i],
			//继续遍历i+1号元素(由于保证每个元素不能重复使用)
			else if(nums[i] < target){
				
				List<Integer> newCurrentSeq = new ArrayList<>(currentSeq);
				newCurrentSeq.add(nums[i]);
				System.out.println(newCurrentSeq);
				getCombinationSumSeq(nums, target - nums[i], i + 1, targetSeq, newCurrentSeq);
			}
			//3.当前数字比target要大，此时说明这个数字后面元素均比target要大，无需再往后遍历，那么currentSeq中最近加入的元素会被弹出，
			//将弹出元素后面位置的元素加入
			else
				return;
		}
	   }
     }
