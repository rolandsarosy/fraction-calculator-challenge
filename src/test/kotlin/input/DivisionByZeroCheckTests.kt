package input

import org.junit.jupiter.api.Test
import utils.InputOperations.isDivisionByZero
import kotlin.test.assertEquals

class DivisionByZeroCheckTests {

    @Test
    fun `input with whole zero fails`() {
        assertEquals(true, isDivisionByZero("3 / -0"))
    }

    @Test
    fun `input with proper fraction resulting in zero fails`() {
        assertEquals(true, isDivisionByZero("3 / 0/2"))
    }

    @Test
    fun `input with proper improper fraction resulting in zero fails`() {
        assertEquals(true, isDivisionByZero("3 / -0&0/3"))
    }

    @Test
    fun `input with proper fraction with zero whole but non-zero remainder passes`() {
        assertEquals(false, isDivisionByZero("3 / -0&2/3"))
    }
}
