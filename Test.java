import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    static  int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static  String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public static void main(String[] args) {


        System.out.println(intToRoman(11998));

                //collect(Collectors.toMap(i.getAndIncrement(),Integer :: intValue));
    }

    public static String intToRoman(int N) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; N > 0; i++)
            while (N >= val[i]) {
                ans.append(rom[i]);
                N -= val[i];
            }
        return ans.toString();
    }
}
