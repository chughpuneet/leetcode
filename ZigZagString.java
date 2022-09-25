import java.util.ArrayList;
import java.util.List;

public class ZigZagString {
    public static void main(String[] args) {
        System.out.println(convert("AB",1));
    }
    public static String convert(String s, int numRows) {
        int length = s.length();
        //Character[] chars = s.toCharArray();

        int i=0;
        List<String> finalStr = new ArrayList<>(numRows);
        for(int t=0;t<numRows;t++){
            finalStr.add("");
        }
        int x=0;
        while(i<length){

            while(x<numRows && i<length){
                String temp = s.substring(i++,i);
                String current = finalStr.get(x);
                current=current+temp;
                finalStr.set(x++,current);
            }
            if(i<length){
                for(x=x-2;x>=0&&i<length;x--){
                    String temp = s.substring(i++,i);
                    String current = finalStr.get(x);
                    current=current+temp;
                    finalStr.set(x,current);
                }
            }
            x+=2;

        }

        String result = "";
        for(int t=0;t<numRows;t++){
            result = result + finalStr.get(t);
        }

        return result;

    }
}
