package com.example.cnwlc.algorithm

class Outer {
    val foo = "Outside nested class"

    class Nested {
        // 참조 불가
//        fun callMe() = foo

        private val innerValue = 20
        fun callMe2() = "innerValue = $innerValue"
    }

    val outerValue = 10
    inner class Nested2 {
        private val innerValue = 20
        fun callMe() {
            println("inner : $innerValue, out : $outerValue")
            println("inner : $innerValue, out : ${this@Outer.outerValue}")
        }
    }

    fun printItems() {
        val inner = Nested2()
        inner.callMe()
    }
}

fun main(args: Array<String>) {
    // 참조 불가
//    val outer = Outer()
//    println(outer.Nested().callMe())

    // 참조 가능
    val nested = Outer.Nested()
    println(nested.callMe2())



    val outer = Outer()
    println(outer.printItems())

//    println(outer.Nested2().callMe())
}