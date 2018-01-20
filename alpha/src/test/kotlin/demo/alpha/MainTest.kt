package demo.alpha

import demo.beta.getPlatform
import demo.gamma.multiplatform
import kotlin.test.Test

class MainTest {
    @Test
    fun testDependencies() {
        multiplatform()
        getPlatform()
    }
}


