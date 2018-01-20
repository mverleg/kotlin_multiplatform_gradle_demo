package demo.alpha

import demo.gamma.multiplatform
import demo.beta.getPlatform
import kotlin.test.Test

class MainTest {
    @Test
    fun testDependencies() {
        multiplatform()
        getPlatform()
    }
}


