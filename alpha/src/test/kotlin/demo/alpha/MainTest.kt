package demo.alpha

import demo.gamma.Gamma
import demo.beta.Beta
import kotlin.test.Test

class MainTest {
    @Test
    fun testDependencies() {
        Gamma().multiplatform()
        Beta().getPlatform()
    }
}


