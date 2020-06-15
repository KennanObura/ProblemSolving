package TutorialHorizon;

/**
 * Given a 2D matrix of characters.
 * Check whether the word exist in the matrix or not. If it exists then print its path.
 * All movements are allowed (right, left, up, down and diagonally
 */
public class SearchForWordInMatrix {
    public static void main(String[] args) {

        Character[][] grid = {
                {'t', 'z', 'x', 'c', 'd'},
                {'a', 'h', 'n', 'z', 'x'},
                {'h', 'w', 'o', 'i', 'o'},
                {'o', 'r', 'n', 'r', 'n'},
                {'a', 'b', 'r', 'i', 'n'}};

        Matrix matrix = new Matrix(grid);
        matrix.search("horizon");


    }

    private static class Matrix {
        private final Character[][] grid;
        private final Integer[][] solution;
        private int path = 1;

        Matrix(Character[][] grid) {
            this.grid = grid;
            solution = new Integer[grid.length][grid[0].length];

            for (int i = 0; i < solution.length; i++)
                for (int j = 0; j < solution[0].length; j++)
                    solution[i][j] = 0;
//
//            Print<Character> charMatrix = new Print<Character>(grid);
//            Print<Integer> solMatrix = new Print<Integer>(solution);
        }


        void search(String word) {
            boolean exists = search(grid.length, word);
            if (exists) new Print<Integer>(solution);
            else System.out.println(word + ": does not exist");
        }

        private boolean search(int N, String word) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (search(i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean search(int row, int col, String word, int index) {

            if (word.charAt(index) != grid[row][col] || solution[row][col] != 0)
                return false;

            if (index == word.length() - 1) {
                solution[row][col] = path++;
                return true;
            }

            solution[row][col] = path++;
//            move right
            if (canMove(solution, row + 1, col) && search(row + 1, col, word, index + 1))
                return true;

//            move left
            if (canMove(solution, row - 1, col) && search(row - 1, col, word, index + 1))
                return true;

//            move down
            if (canMove(solution, row, col + 1) && search(row, col + 1, word, index + 1))
                return true;

//            move up
            if (canMove(solution, row, col - 1) && search(row, col - 1, word, index + 1)) {
                return true;
            }

//            move up left
            if (canMove(solution, row - 1, col - 1) && search(row - 1, col - 1, word, index + 1))
                return true;

//            move up right
            if (canMove(solution, row + 1, col - 1) && search(row + 1, col - 1, word, index + 1))
                return true;

//            move down left
            if (canMove(solution, row - 1, col + 1) && search(row - 1, col + 1, word, index + 1))
                return true;

//            move up right
            if (canMove(solution, row + 1, col + 1) && search(row + 1, col + 1, word, index + 1))
                return true;

            //back track if solution not found
            solution[row][col] = 0;
            path--;

            return false;
        }


        private boolean canMove(Integer[][] solution, int row, int col) {
            int width = solution.length;
            int height = solution[0].length;
            return (row > -1 && col > -1 && row < width && col < height && solution[row][col] == 0);
        }

    }

    private static class Print<T> {
        T[][] matrix;

        Print(T[][] matrix) {
            this.matrix = matrix;
            this.init();
        }

        private void init() {
            for (T[] ts : matrix) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(" " + ts[j]);
                }
                System.out.println();
            }
        }
    }
}


