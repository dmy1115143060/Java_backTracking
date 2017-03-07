package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 用回溯法解决01背包问题
 */
public class Package_01
{
	private static int[] weight = {2, 1, 3, 2};
	private static int[] value =  {3, 2, 4, 2};
	private static int capacity = 5;
	private static int maxValue = 0;

	public static void main(String[] args)
	{
		getMaxValue(0, capacity, new ArrayList<Integer>());
		System.out.println(maxValue);
	}
	/**
	 * @param start:剩余物品集合的起始物品下标
	 * @param capacity:当前背包的容量
	 * @param list：当前背包中的物品下标集合
	 */
	public static void getMaxValue(int start, int capacity, List<Integer> list)
	{
		for(int i = start; i < weight.length; i++)
		{
			//当前物品重量比背包容量小，此时可以放入背包中
			if(weight[i] <= capacity)
			{
				//取出原有背包中的所有物品，并把当前物品放入背包中
				List<Integer> newList = new ArrayList<>(list);
				newList.add(i);

				//判断当前背包物品的价值量是否比上一次要大，大则进行更新
				int totalValue = getTotalValue(newList);
				maxValue = totalValue > maxValue ? totalValue : maxValue;

				System.out.println(newList + "," + maxValue);
				//继续判断下一个物品是否可以加入，背包容量减去当前物品的重量
				getMaxValue(i + 1, capacity - weight[i], newList);
			}
			//若当前的物品重量大于背包容量，则跳过此物品
			else if(weight[i] > capacity)
			{
				continue;
			}
		}
	}

	public static int getTotalValue(List<Integer> list)
	{
		int totalValue = 0;
		for(Integer i : list)
		{
			totalValue += value[i];
		}
		return totalValue;
	}
	
	/*
	public static void quickSort(int[] weight, int[] value, int start, int end)
	{
		int i = start, j = end; 
		if(i < j)
		{
			int partition1 = weight[i];
			int partition2 = value[i];
			while(i < j)
			{
				while(weight[j] >= partition1 && i < j) j--;
				weight[i] = weight[j];
				value[i] = value[j];
				
				while(weight[i] <= partition1 && i < j) i++;
				weight[j] = weight[i];
				value[j] = value[i];
			}
			weight[i] = partition1;
			value[i] = partition2;
			quickSort(weight, value, start, i-1);
			quickSort(weight, value, i+1, end);
		}
	}*/
}
