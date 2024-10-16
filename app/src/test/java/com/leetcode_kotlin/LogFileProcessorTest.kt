package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class LogFileProcessorTest {

    @Test
    fun testProcessLogFile_insertsContextAroundSevereErrors() {
        val logLines = mutableListOf(
            "INFO: Starting the application",
            "SEVERE: Database connection failed",
            "DEBUG: Attempting to reconnect..."
        )

        processLogFile(logLines)

        val expectedLines = listOf(
            "INFO: Starting the application",
            "WARNING: Context Before Error",
            "SEVERE: Database connection failed",
            "DEBUG: Attempting to reconnect...",
            "Context After Error",
        )

        assertEquals(expectedLines, logLines)
    }

    @Test
    fun testProcessLogFile_doesNotModifyLogWithoutSevereErrors() {
        val logLines = mutableListOf(
            "INFO: Starting the application",
            "DEBUG: Initializing modules...", "INFO: Application ready"
        )

        processLogFile(logLines)

        val expectedLines = listOf(
            "INFO: Starting the application",
            "DEBUG: Initializing modules...",
            "INFO: Application ready"
        )

        assertEquals(expectedLines, logLines)
    }
}