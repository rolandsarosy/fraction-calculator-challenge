package arithmetic

import utils.InputOperations
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProperFractionsArithmeticTests {
    @Test
    fun `input with proper fraction addition results in proper fraction`() {
        val input = "1/2 + 1/4"
        val expectedOutput = "3/4"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction addition results in simplified proper fraction`() {
        val input = "6/12 + 4/16"
        val expectedOutput = "3/4"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction addition handles zero numerator in operand`() {
        val input = "6/12 + 0/23342"
        val expectedOutput = "1/2"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction addition resulting in whole calculates correctly`() {
        val input = "6/12 + 8/16"
        val expectedOutput = "1"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction addition with only zero numerators results in zero`() {
        val input = "0/123 + 0/659"
        val expectedOutput = "0"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction addition where an operand is zero calculates correctly`() {
        val input = "0 + 1/4"
        val expectedOutput = "1/4"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction addition where an operand is negative calculates correctly`() {
        val input = "-1/4 + 2/4"
        val expectedOutput = "1/4"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction addition where both operands are negative calculates correctly`() {
        val input = "-1/4 + -1/4"
        val expectedOutput = "-1/2"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction addition where an operand is negative and the combined value is zero calculates correctly`() {
        val input = "-1/4 + 2/8"
        val expectedOutput = "0"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with simple proper fraction subtraction calculates correctly`() {
        val input = "2/4 - 1/4"
        val expectedOutput = "1/4"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with simple proper fraction subtraction calculates and simplifies correctly`() {
        val input = "4/8 - 2/8"
        val expectedOutput = "1/4"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction subtraction results in negative value`() {
        val input = "1/4 - 2/4"
        val expectedOutput = "-1/4"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction subtraction resulting in zero calculates correctly`() {
        val input = "2/4 - 8/16"
        val expectedOutput = "0"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with double negative proper fraction subtraction results in positive proper fraction`() {
        val input = "-1/4 - -1/3"
        val expectedOutput = "1/12"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with negative proper fraction subtraction calculates and simplifies correctly`() {
        val input = "-1/4 - 1/4"
        val expectedOutput = "-1/2"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with simple proper fraction multiplication calculates correctly`() {
        val input = "3/4 * 2/3"
        val expectedOutput = "1/2"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction multiplication resulting in whole calculates correctly`() {
        val input = "3 * 1/3"
        val expectedOutput = "1"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction multiplication resulting in improper fraction`() {
        val input = "4/1 * 1/3"
        val expectedOutput = "1&1/3"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction multiplication resulting in negative whole calculates correctly`() {
        val input = "-6/2 * 8/4"
        val expectedOutput = "-6"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction multiplication resulting in negative improper calculates correctly`() {
        val input = "-4/1 * 1/3"
        val expectedOutput = "-1&1/3"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction multiplication where an operand is zero results in zero correctly`() {
        val input = "-0/3 * 6/13"
        val expectedOutput = "0"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction addition results in simplified improper fraction`() {
        val input = "15/12 + 4/16"
        val expectedOutput = "1&1/2"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper positive fractions divides correctly`() {
        val input = "1/2 / 2/3"
        val expectedOutput = "3/4"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper negative fractions divides correctly`() {
        val input = "-3/2 / -2/3"
        val expectedOutput = "2&1/4"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fraction where dividend is zero calculates correctly`() {
        val input = "-0/2 / 2/3"
        val expectedOutput = "0"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fractions where divisor is negative calculates correctly`() {
        val input = "1/2 / -1/2"
        val expectedOutput = "-1"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with proper fractions where dividend is negative calculates correctly`() {
        val input = "-15/10 / 2/3"
        val expectedOutput = "-2&1/4"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }
}
