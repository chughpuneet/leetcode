public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(929));
    }

    public static boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }

        int temp = x;
        int reverse = 0;

        while(temp > 0){
            int right = temp%10;
            reverse = reverse*(10)+right;
            temp = (temp-right)/10;
        }


        if(x == reverse){
            return true;
        }else{
            return false;
        }

    }
}
