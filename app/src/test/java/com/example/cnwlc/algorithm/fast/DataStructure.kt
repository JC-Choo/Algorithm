package com.example.cnwlc.algorithm.fast

import org.junit.Test

class DataStructure {
    @Test
    fun 이진트리() {
        val tree = BinaryTree()
        tree.insertNode(5)
        tree.insertNode(8)
        tree.insertNode(7)
        tree.insertNode(10)
        tree.insertNode(9)
        tree.insertNode(11)

//        if (tree.removeNode(10)) {
//            println("노드 삭제")
//        }

//         tree.inorderTree(tree.rootNode, 0);
         tree.postorderTree(tree.rootNode, 0)
//        tree.preorderTree(tree.rootNode, 0)
    }
}