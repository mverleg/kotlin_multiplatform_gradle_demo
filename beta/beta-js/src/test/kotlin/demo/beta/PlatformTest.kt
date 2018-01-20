package demo.beta

import kotlin.test.Test
import kotlin.test.assertTrue

actual class PlatformTest actual constructor() {
    @Test
    actual fun testGetPlatform() {
        assertTrue { "js" in Beta().getPlatform().toLowerCase() }
    }
}

