import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Testing proper arithmetic functionality, taking only valid inputs into consideration.
 */
class ArithmeticTests {

    @Test
    fun `input with whole number additions calculates correctly`() {
        val input = "3 + 2"
        val expectedOutput = "5"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with whole number subtraction calculates correctly`() {
        val input = "3 - 2"
        val expectedOutput = "1"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with whole number subtraction resulting in negative whole calculates correctly`() {
        val input = "2 - 3"
        val expectedOutput = "-1"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with whole number multiplication calculates correctly`() {
        val input = "2 * 3"
        val expectedOutput = "6"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with whole number multiplication resulting in negative whole calculates correctly`() {
        val input = "2 * -3"
        val expectedOutput = "-6"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with whole number multiplication with double negatives calculates correctly`() {
        val input = "-2 * -3"
        val expectedOutput = "6"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with zero multiplication calculates correctly`() {
        val input = "-2 *  0"
        val expectedOutput = "0"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with whole number division resulting in whole positive calculates correctly`() {
        val input = "4 /  2"
        val expectedOutput = "2"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with whole number division resulting in whole negative calculates correctly`() {
        val input = "-4    /  2"
        val expectedOutput = "-2"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with whole number division resulting in proper positive fraction`() {
        val input = "1 / 2"
        val expectedOutput = "1/2"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with negative whole dividend resulting in proper negative fraction`() {
        val input = "-1 / 2"
        val expectedOutput = "-1/2"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with negative whole divisor resulting in proper negative fraction`() {
        val input = "1 /    -2"
        val expectedOutput = "-1/2"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with whole number division resulting in improper positive fraction`() {
        val input = "5  /  3"
        val expectedOutput = "1&2/3"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with double negative whole number division resulting in improper positive fraction`() {
        val input = "-5 / -3"
        val expectedOutput = "1&2/3"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with negative whole dividend resulting in improper negative fraction`() {
        val input = "-5 / 3"
        val expectedOutput = "-1&2/3"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with negative whole divisor resulting in improper negative fraction`() {
        val input = "5 / -3"
        val expectedOutput = "-1&2/3"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with zero as dividend resulting in zero`() {
        val input = "0 / -6"
        val expectedOutput = "0"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction addition results in proper fraction`() {
        val input = "1/2 + 1/4"
        val expectedOutput = "3/4"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction addition results in simplified proper fraction`() {
        val input = "6/12 + 4/16"
        val expectedOutput = "3/4"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction addition handles zero numerator in operand`() {
        val input = "6/12 + 0/23342"
        val expectedOutput = "1/2"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction addition resulting in whole calculates correctly`() {
        val input = "6/12 + 8/16"
        val expectedOutput = "1"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction addition with only zero numerators results in zero`() {
        val input = "0/123 + 0/659"
        val expectedOutput = "0"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction addition where an operand is zero calculates correctly`() {
        val input = "0 + 1/4"
        val expectedOutput = "1/4"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction addition where an operand is negative calculates correctly`() {
        val input = "-1/4 + 2/4"
        val expectedOutput = "1/4"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction addition where both operands are negative calculates correctly`() {
        val input = "-1/4 + -1/4"
        val expectedOutput = "-1/2"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction addition where an operand is negative and the combined value is zero calculates correctly`() {
        val input = "-1/4 + 2/8"
        val expectedOutput = "0"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with simple proper fraction subtraction calculates correctly`() {
        val input = "2/4 - 1/4"
        val expectedOutput = "1/4"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with simple proper fraction subtraction calculates and simplifies correctly`() {
        val input = "4/8 - 2/8"
        val expectedOutput = "1/4"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction subtraction results in negative value`() {
        val input = "1/4 - 2/4"
        val expectedOutput = "-1/4"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction subtraction resulting in zero calculates correctly`() {
        val input = "2/4 - 8/16"
        val expectedOutput = "0"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with double negative proper fraction subtraction results in positive proper fraction`() {
        val input = "-1/4 - -1/3"
        val expectedOutput = "1/12"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with negative proper fraction subtraction calculates and simplifies correctly`() {
        val input = "-1/4 - 1/4"
        val expectedOutput = "-1/2"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with simple proper fraction multiplication calculates correctly`() {
        val input = "3/4 * 2/3"
        val expectedOutput = "1/2"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction multiplication resulting in whole calculates correctly`() {
        val input = "3 * 1/3"
        val expectedOutput = "1"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction multiplication resulting in improper fraction`() {
        val input = "4/1 * 1/3"
        val expectedOutput = "1&1/3"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction multiplication resulting in negative whole calculates correctly`() {
        val input = "-6/2 * 8/4"
        val expectedOutput = "-6"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction multiplication resulting in negative improper calculates correctly`() {
        val input = "-4/1 * 1/3"
        val expectedOutput = "-1&1/3"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction multiplication where an operand is zero results in zero correctly`() {
        val input = "-0/3 * 6/13"
        val expectedOutput = "0"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction addition results in simplified improper fraction`() {
        val input = "15/12 + 4/16"
        val expectedOutput = "1&1/2"
        assertEquals(expectedOutput, parseInput(input))
    }


    // testing division with proper fractions
    //
    // dividend positive, divisor positive --
    // dividend positive, divisor negative --
    // dividend negative, divisor positive
    // dividend negative, divisor negative --
    // dividend is zero --
    // result is proper fraction --
    // result is improper fraction --
    // result is whole --

    @Test
    fun `input with proper positive fractions divides correctly`() {
        val input = "1/2 / 2/3"
        val expectedOutput = "3/4"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper negative fractions divides correctly`() {
        val input = "-3/2 / -2/3"
        val expectedOutput = "2&1/4"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fraction where dividend is zero calculates correctly`() {
        val input = "-0/2 / 2/3"
        val expectedOutput = "0"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fractions where divisor is negative calculates correctly`() {
        val input = "1/2 / -1/2"
        val expectedOutput = "-1"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with proper fractions where dividend is negative calculates correctly`() {
        val input = "-15/10 / 2/3"
        val expectedOutput = "-2&1/4"
        assertEquals(expectedOutput, parseInput(input))
    }

    // testing with improper fractions

    // --- testing addition with improper fractions ---
    // simple addition with two improper fractions - CHECK
    // addition with a whole and an improper fraction - CHECK
    // addition with a proper and improper fraction - CHECK
    // a case where it simplifies too - CHECK

    @Test
    fun `input with simple improper fraction addition calculates correctly`() {
        val input = "3&1/3 + 2&1/2"
        val expectedOutput = "5&5/6"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper and proper fraction addition calculates correctly`() {
        val input = "3&1/3 + 6/7"
        val expectedOutput = "4&4/21"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper fraction and whole addition calculates and simplifies correctly`() {
        val input = "3&8/16 + 2"
        val expectedOutput = "5&1/2"
        assertEquals(expectedOutput, parseInput(input))
    }

    // --- testing subtraction with improper fractions ---
    // subtraction with two improper fractions resulting in positive - CHECK
    // subtraction with two improper fractions resulting in negative - CHECK
    // subtraction with two improper fractions resulting in zero - CHECK

    @Test
    fun `input with improper fraction subtraction resulting in positive calculates correctly`() {
        val input = "2&1/12 - 1&1/8"
        val expectedOutput = "23/24"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper fraction subtraction resulting in negative calculates correctly`() {
        val input = "1&1/8 - 2&1/12"
        val expectedOutput = "-23/24"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper and proper fraction subtraction resulting in zero calculates correctly`() {
        val input = "1&1/8 - 18/16"
        val expectedOutput = "0"
        assertEquals(expectedOutput, parseInput(input))
    }

    // --- testing multiplication with improper fractions ---
    // simple multiplication with two improper fractions - CHECK
    // multiplication with two improper fractions where one is negative - CHECK
    // multiplication with two improper fractions where both are negative - CHECK
    // multiplication with a proper and improper fraction (let's say one is negative) - CHECK
    // multiplication with an improper fraction and a whole (let's say both are negative) - CHECK
    // multiplication with improper fractions where there is a zero operand - CHECK

    @Test
    fun `input with improper fractions multiplication calculates correctly`() {
        val input = "3&0/23 * 1&1/1"
        val expectedOutput = "6"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper fraction multiplication with one negative operand calculates correctly`() {
        val input = "-3&0/23 * 1&1/1"
        val expectedOutput = "-6"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper fraction multiplication with both operands being negative calculates correctly`() {
        val input = "-3&0/23 * -1&1/1"
        val expectedOutput = "6"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper and proper fraction multiplication calculates correctly`() {
        val input = "-3&0/23 * 1/2"
        val expectedOutput = "-1&1/2"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper fraction and whole multiplication calculates correctly`() {
        val input = "-3&0/23 * -3"
        val expectedOutput = "9"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper fraction multiplication with a zero operand calculates correctly`() {
        val input = "-0&0/23 * 2/123"
        val expectedOutput = "0"
        assertEquals(expectedOutput, parseInput(input))
    }

    // --- testing division with improper fractions ---
    // simple division with two improper fractions - CHECK
    // division with two improper fractions where one is negative - CHECK
    // division with two improper fractions where both are negative - CHECK
    // division with two improper fractions where dividend is 0 - CHECK
    // division with a proper and improper fraction (let's say one is negative) - CHECK
    // division with a whole and an improper fraction (let's say both are negative) - CHECK

    @Test
    fun `input with simple improper fraction division calculates correctly`() {
        val input = "1&2/17 / 3&1/8"
        val expectedOutput = "152/425"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper fraction division with negative divisor calculates correctly`() {
        val input = "1&2/17 / -3&1/8"
        val expectedOutput = "-152/425"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper fraction division with both operands being negative calculates correctly`() {
        val input = "-1&2/17 / -3&1/8"
        val expectedOutput = "152/425"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper fraction division with zero dividend calculates correctly`() {
        val input = "-0&0/17 / -3&1/8"
        val expectedOutput = "0"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper fraction division resulting in improper fraction calculates correctly`() {
        val input = "-3&2/4 / 1&1/2"
        val expectedOutput = "-2&1/3"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper and proper fraction division calculates correctly`() {
        val input = "-3&2/4 / 1/2"
        val expectedOutput = "-7"
        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `input with improper fraction and whole division calculates correctly`() {
        val input = "-3&1/3 / -4"
        val expectedOutput = "5/6"
        assertEquals(expectedOutput, parseInput(input))
    }
}
