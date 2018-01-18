package demo.beta

import kotlin.test.Test
import kotlin.test.assertTrue

expect class TestPlatform() {
    fun testGetPlatform()
}

class TestPlatformCommon() {
    @Test
    fun testTest() {
        assertTrue { false }
    }
}

