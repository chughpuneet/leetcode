import java.util.*;

/**
 * It is not good in time and memory
 */
public class LongestPalindromicSubstringWithPointer {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bacabab"));
    }

    public static String longestPalindrome(String s) {
        Map<Character, List<Integer>> charWithIndexes = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            List<Integer> list = charWithIndexes.get(c);
            if(null == list){
                list = new ArrayList<>();
            }
            list.add(i);
            charWithIndexes.put(c,list);
        }

        int startIndex = 0, endIndex = 0;
        for(Character c : charWithIndexes.keySet()){
            List<Integer> list = charWithIndexes.get(c);
            if(list.size() > 1){
                Collections.sort(list);
                for(int i=0;i<list.size()-1;i++){
                    int listStartIndex = list.get(i);
                    for(int y=list.size()-1;y>i;y--){

                        int listEndIndex = list.get(y);
                        if((listEndIndex - listStartIndex) > (endIndex - startIndex)){
                            if(isPalindromicString(s,listStartIndex,listEndIndex)){
                                startIndex = listStartIndex;
                                endIndex = listEndIndex;
                            }
                        }
                    }
                }

            }
        }
        return s.substring(startIndex, endIndex+1);
    }

    public static boolean isPalindromicString(String s, int startIndex, int endIndex){
        boolean palStr = true;
        while(startIndex < endIndex && palStr){
            if(s.charAt(startIndex++) != s.charAt(endIndex--)){
                palStr = false;
            }
        }
        return palStr;
    }
}
