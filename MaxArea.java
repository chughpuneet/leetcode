public class MaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{2,3,4,5,18,17,6}));
    }

    public static int maxArea(int[] height) {

        int left = 0;
        int right= height.length-1;
        int area = 0;
        while(left<right){
            int leftHeight = height[left];
            int rightHeight = height[right];

            if(leftHeight < rightHeight){
                int newArea = leftHeight *(right - left);
                area = newArea>area?newArea:area;
                left = getNextBigLeft(height, left, right);
            }
            if(leftHeight>rightHeight){
                int newArea = rightHeight *(right - left);
                area = newArea>area?newArea:area;
                right = getNextBigRight(height, right, left);
            }

            if(leftHeight == rightHeight){
                int newArea = rightHeight *(right - left);
                area = newArea>area?newArea:area;
                right--;
                left++;
            }
        }
        return area;
    }

    private static int getNextBigLeft(int[] height, int index, int rightIndex){
        int currentHeight = height[index];
        while(index++<rightIndex){
            int nextLeftHeight = height[index];
            if(nextLeftHeight > currentHeight){
                return index;
            }
        }

        return index;
    }

    private static int getNextBigRight(int[] height, int index, int leftIndex){
        int currentHeight = height[index];
        while(index-- >leftIndex){
            int nextRighttHeight = height[index];
            if(nextRighttHeight > currentHeight){
                return index;
            }
        }

        return index;
    }
}
