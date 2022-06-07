package algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class MoveEvenToRight {
    //    public String move(String str) {
//        String even = "";
//        String odd = "";
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) % 2== 0) {
//                even = even + str.charAt(i);
//            }
//            else odd = odd + str.charAt(i);
//        }
//
//        sb.append(even);
//        sb.append(odd);
//        return sb.toString();
//    }
    public static String[] uniqueNames(String[] names1, String[] names2) {
        int size = 0;
        size = Math.max(names1.length, names2.length);

        String[] output = new String[size];
        

        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, names1);

        set.addAll(Arrays.asList(names1).subList(0, names2.length));

        Iterator<String> itr = set.iterator();
        int count = 0;
        while (itr.hasNext()) {
            output[count] = itr.next();
            count++;
        }
        return output;
    }
}


