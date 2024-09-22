package com.leetcode_kotlin



fun filter() {

    val doSome = mapOf<String, String>("m" to "d", "a" to "b", "c" to "d", "q" to "z")
    doSome.size
    doSome.isEmpty()
    doSome.keys
    doSome.values
    doSome.getValue("m")
    val action: (Map.Entry<String, String>) -> Unit = {
        it.toPair()
    }
    doSome.forEach(action)
    mutableListOf(1).forEach {

    }
    doSome.myFun {
        println()
    }

}

private fun <K, V> Map<K, V>.myFun(lambda: (V) -> Unit) {
    TODO("Not yet implemented")
}


inline fun <K, V> Map.Entry<K, V>.myFun(lambda: (action: String) -> Unit) {
    lambda.invoke("Base")
}
inline fun print(lambda: (out: String) -> Unit) {

}
