import java.util.HashMap;
/** Problem:- Find number of contiguous subarrays with a given sum k
 * e.g. [1,1,3,2] k =5
 * Result: 2 i.e. {[1,1,3],[3,2]}
 */
class FindSubArrayWithKSum {
    /** Use HashMap to store the cumulativeSum and its freq {(1,1),(2,1),(5,1),(7,1)}
     *  if cummulative sum is equal to k increase the count
     *  if the present cumulative sum - k is present in the hashmap, increase count by map value
     */
     int numberOfSubArraysWitkKSum(int inputNums[], int k) {
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        int cumulativeSum =0 , count =0;
        for(int num:inputNums){
            cumulativeSum += num;
            if(cumulativeSum == k) count++;
            if(hm.containsKey(cumulativeSum-k)) count += hm.get(cumulativeSum-k);
            hm.put(cumulativeSum, hm.getOrDefault(cumulativeSum, 0) + 1);
        }
        return count;
    }
}
public class DaySeven {
     public static void main(String[] args) {
        FindSubArrayWithKSum a = new FindSubArrayWithKSum();
        int nums[] = new int[]{1,1,3,2};
        System.out.println(a.numberOfSubArraysWitkKSum(nums, 5));

    }
    
    
}
