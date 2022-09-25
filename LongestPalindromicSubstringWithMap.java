import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromicSubstringWithMap {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    public static String longestPalindrome(String s) {
        Map<Character, List<Integer>> charWithIndexes = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            List<Integer> list = charWithIndexes.get(c);
            if (null == list) {
                list = new ArrayList<>();
            }
            list.add(i);
            charWithIndexes.put(c, list);
        }

        if(charWithIndexes.keySet().size() == 1){
            return s;
        }

        int startIndex = 0, endIndex =0;
        for(Character c : charWithIndexes.keySet()){
            List<Integer> list = charWithIndexes.get(c);
            for(int i=0;i<list.size()-1;i++){
                for(int j=list.size()-1;j>i;j--){
                    if(((list.get(j)-list.get(i))>(endIndex-startIndex)) && checkPal(s, list.get(i), list.get(j))){
                        startIndex = list.get(i);
                        endIndex = list.get(j);
                        break;
                    }
                }
            }
        }
        return s.substring(startIndex, endIndex+1);
    }

    private static boolean checkPal(String s, int start, int end){
        int size = end -start + 1;
        String s1="",s2="";
        if(size%2 == 0){
            //even
            int center = size/2;
            s1 = s.substring(start,start + center);
            s2 = s.substring(start + center,end+1);

        }else{
            //odd
            int center = size/2;
            s1 = s.substring(start, start + center);
            s2 = s.substring(start + center+1, end+1);
        }
        for(int i=0, j=s2.length()-1; i<s1.length()&&j>=0;i++,j--){
            if(s1.charAt(i) != s2.charAt(j)){
                return false;
            }
        }

        return true;

    }
}
