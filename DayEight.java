import java.util.HashMap;
/** Problem: Find the longest well performing interval from a given array of hours worked each day. 
 *  A day is tiring day if number of hours > 8 or else it is non tiring. 
 *  A well perfoming interval is an interval where number of tiring days > number of non- tiring days
 *  e.g. In [6,9,9,7,4,5,9] longest well performing interval is [9,9,7]  
 */
class Problem {
    /** The idea here is to encode the input array insuch a way if num>8 we use 1 or else -1 
     *  so [6,9,9,7,4,5,9] will be [-1,1,1,-1,-1,-1,1]
     *  Next we need to find out the length of longest sub array with positive sum i.e. [1,1,-1]
     *  To do so effectively we can make use of prefix sums [-1,1,1,-1,-1,-1,1] -> [-1,0,1,0,-1,-2,-1]
     *  and hash map to store sum and corresponding index.
     */
    public int longestWPI(int[] hours) {
        int sum =0;
        int max =0;
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i<hours.length; i++) {
            sum += hours[i]>8 ? 1 :-1;
            if(!hm.containsKey(sum)) hm.put(sum,i);
            if(sum>0) max=i+1;
            else if(hm.containsKey(sum -1))
                max = Math.max(max,i-hm.get(sum-1));
        }
        return max;
    }
}
public class DayEight {
    public static void main(String args[]){
        Problem p = new Problem();
        int hours[] = new int[] {6,9,9,7,4,5,9};
        System.out.println(p.longestWPI(hours));
    }
}
