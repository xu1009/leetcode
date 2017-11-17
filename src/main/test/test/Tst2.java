package test;

import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;

public class Tst2 {
	@Test
	public void tstStringBuilder(){
		String temp = "12,23,56,";
		String[] data = temp.split(",");
		System.out.println(data);
		String res = temp.replaceAll(",","");
		System.out.println(res);
	}
	public static void getCombinations2(List<List<Integer>> res, List<Integer> temp, int[] nums, int remain, int index, int k){
		if (remain < 0)return;
		else if (remain == 0){
			if (temp.size() == k)
			res.add(new ArrayList<Integer>(temp));
		}
		else
			for (int i = index; i < nums.length; i++){
//				if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])continue;
				temp.add(nums[i]);
//				used[i] = true;
				getCombinations2(res, temp, nums, remain - nums[i], i + 1, k);
				temp.remove(temp.size() - 1);
//				used[i] = false;
			}
	}

	@org.junit.Test
	public void tst12(){
		int[] nums = {10, 1, 2, 7, 6, 1, 5};
		boolean[] used = new boolean[nums.length];
		int target = 8;
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		getCombinations2(res, new ArrayList<Integer>(), nums, target, 0, 1);
		System.out.println();
	}


	@org.junit.Test
	public  void findAllConisCompations(){
		int n = 7;
		int[] conis = new int[]{2, 3, 6, 7};
		int[] result = new int[n + 1];
		List<List<Integer>> cos = new ArrayList<>();
		Map<Integer, List<Integer>> co = new HashMap<>();
		for (int i = 0; i <= n; i++){
			result[i] = i;
			co.put(i, new ArrayList<Integer>());
			for (int j = 0; j < conis.length; j++){
				if (i >= conis[j]){
//					result[i] = result[i - conis[j]] + 1;
					List<Integer> temp = new ArrayList<>(co.get(i - conis[j]));
					if (temp == null || (i - conis[j]) > 0 && temp.size() == 0)continue;
					temp.add(conis[j]);
					cos.add(temp);
					co.put(i, temp);
//                  result[i] = Math.min(result[i - conis[j]] + 1, result[i]);
				}
			}
		}
		System.out.println();
	}



}
