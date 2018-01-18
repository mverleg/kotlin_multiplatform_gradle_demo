package demo.beta

import demo.beta.getPlatform
import kotlin.test.Test
import kotlin.test.assertTrue

actual class TestPlatform actual constructor() {
    @Test
    actual fun testGetPlatform() {
        assertTrue { "js" in getPlatform().toLowerCase() }
    }
}

