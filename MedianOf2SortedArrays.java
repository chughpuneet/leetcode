public class MedianOf2SortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2,4};
        int totalLength = nums1.length + nums2.length;

        int n1,n2 = -1;

        if(totalLength%2==0){
            n1=totalLength/2;
            n2=n1-1;
        }else{
            n1=(totalLength+1)/2-1;
        }


        int i=0;
        int x=0,y=0;
        int a=0,b=0;

        while(i<=n1){
            b=a;

            if(y>nums2.length-1){
                a=nums1[x++];
            }else if(x>nums1.length-1){
                a=nums2[y++];
            }else{
                if(nums1[x]<=nums2[y]){
                    a=nums1[x++];
                }else{
                    a=nums2[y++];
                }
            }

            i++;
        }

        if(n2 == -1){
            System.out.println(Double.valueOf(a));
        }else{
            System.out.println(Double.valueOf(a+b)/2);
        }


    }
}
