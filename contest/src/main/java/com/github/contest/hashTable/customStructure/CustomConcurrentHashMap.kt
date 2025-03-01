package com.github.contest.hashTable.customStructure

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock


class MyConcurrentHashMap<K, V>(private val segmentCount: Int = 16) {

    private class HashEntry<K, V>(val key: K, var value: V, var next: HashEntry<K, V>?)

    private class Segment<K, V> {
        val lock = ReentrantLock()
        var table: Array<HashEntry<K, V>?> = arrayOfNulls(16)
        var count = 0

        fun get(key: K): V? = lock.withLock {
            val hash = key.hashCode()
            val index = hash % table.size
            var entry = table[index]
            while (entry != null) {
                if (entry.key == key) {
                    return entry.value
                }
                entry = entry.next
            }
            return null
        }

        fun put(key: K, value: V): V? = lock.withLock {
            val hash = key.hashCode()
            val index = hash % table.size
            var entry = table[index]
            while (entry != null) {
                if (entry.key == key) {
                    val oldValue = entry.value
                    entry.value = value
                    return oldValue
                }
                entry = entry.next
            }
            val newEntry = HashEntry(key, value, table[index])
            table[index] = newEntry
            count++
            if (count >= table.size * 0.75) {
                rehash()
            }
            return null
        }

        fun remove(key: K): V? = lock.withLock {
            val hash = key.hashCode()
            val index = hash % table.size
            var entry = table[index]
            var prev: HashEntry<K, V>? = null
            while (entry != null) {
                if (entry.key == key) {
                    if (prev == null) {
                        table[index] = entry.next
                    } else {
                        prev.next = entry.next
                    }
                    count--
                    return entry.value
                }
                prev = entry
                entry = entry.next
            }
            return null
        }

        private fun rehash() {
            val oldTable = table
            val newTableSize = table.size * 2
            table = arrayOfNulls(newTableSize)
            count = 0
            for (entry in oldTable) {
                var current = entry
                while (current != null) {
                    put(current.key, current.value)
                    current = current.next
                }
            }
        }
    }

    private val segments: Array<Segment<K, V>> = Array(segmentCount) { Segment() }

    private fun getSegment(key: K): Segment<K, V> {
        val hash = key.hashCode()
        val index = (hash ushr 16) % segmentCount
        return segments[index]
    }

    fun get(key: K): V? = getSegment(key).get(key)

    fun put(key: K, value: V): V? = getSegment(key).put(key, value)

    fun remove(key: K): V? = getSegment(key).remove(key)
}


class CustomConcurrentHashMap<K, V>(private val capacitySegments: Int = 16) {

    private data class HashEntry<K, V>(val key: K, var value: V, var next: HashEntry<K, V>?)


    private class Segment<K, V> {

        private val lock = ReentrantLock()
        private var table: Array<HashEntry<K, V>?> = arrayOfNulls(16)
        private var count = 0

        fun put(key: K, value: V): V? = lock.withLock {
            val hash = key.hashCode()
            val index = hash % table.size
            var entry = table[index]
            while (entry != null) {
                if (entry.key == key) {
                    val oldValue = entry.value
                    entry.value = value
                    return oldValue
                }
                entry = entry.next
            }
            entry = table[index]
            val newEntry = HashEntry(key, value, table[index])
            table[index] = newEntry
            count++
            if (count >= table.size * 0.75) rehash()
            return null
        }


        fun get(key: K): V? {
            val hash = key.hashCode()
            val index = hash % table.size
            var entry = table[index]
            while (entry != null) {
                if (entry.key == key) return entry.value
                entry = entry.next
            }

            return null
        }

        fun remove(key: K): V? = lock.withLock {
            val hash = key.hashCode()
            val index = hash % table.size
            var entry = table[index]
            var prev: HashEntry<K, V>? = null
            while (entry != null) {
                if (entry.key == key) {
                    if (prev == null) {
                        table[index] = entry.next
                    } else prev.next = entry.next
                    count--
                    return entry.value
                }
                prev = entry
                entry = entry.next
            }

            return null
        }


        private fun rehash() {
            val oldTable = table
            val newSize = table.size * 2
            table = arrayOfNulls(newSize)
            count = 0
            for (entry in oldTable) {
                var current = entry
                while (current != null) {
                    put(current.key, current.value)
                    current = current.next
                }
            }
        }

    }

    private val segments = Array<Segment<K, V>>(capacitySegments) { Segment() }

    fun put(key: K, value: V) = getSegment(key).let { it.put(key, value) }

    fun get(key: K): V? = getSegment(key).let { it.get(key) }

    private fun getSegment(key: K): Segment<K, V> {
        val hash = key.hashCode()
        val index = (hash ushr 16) % capacitySegments
        return segments[index]
    }


}













