package demo.beta

import kotlin.test.Test
import kotlin.test.assertTrue

actual class BetaTest actual constructor() {
    @Test
    actual fun testGetPlatform() {
        assertTrue { "jvm" in Beta().getPlatform().toLowerCase() }
    }
}


