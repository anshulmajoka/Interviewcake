package assignment11;

public class CommonString {
    public int maxCommonString(String s1, String s2) {

        int matchedAtIndex = 0;
        int count = 0;
        String largeString = "";
        String smallString = "";
        if (s1.length() > s2.length()) {
            largeString = s1;
            smallString = s2;
        } else {
            smallString = s1;
            largeString = s2;
        }
        for (int i = 0; i < smallString.length(); i++) {
            char ele = smallString.charAt(i);
            for (int j = matchedAtIndex; j < largeString.length(); j++){
                if (ele == largeString.charAt(j) && smallString.charAt(i+1) == largeString.charAt(j+1)) {
                    matchedAtIndex = j + 1;
                    count++;
                    break;
                }
                else matchedAtIndex = j+1;
            }
        }
        return count;
    }
}
