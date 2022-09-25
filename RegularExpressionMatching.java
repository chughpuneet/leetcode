public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aab",
                "c*a*b"));
    }
    public static boolean isMatch(String s, String p) {
        if(!p.contains(".") && !p.contains("*")){
            return s.equals(p);
        }

        int i=0;
        char previous = Character.MIN_VALUE;
        char current  = Character.MIN_VALUE;
        int j=0;
        while(j<s.length()){
            while(p.charAt(i) != '.' && p.charAt(i) != '*'){
                current = p.charAt(i++);
                if(s.charAt(j++) != current){
                    if(p.charAt(i) == '*'){
                        if(i != 1){
                            return false;
                        }
                    }
                }
                previous = current;
                if(j>=s.length()){
                    return false;
                }
            }

            if(p.charAt(i) == '.'){
                if(j>=s.length()){
                    return false;
                }else{
                    j++;
                }
                i++;
            }
            if(p.charAt(i) == '*'){
                while(s.charAt(j) == previous && j<s.length()){
                    j++;

                }
                i++;
            }



        }




        return true;
    }
}
