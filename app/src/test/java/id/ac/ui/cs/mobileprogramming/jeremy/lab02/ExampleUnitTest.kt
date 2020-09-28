package id.ac.ui.cs.mobileprogramming.jeremy.lab02

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun counter_isCorrect(){
        val mainActivity = MainActivity()
        assertEquals("You made it to 10!", mainActivity.counterTextMessage())
    }

}