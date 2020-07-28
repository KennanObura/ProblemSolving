package GeekforGeeks.TopBacktracking;

import java.util.Arrays;

public class NQueensProblem {
    public static void main(String[] args) {

        Board board = new Board(8);
        board.solve();
    }

    private static class Board{
        Board(int N){
            this.N = N;
            this.board = new int[N][N];
        }

        final private int N;
        final private int [][]board;


        void solve(){
            if(canPlace(0 )) printBoard();
            else System.out.println("NO PLACEMENT");
        }

        private boolean canPlace(int row) {

            if(row == N) return true;

            for (int i = 0; i < N ; i++) {
                if(canSafelyPlace(row, i)) {
                    board[row][i] = 1;
                    if (canPlace(row + 1))
                        return true;
                }
                board[row][i] = 0;
            }
            return false;
        }

        private boolean canSafelyPlace(int row, int col) {
            int i = row;
            while(i > -1) if(board[i--][col] != 0) return false;

            i = row;
            int j = col;
            while (i > -1 && j > -1) if(board[i--][j--] != 0) return false;

            j = col;
            while (j > -1) if (board[row][j--] != 0) return false;

            return true;
        }

        private void printBoard() {
            for (int [] cols : board)
                System.out.println(Arrays.toString(cols));
        }
    }
}
