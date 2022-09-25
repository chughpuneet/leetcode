public class MoveArrayElements {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};

        arr = moveArrayElements(arr, 3);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }

       // System.out.println(moveArrayElements(arr, 3));
    }

    static int[] moveArrayElements(int[] arr, int n){
        int[] temp = new int[n];
        int length = arr.length;
        int[] result = new int[length];

        int i=length-n;
        int j=0;

        while(i<length){
            temp[j++] = arr[i++];
        }

        i=0;

        int k = n;
        while(i<length-n){
            result[k++] =arr[i++];
        }

        i=0;
        while(i<temp.length){
            result[i] = temp[i++];
        }

        return result;
    }
}
