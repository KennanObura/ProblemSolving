package TutorialHorizon

fun main(args: Array<String>) {
    val chase = Chase(4)
    chase.placed()
}

private class Chase(private val N: Int) {
    val board: Array<IntArray> = Array(N) { IntArray(N) }
    private var queens = 0

    init {
        for (i in 0 until N)
            for (j in 0 until N)
                board[i][j] = 0
    }

    fun placed() {
        if (canPlace(board, 0)) print()
        else print("cant be placed")

    }

    private fun print() {
        for (i in board.indices) {
            for (j in board.indices) {
                kotlin.io.print("   " + board[i][j])
            }
            println()
        }
    }


    private fun canPlace(board: Array<IntArray>, col: Int): Boolean {
        if (col == N) return true

        for (i in 0 until N) {
            if (isSafeToPlace(board, i, col)) {
                board[i][col] = 1
                if (canPlace(board, col + 1)) return true
            }
            board[i][col] = 0
        }
        return false
    }

    private fun isSafeToPlace(board: Array<IntArray>, row: Int, col: Int): Boolean {

        /* Check this row on left side */

        var i: Int = 0
        while (i < col)
            if (board[row][i++] != 0) return false


        /* Check upper diagonal on left side */


        i = row
        var j: Int = col
        while (i >= 0 && j >= 0)
            if (board[i--][j--] != 0) return false


        /* Check lower diagonal on left side */

        i = row
        j = col
        while (j >= 0 && i < N)
            if (board[i++][j--] != 0) return false


        return true
    }

}