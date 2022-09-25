import sun.reflect.generics.tree.Tree;

import java.util.*;

public class AverageOfEachNodeInTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(19);

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        getAverageLevelValuesDepthSearch(root, map, 0);
        System.out.println(map);
        System.out.println(getAverageValues(root));

    }

    static void getAverageLevelValuesDepthSearch(TreeNode root,  Map<Integer, List<Integer>> map, int index){

            List<Integer> list = map.get(index);
            if(list == null){
                list = new ArrayList<Integer>();
            }
            list.add(root.value);
            map.put(index++, list);
            if(root.left != null)
                getAverageLevelValuesDepthSearch(root.left, map, index);
            if(root.right != null)
                getAverageLevelValuesDepthSearch(root.right, map, index);

    }

    static List<Double> getAverageValues(TreeNode root){
        // breadth first search
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        //add the element
        queue.add(root);

        List<Double> result = new ArrayList<Double>();
        List<TreeNode> nextLevel = new ArrayList<TreeNode>();

        Double sum = 0d;

        int index = 0;
        while(!queue.isEmpty()){
            ++index;
            TreeNode node = queue.poll();
            if(node.left != null){
                nextLevel.add(node.left);
            }
            if(node.right != null){
                nextLevel.add((node.right));
            }

            sum +=node.value;
            if(queue.isEmpty()){
                queue.addAll(nextLevel);
                Double avg = sum/index;
                result.add(avg);
                sum = 0d;
                index = 0;
                nextLevel = new ArrayList<TreeNode>();
            }
        }
        return result;
    }



    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value){
            this.value = value;
        }
    }
}
