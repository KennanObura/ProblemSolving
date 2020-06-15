package TutorialHorizon

import java.util.*

fun main() {

    val trie = Trie()
    trie.insert("them")
    println("Trie contains 'them'? :" + trie.contains("them"))
}

private class Node(
    val MAX: Int = 26,
    var isLeaf: Boolean = false,
    var links: Array<Node?> = Array(MAX) {null}
)

private class Trie {


    private var root: Node = Node()
    

    fun insert(key: String) {
        root = insert(root, key)
    }

    private fun insert(root: Node, key: String): Node {
        var current = root
        for (i in key.indices) {
            val charIndx = key[i] - 'a'
            if(current.links[charIndx] == null)
                current.links[charIndx] = Node()

            println(current.links.contentToString())
            current = current.links[charIndx]!!
        }
        current.isLeaf = true
        return current
    }

//    fun contains(key: String): Boolean = contains(root, key)

     fun contains(key: String): Boolean {
        var current = root
        for (i in key.indices) {
            val charIndx = key[i] - 'a'
            if(current.links[charIndx] == null)
                return false
            current = current.links[charIndx]!!
            println(current.links.contentToString())
        }
        return (current != null && current.isLeaf)
    }
}