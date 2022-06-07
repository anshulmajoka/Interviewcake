package algo;

import com.sun.source.doctree.SeeTree;

import java.util.*;

public class FindDups {
    
    public List<Integer> dups(List<Integer> list) {
        List<Integer> dups = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            if (!hm.containsKey(list.get(i))) {
                hm.put(list.get(i), count);
            }
            hm.put(list.get(i), hm.get(list.get(i)));
        }

        hm.forEach((k,v) -> {
            if (v > 1) {
                dups.add(k);
            }
        });

        hm.entrySet().stream().forEach(val -> {
            if (val.getValue() > 1) {
                dups.add(val.getKey());
            }
        });

        Iterator<Map.Entry<Integer,Integer>> itr = hm.entrySet().iterator();
        while (itr.hasNext()) {
            if (itr.next().getValue() > 1) {
                dups.add(itr.next().getKey());
            }
        }
        for (Map.Entry<Integer,Integer> set:
             hm.entrySet()) {
            if (set.getValue()>1) {
                dups.add(set.getKey());
            }
        }
        return dups;
    }
}
