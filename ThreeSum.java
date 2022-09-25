import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        execute(new int[]{-1,0,1,2,-1,-4});
    }

    public static List<List<Integer>> execute(int[] nums){
        Arrays.sort(nums);
        int i=0,j=0, k=0;
        Set<List<Integer>> returnList = new HashSet<List<Integer>>();
        while(i<nums.length-2){
            j=i+1;
            k=nums.length-1;
            while (j<k){
                int value = nums[i] + nums[j] + nums[k];
                if(value == 0){
                    List<Integer> values = new ArrayList<Integer>();
                    values.add(nums[i]);
                    values.add(nums[j]);
                    values.add(nums[k]);
                    returnList.add(values);


                    while(nums[j] == nums[j+1] && j+1<k){
                        j++;
                    }

                    while(nums[k] == nums[k-1] && k-1>j){
                        k--;
                    }

                    k--;

                }else if(value > 0){
                    k--;
                }else {
                    j++;

                }
            }
            if(j>=k){
                i++;
            }
        }
        return new ArrayList(returnList);


    }



    /*public static List<List<Integer>> execute(int[] nums){

        Map<Integer, Set<Integer>> valueWithIndexes= new TreeMap<Integer, Set<Integer>>();

        for(int i=0; i< nums.length; i++){
            int value = nums[i];
            Set<Integer> indexes = valueWithIndexes.get(value);
            if(indexes == null){
                indexes = new TreeSet<Integer>();
            }
            indexes.add(i);
            valueWithIndexes.put(value, indexes);
        }
        Set<List<Integer>> uniqueSet = new HashSet<List<Integer>>();
        for(Integer value : valueWithIndexes.keySet()){
            Set<Integer> indexes = valueWithIndexes.get(value);
            for(Integer index: indexes){
                uniqueSet.addAll(checkThreeSum(index, value, valueWithIndexes));
            }
        }

        return new ArrayList<>(uniqueSet);

    }

    public static Set<List<Integer>> checkThreeSum(int currentIndex, int currentValue, Map<Integer, Set<Integer>> valueWithIndexes){
        int expectedValue = 0-currentValue;
        Set<List<Integer>> uniqueSet = new HashSet<List<Integer>>();

        for(Integer value : valueWithIndexes.keySet()){
            if(value >= currentValue){
                Set<Integer> indexes = valueWithIndexes.get(value);
                for(Integer index : indexes){
                    if(index > currentIndex){
                        int findValue = expectedValue - value;
                        if(findValue >=value){
                            Set<Integer> valueExistIndexes = valueWithIndexes.get(findValue);
                            if(null != valueExistIndexes){
                                for(Integer valueExistIndex : valueExistIndexes){
                                    if(valueExistIndex != currentIndex && valueExistIndex != index){
                                        List<Integer> returnList = new ArrayList<Integer>();
                                        returnList.add(currentValue);
                                        returnList.add(value);
                                        returnList.add(findValue);
                                        // Collections.sort(returnList);
                                        uniqueSet.add(returnList);
                                        break;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

        return uniqueSet;

    }*/


}
