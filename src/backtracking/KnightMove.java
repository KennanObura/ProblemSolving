package backtracking;

import java.util.Arrays;

public class KnightMove {
    public static void main(String[] args) {

        Board board = new Board(4);
        board.solve();

    }


    private static class Board{
        private Board(int N){
            this.board = new int[N][N];
            this.N = N;
            this.length = N*N;

        }

        private final int[][] board;
        private final int N;
        private int path = 0;
        private final int length;


        private void solve(){

            if(knightPath(0,0, 0)) printPath();
            else System.out.println("No valid path");
        }

        private void printPath() {
            for(int [] colPath : board)
                System.out.println(Arrays.toString(colPath));
        }

        private boolean knightPath(int row, int col, int index){

            if(board[row][col] != 0) return false;

            System.out.println(path);
            board[row][col] = path++;

            if(index == length-1) return true;

            if(canMove(row+2, col+1) && knightPath(row+2, col+1, index+1)) return true;

            if(canMove(row+2, col-1) && knightPath(row+2, col-1, index+1)) return true;

            if(canMove(row-2, col+1) && knightPath(row-2, col+1, index+1)) return true;

            if(canMove(row-2, col-1) &&  knightPath(row-2, col-1, index+1)) return true;

            if(canMove(row+1, col+2) &&  knightPath(row+1, col+2, index+1)) return true;

            if(canMove(row-1, col+2) &&  knightPath(row-1, col+2, index+1)) return true;

            if(canMove(row+1, col-2) &&  knightPath(row+1, col-2, index+1)) return true;

            if(canMove(row-1, col-2) &&  knightPath(row-1, col-2, index+1)) return true;

            board[row][col] = 0;
            path--;

            return false;
        }

        public boolean canMove(int row, int col) {
            return row >= 0 && col >= 0 && row < N && col < N;
        }
    }



}


