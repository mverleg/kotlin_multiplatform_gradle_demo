package demo.gamma

import kotlin.test.Test
import kotlin.test.assertSame

class GammaTest {
    @Test
    fun testMultiplatform() {
        assertSame("okay", Gamma().multiplatform())
    }
}

