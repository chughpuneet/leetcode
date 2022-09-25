import java.util.*;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if(digits.trim().equals("")){
            return new ArrayList<String>();
        }

        Map<String, String[]> numberChars = new HashMap<>();
        numberChars.put("2", new String[]{"a","b","c"});
        numberChars.put("3", new String[]{"d","e","f"});
        numberChars.put("4", new String[]{"g","h","i"});
        numberChars.put("5", new String[]{"j","k","l"});
        numberChars.put("6", new String[]{"m","n","o"});
        numberChars.put("7", new String[]{"p","q","r","s"});
        numberChars.put("8", new String[]{"t","u","v"});
        numberChars.put("9", new String[]{"w","x","y","z"});

        String[] digitsArr = digits.split("");

        List<String> ret = new ArrayList<String>();
        for(String digit : digitsArr){
            String[] digitChars = numberChars.get(digit);
            if(ret.isEmpty()){
                ret = Arrays.asList(digitChars);
            }else{
                ret = merge(ret, digitChars);
            }

        }
        return ret;
    }

    public List<String> merge(List<String> ret, String[] digitChars){
        List<String> newRet = new ArrayList<>();
        for(String digitChar : digitChars){
            for(String retString : ret){
                newRet.add(retString + digitChar);
            }
        }

        return newRet;
    }
}
