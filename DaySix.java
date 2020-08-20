import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**Problem:- Given an array of String group Anagrams together
 * e.g. ["car","mat","arc","tui","iut"] ->[["car,"arc"],["tui","iut"],[mat]] 
**/
class Anagrams {
    /** Create a Hashmap with the key being a sorted string & the value containing 
     * the corresponding list of anagrams. 
     * e.g. {"acr"=["car","arc"],"itu"=["tui","iut"],"amt"=["mat"]}
     * Return the values of hashmap
    **/
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length ==0) return new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        for(String st : strs) {
            char ch[] = st.toCharArray();
            Arrays.sort(ch);
            String sortedString = String.valueOf(ch);
            if(!hm.containsKey(sortedString)) hm.put(sortedString, new ArrayList<String>());
            ArrayList<String> al = hm.get(sortedString);
            al.add(st);
            hm.put(sortedString,al);
        }
        return new ArrayList<List<String>>(hm.values());    
    }
}
public class DaySix {
    public static void main(String args[]) {
        Anagrams ga = new Anagrams();
        String [] ia = new String[]{"car","mat","arc","tui","iut"};
        System.out.println(ga.groupAnagrams(ia));
    }
    
}
