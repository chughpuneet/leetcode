public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(execute1("IV"));
    }

    public static int execute(String s){
        int value = 0;

        String[] romanKeys = new String[]{"CM", "CD", "XC", "XL", "IX", "IV", "M", "D", "C", "L", "X", "V", "I"};
        String[] romanValues = new String[]{"900,", "400,", "90,", "40,", "9,", "4,", "1000,", "500,", "100,", "50,", "10,"
                , "5,", "1,"};

        for(int i=0;i<romanKeys.length;i++){
            s=s.replaceAll(romanKeys[i],romanValues[i]);
        }

        String[] numsStr = s.split(",");
        for(String nums : numsStr){
            value+=Integer.valueOf(nums);
        }
        return value;
    }

    public static int execute1(String s){
        int result = 0;
        int tmp = 1000, val = 0;

        for (char c: s.toCharArray()) {
            // dirty but to try
            switch(c) {
                case 'I':
                    val = 1;
                    break;
                case 'V':
                    val = 5;
                    break;
                case 'X':
                    val = 10;
                    break;
                case 'L':
                    val = 50;
                    break;
                case 'C':
                    val = 100;
                    break;
                case 'D':
                    val = 500;
                    break;
                case 'M':
                    val = 1000;
                    break;
            }

            result += val;

            if (tmp < val) {
                result -= 2 * tmp;
            }

            tmp = val;
        }

        return result;
    }
}
