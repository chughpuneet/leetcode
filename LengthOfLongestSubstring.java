import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
    }

    static public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1){
            return 1;
        }else {
            List<Character> temp = new ArrayList<Character>();
            if (s.length() == 1) {
                return 1;
            } else {
                int length = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (temp.contains(s.charAt(i))) {
                        if (length < temp.size()) {
                            length = temp.size();
                        }
                        //
                        temp = temp.subList(temp.indexOf(s.charAt(i))+1, temp.size());
                    }
                    temp.add(s.charAt(i));
                }
                if (length < temp.size()) {
                    length = temp.size();
                }
                return length;
            }
        }

    }
}
