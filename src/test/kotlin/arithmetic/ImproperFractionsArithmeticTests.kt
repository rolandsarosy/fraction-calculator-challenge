package arithmetic

import utils.InputOperations
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ImproperFractionsArithmeticTests {
    @Test
    fun `input with simple improper fraction addition calculates correctly`() {
        val input = "3&1/3 + 2&1/2"
        val expectedOutput = "5&5/6"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper and proper fraction addition calculates correctly`() {
        val input = "3&1/3 + 6/7"
        val expectedOutput = "4&4/21"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fraction and whole addition calculates and simplifies correctly`() {
        val input = "3&8/16 + 2"
        val expectedOutput = "5&1/2"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fraction subtraction resulting in positive calculates correctly`() {
        val input = "2&1/12 - 1&1/8"
        val expectedOutput = "23/24"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fraction subtraction resulting in negative calculates correctly`() {
        val input = "1&1/8 - 2&1/12"
        val expectedOutput = "-23/24"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper and proper fraction subtraction resulting in zero calculates correctly`() {
        val input = "1&1/8 - 18/16"
        val expectedOutput = "0"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fractions multiplication calculates correctly`() {
        val input = "3&0/23 * 1&1/1"
        val expectedOutput = "6"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fraction multiplication with one negative operand calculates correctly`() {
        val input = "-3&0/23 * 1&1/1"
        val expectedOutput = "-6"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fraction multiplication with both operands being negative calculates correctly`() {
        val input = "-3&0/23 * -1&1/1"
        val expectedOutput = "6"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper and proper fraction multiplication calculates correctly`() {
        val input = "-3&0/23 * 1/2"
        val expectedOutput = "-1&1/2"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fraction and whole multiplication calculates correctly`() {
        val input = "-3&0/23 * -3"
        val expectedOutput = "9"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fraction multiplication with a zero operand calculates correctly`() {
        val input = "-0&0/23 * 2/123"
        val expectedOutput = "0"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with simple improper fraction division calculates correctly`() {
        val input = "1&2/17 / 3&1/8"
        val expectedOutput = "152/425"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fraction division with negative divisor calculates correctly`() {
        val input = "1&2/17 / -3&1/8"
        val expectedOutput = "-152/425"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fraction division with both operands being negative calculates correctly`() {
        val input = "-1&2/17 / -3&1/8"
        val expectedOutput = "152/425"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fraction division with zero dividend calculates correctly`() {
        val input = "-0&0/17 / -3&1/8"
        val expectedOutput = "0"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fraction division resulting in improper fraction calculates correctly`() {
        val input = "-3&2/4 / 1&1/2"
        val expectedOutput = "-2&1/3"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper and proper fraction division calculates correctly`() {
        val input = "-3&2/4 / 1/2"
        val expectedOutput = "-7"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with improper fraction and whole division calculates correctly`() {
        val input = "-3&1/3 / -4"
        val expectedOutput = "5/6"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }
}
