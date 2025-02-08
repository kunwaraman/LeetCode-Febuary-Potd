import java.util.*;
/*
ps: https://leetcode.com/problems/design-a-number-container-system/
time complexity: O(LogN)ForInsertingAndFindingElements
space complexity: O(N)
 */
public class DesignANumberContainerSystem {
    HashMap<Integer,Integer> idxtonum = new HashMap<>();
    TreeMap<Integer,TreeSet<Integer>> numtoidx = new TreeMap<>();

    public NumberContainers() {

    }

    public void change(int index, int number) {
        if(idxtonum.containsKey(index)){
            int prevnum=idxtonum.get(index);
            numtoidx.get(prevnum).remove(index);
            if(numtoidx.get(prevnum).isEmpty()){
                numtoidx.remove(prevnum);
            }
        }
        idxtonum.put(index,number);
        numtoidx.putIfAbsent(number,new TreeSet<>());
        numtoidx.get(number).add(index);
    }
    public int find(int number) {
        if(numtoidx.containsKey(number)){
            return numtoidx.get(number).first();
        }
        return -1;
    }
}
