package FirstMissingPositive;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  //Using hashset
  public int firstMissingPositive(int[] nums) {
    Set<Integer> set = new HashSet<>();

    for(int i = 0; i < nums.length; i++){
      if(nums[i] > 0){
        set.add(nums[i]);
      }
    }
    int missing = 1;
    while(set.contains(missing)){
      missing++;
    }
    return missing;
  }

}
