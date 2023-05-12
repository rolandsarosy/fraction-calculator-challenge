package arithmetic

import utils.InputOperations
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WholeNumbersArithmeticTests {
    @Test
    fun `input with whole number additions calculates correctly`() {
        val input = "3 + 2"
        val expectedOutput = "5"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with whole number subtraction calculates correctly`() {
        val input = "3 - 2"
        val expectedOutput = "1"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with whole number subtraction resulting in negative whole calculates correctly`() {
        val input = "2 - 3"
        val expectedOutput = "-1"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with whole number multiplication calculates correctly`() {
        val input = "2 * 3"
        val expectedOutput = "6"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with whole number multiplication resulting in negative whole calculates correctly`() {
        val input = "2 * -3"
        val expectedOutput = "-6"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with whole number multiplication with double negatives calculates correctly`() {
        val input = "-2 * -3"
        val expectedOutput = "6"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with zero multiplication calculates correctly`() {
        val input = "-2 *  0"
        val expectedOutput = "0"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with whole number division resulting in whole positive calculates correctly`() {
        val input = "4 /  2"
        val expectedOutput = "2"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with whole number division resulting in whole negative calculates correctly`() {
        val input = "-4    /  2"
        val expectedOutput = "-2"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with whole number division resulting in proper positive fraction`() {
        val input = "1 / 2"
        val expectedOutput = "1/2"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with negative whole dividend resulting in proper negative fraction`() {
        val input = "-1 / 2"
        val expectedOutput = "-1/2"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with negative whole divisor resulting in proper negative fraction`() {
        val input = "1 /    -2"
        val expectedOutput = "-1/2"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with whole number division resulting in improper positive fraction`() {
        val input = "5  /  3"
        val expectedOutput = "1&2/3"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with double negative whole number division resulting in improper positive fraction`() {
        val input = "-5 / -3"
        val expectedOutput = "1&2/3"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with negative whole dividend resulting in improper negative fraction`() {
        val input = "-5 / 3"
        val expectedOutput = "-1&2/3"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with negative whole divisor resulting in improper negative fraction`() {
        val input = "5 / -3"
        val expectedOutput = "-1&2/3"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }

    @Test
    fun `input with zero as dividend resulting in zero`() {
        val input = "0 / -6"
        val expectedOutput = "0"
        Assertions.assertEquals(expectedOutput, InputOperations.parseOperation(input))
    }
}
