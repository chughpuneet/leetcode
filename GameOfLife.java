public class GameOfLife {
    public static void main(String[] args) {
        gameOfLife(new int[][]{new int[]{0,1,0},new int[]{0,0,1},new int[]{1,1,1},new int[]{0,0,0}});
    }

    public static void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j =0;j<board[i].length;j++){
                result[i][j] = findNeighborResult(board[i][j],i,j,board,board.length, board[0].length);
            }
        }
        board = result;
    }

    private static int findNeighborResult(int currentValue, int d, int e, int[][] board, int m , int n){
        int liveNeighbor = 0;
        int x=d, y=e;
        for (int a = -1; a<2 ; a++){
            x=a+d;
            if(x != -1 && x!=m){
                for(int b = -1;b<2;b++){
                    y=e+b;
                 if( y!=n && y!=-1){
                     if(!(x==d && y==e)){
                         int neighbor = board[x][y];
                         if(neighbor == 1){
                             liveNeighbor++;
                         }
                     }

                 }
                }
            }

        }

        if(currentValue == 1){
            if(liveNeighbor<2 || liveNeighbor >3 ){
                return 0;
            }

            if(liveNeighbor == 2 || liveNeighbor == 3){
                return 1;
            }
        }else if(currentValue == 0){
            if(liveNeighbor == 3){
                return 1;
            }
        }

        return currentValue;
    }
}
