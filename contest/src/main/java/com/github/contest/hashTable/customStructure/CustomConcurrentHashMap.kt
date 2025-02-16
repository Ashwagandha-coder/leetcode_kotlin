package com.github.contest.hashTable.customStructure

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class CustomConcurrentHashMap<T> {


}


class MyConcurrentHashMap<K, V>(private val segmentCount: Int = 16) {

    private class Segment<K, V> {
        val entries = mutableListOf<Entry<K, V>>()
        val lock = ReentrantLock()

        fun get(key: K): V? = lock.withLock {
            entries.find { it.key == key }?.value
        }

        fun put(key: K, value: V): V? = lock.withLock {
            entries.find { it.key == key }?.let {
                val oldValue = it.value
                it.value = value
                oldValue
            } ?: run {
                entries.add(Entry(key, value))
                null
            }
        }

        fun remove(key: K): V? = lock.withLock {
            entries.find { it.key == key }?.let {
                entries.remove(it)
                it.value
            }
        }

        fun size(): Int = lock.withLock { entries.size }

        fun clear() = lock.withLock { entries.clear() }
    }

    private data class Entry<K, V>(val key: K, var value: V)

    private val segments: Array<Segment<K, V>> = Array(segmentCount) { Segment() }

    private fun getSegmentIndex(key: K): Int = key.hashCode().let { Math.abs(it % segmentCount) }

    fun get(key: K): V? = segments[getSegmentIndex(key)].get(key)

    fun put(key: K, value: V): V? = segments[getSegmentIndex(key)].put(key, value)

    fun remove(key: K): V? = segments[getSegmentIndex(key)].remove(key)

    fun size(): Int = segments.sumOf { it.size() }

    fun clear() {
        segments.forEach { it.clear() }
    }
}