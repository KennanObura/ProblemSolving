package TutorialHorizon

import java.text.DecimalFormat


fun main(args: Array<String>) {
    val knight : KnightMove = KnightMove(4)
    knight.findPath()
}

private class KnightMove(length: Int) {
    private val solution: Array<IntArray> = Array(length) { IntArray(length) }


    init {
        for (i in 0 until length)
            for (j in 0 until length)
                solution[i][j] = 0
    }

    fun findPath(){
        val path : Path = Path(solution)
        path.findPath(0,0,0)
        path.print()
    }
}

private class Path(private val solution: Array<IntArray>) {
    private val length: Int = solution.size
    var path: Int = 0

    fun findPath(row: Int, col: Int, index: Int): Boolean {
        if (index == length * length - 1) return true

        if (solution[row][col] != 0) return false

        solution[row][col] = path++
        //move right down
        if (canMove(row + 2, col + 1, length) && findPath(row + 2, col + 1, index + 1))
            return true

        //move right up
        if (canMove(row + 2, col - 1, length) && findPath(row + 2, col - 1, index + 1))
            return true

        //move down right
        if (canMove(row + 1, col + 2, length) && findPath(row + 1, col + 2, index + 1))
            return true

        //move down left
        if (canMove(row - 1, col + 2, length) && findPath(row - 1, col + 2, index + 1))
            return true


        //move up right
        if (canMove(row + 1, col - 2, length) && findPath(row + 1, col - 2, index + 1))
            return true

        //move up left
        if (canMove(row - 1, col - 2, length) && findPath(row - 1, col - 2, index + 1))
            return true

        //move left down
        if (canMove(row - 2, col + 1, length) && findPath(row - 2, col + 1, index + 1))
            return true

        //move right up
        if (canMove(row - 2, col - 1, length) && findPath(row - 2, col - 1, index + 1))
            return true

        //No viable solution found . Remove from solution

        solution[row][col] = 0
        path--
        return false

    }

    private fun canMove(row: Int, col: Int, length: Int): Boolean =
        (row > -1 && row < length && col > -1 && col < length)

    fun print(){
        val twodigits = DecimalFormat("00")
        for (i in solution.indices) {
            for (j in solution.indices) {
                print("   " + twodigits.format(solution[i][j]))
            }
            println()
        }
    }

}