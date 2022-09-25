import java.util.LinkedHashMap;
import java.util.Map;

public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1800));
    }

    public static String intToRoman(int num) {

        Map<String, Integer> romanValues = new LinkedHashMap<String, Integer>();
        romanValues.put("M",1000);
        romanValues.put("CM",900);
        romanValues.put("D",500);
        romanValues.put("CD",400);
        romanValues.put("C",100);
        romanValues.put("XC",90);
        romanValues.put("L",50);
        romanValues.put("XL",40);
        romanValues.put("X",10);
        romanValues.put("IX",9);
        romanValues.put("V",5);
        romanValues.put("IV",4);
        romanValues.put("I",1);

        String roman = "";

        for(String symbol : romanValues.keySet()){
            int divisor = romanValues.get(symbol);
            if(num >= divisor){
                int quotient = num / divisor;

                if(quotient > 0){
                    for(int i=0;i<quotient;i++){
                        roman+=symbol;
                    }
                }
                num = num % divisor;
            }
        }

        /*roman = roman.replace("DCCCC","CM").replace("CCCC","CD")
                .replace("LXXXX","XC")
                .replace("XXXX","XL")
                .replace("VIIII","IX")
                .replace("IIII","IV");
        */
        return  roman;

    }
}
