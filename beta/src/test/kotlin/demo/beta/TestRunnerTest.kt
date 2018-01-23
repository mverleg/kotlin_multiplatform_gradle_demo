package demo.beta

import kotlin.test.Test
import kotlin.test.assertTrue

class TestRunnerTest() {
    @Test
    fun testIfTheyRun() {
        /* Use a failing assertion to confirm that tests are indeed ran. */
        assertTrue { false }
    }
}

