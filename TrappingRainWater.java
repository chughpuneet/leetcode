public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,3}));
    }

    public static int trap(int[] height)  {

        int left=0;
        int total=0;
        int right = left+1;
        while(left<right && right<height.length){
            right = getRightEqualOrGreaterThanLeft(left, height);
            if(right>left){
                total+=getVolume(left, right, height);
                left = right;
            }else{
                left++;
            }

            right=left+1;


        }
        return total;
    }

    private static int getRightEqualOrGreaterThanLeft(int left, int[] height){
        if(left+1 < height.length){
            int right = left+1;
            while(right<height.length){
                if(height[right]>=height[left]){
                    return right;
                }
                right++;
            }
        }
        return left;

    }

    private static int getVolume(int left, int right, int[] height){
        int leftHeight = height[left];
        int total = 0;
        if(!(left == 0 && right == 1) || !(right == height.length - 1 && left == right - 1))
        while(left<right){
            int nextHeight = height[++left];
            total+=(leftHeight-nextHeight);
        }

        return total;
    }
}
