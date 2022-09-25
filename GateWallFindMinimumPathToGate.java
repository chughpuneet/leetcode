import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GateWallFindMinimumPathToGate {
    public static void main(String[] args) {
        int[][] matrix = getMatrix();

        int[][] matrixChecked = new int[matrix.length][matrix[0].length];

        int gateX =0,gateY = 0;

        //find index of -2
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == -2){
                    gateX = i;
                    gateY = j;
                    break;
                }
            }
        }

        findGatePath(gateX, gateY, matrix, matrixChecked, 1);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println("");
        }

    }

    static class Node{
        int x;
        int y;
        int value;

        Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    private static void findGatePath(int gateX, int gateY, int[][] matrix, int[][] matrixChecked, int value){
        Queue<Node> queue = new LinkedList<Node>();
        Node node = new Node(gateX, gateY, value);
        queue.add(node);
        while (!queue.isEmpty()){
            Node node1 = queue.poll();
            value = node1.value;
            gateX = node1.x;
            gateY = node1.y;

         //   System.out.println(gateX + "," + gateY + " -> " + value);

            if(isValid(gateX + 1, gateY, matrix, value)){
                matrix[gateX + 1][gateY] = value;
                matrixChecked[gateX + 1][gateY] = value;
                queue.add(new Node(gateX + 1, gateY, value + 1));
            }
            if(isValid(gateX - 1, gateY, matrix, value)){
                matrix[gateX - 1][gateY] = value;
                matrixChecked[gateX - 1][gateY] = value;
                queue.add(new Node(gateX - 1, gateY, value + 1));
            }
            if(isValid(gateX, gateY + 1, matrix, value)){
                matrix[gateX][gateY+1] = value;
                matrixChecked[gateX][gateY+1] = value;
                queue.add(new Node(gateX, gateY + 1, value + 1));
            }

            if(isValid(gateX, gateY-1, matrix, value)){
                matrix[gateX][gateY-1] = value;
                matrixChecked[gateX][gateY-1] = value;
                queue.add(new Node(gateX, gateY - 1, value + 1));
            }
        }

    }

    private static boolean isValid(int x, int y, int[][] matrixChecked, int value){
        if(x>matrixChecked.length - 1 || x < 0 || y>matrixChecked[0].length -1|| y<0 || matrixChecked[x][y] == -2 || matrixChecked[x][y] == -1){
            return false;
        }

        if(matrixChecked[x][y] != 0 && matrixChecked[x][y] <= value ){
            return false;
        }
        return true;
    }

    private static int[][] getMatrix(){
        int[][] matrix = new int[10000][10000];
        /*IntStream.range(0,2).forEach(x->{
            IntStream.range(0,3).forEach(y->
            {
                matrix[x][y] = 0;
            });
        });*/
        matrix[1][2] = -1;
        matrix[1][3] = -2;
        return matrix;
    }
}


