package com.github.contest.slidingWindow.customStructure


fun rabinKarpSearch(text: String, pattern: String): List<Int> {
    val d = 256 // Размер алфавита (ASCII)
    val q = 101 // Простое число для избежания переполнения
    val m = pattern.length
    val n = text.length
    var patternHash = 0 // Хеш образца
    var textHash = 0 // Хеш текущего окна в тексте
    var h = 1 // Значение для "скользящего" хеша: h = d^(m-1)
    val result = mutableListOf<Int>()

    if (n < m || m == 0 || n == 0) return result

    // Вычисляем h = d^(m-1) % q
    for (i in 0 until m - 1) {
        h = (h * d) % q
    }

    // Вычисляем начальные хеши для образца и первого окна текста
    for (i in 0 until m) {
        patternHash = (d * patternHash + pattern[i].code) % q
        textHash = (d * textHash + text[i].code) % q
    }

    // Проходим по тексту
    for (i in 0..n - m) {
        // Если хеши совпали, проверяем символы один за другим
        if (patternHash == textHash) {
            var match = true
            for (j in 0 until m) {
                if (text[i + j] != pattern[j]) {
                    match = false
                    break
                }
            }
            if (match) {
                result.add(i)
            }
        }

        // Вычисляем хеш для следующего окна текста
        if (i < n - m) {
            textHash = (d * (textHash - text[i].code * h) + text[i + m].code) % q
            // Обеспечиваем положительное значение хеша
            if (textHash < 0) textHash += q
        }
    }

    return result
}

fun rabinKarpMultiPattern(text: String, patterns: List<String>): Map<String, List<Int>> {
    val d = 256
    val q = 101
    val result = mutableMapOf<String, MutableList<Int>>()
    val patternHashes = mutableMapOf<Int, MutableList<String>>()

    // Предварительно вычисляем хеши всех образцов
    for (pattern in patterns.distinct()) {
        val patternLen = pattern.length
        if (patternLen == 0 || patternLen > text.length) continue

        var hash = 0
        for (i in 0 until patternLen) {
            hash = (d * hash + pattern[i].code) % q
        }

        patternHashes.getOrPut(hash) { mutableListOf() }.add(pattern)
        result[pattern] = mutableListOf()
    }

    // Ищем все возможные длины образцов
    val lengths = patterns.map { it.length }.distinct().sorted()

    for (m in lengths) {
        if (m == 0 || m > text.length) continue

        var h = 1
        for (i in 0 until m - 1) {
            h = (h * d) % q
        }

        var textHash = 0
        // Вычисляем хеш первого окна
        for (i in 0 until m) {
            textHash = (d * textHash + text[i].code) % q
        }

        // Проверяем первый хеш
        patternHashes[textHash]?.forEach { pattern ->
            if (pattern.length == m && text.startsWith(pattern, 0)) {
                result[pattern]?.add(0)
            }
        }

        // Скользим по тексту
        for (i in 1..text.length - m) {
            // Обновляем хеш
            textHash = (d * (textHash - text[i - 1].code * h) + text[i + m - 1].code) % q
            if (textHash < 0) textHash += q

            // Проверяем совпадения
            patternHashes[textHash]?.forEach { pattern ->
                if (pattern.length == m && text.startsWith(pattern, i)) {
                    result[pattern]?.add(i)
                }
            }
        }
    }

    return result
}

fun slidingWindowClassic(text: String, patterns: List<String>): List<Int> {
    val res = mutableListOf<Int>()

    for (pattern in patterns) {
        val window = pattern.length
        text.windowed(window) {
            if (it == pattern) res.add(0)
        }
    }

    return res
}