package input

import utils.InputOperations.isOperandValid
import kotlin.test.Test
import kotlin.test.assertEquals

class OperandValidityCheckTests {

    @Test
    fun `input with zero passes`() {
        assertEquals(true, isOperandValid("-0"))
    }

    @Test
    fun `input with positive passes`() {
        assertEquals(true, isOperandValid("323"))
    }

    @Test
    fun `input with negative sign at the end fails`() {
        assertEquals(false, isOperandValid("99-"))
    }

    @Test
    fun `input with negative sign between characters fails`() {
        assertEquals(false, isOperandValid("33-3"))
    }

    @Test
    fun `input with proper fraction as positive passes`() {
        assertEquals(true, isOperandValid("0/34"))
    }

    @Test
    fun `input with proper fraction as negative passes`() {
        assertEquals(true, isOperandValid("-3/3"))
    }

    @Test
    fun `input with proper fraction with negative sign before forward slash fails`() {
        assertEquals(false, isOperandValid("3-/3"))
    }

    @Test
    fun `input with proper fraction with negative sign after forward slash fails`() {
        assertEquals(false, isOperandValid("-43/-3"))
    }

    @Test
    fun `input with proper fraction with negative sign as the last character fails`() {
        assertEquals(false, isOperandValid("3/2-"))
    }

    @Test
    fun `input with proper fraction with negative sign between characters fails`() {
        assertEquals(false, isOperandValid("3/2-3"))
    }

    @Test
    fun `input with improper fraction as positive passes`() {
        assertEquals(true, isOperandValid("3&0/3"))
    }

    @Test
    fun `input with improper fraction as negative passes`() {
        assertEquals(true, isOperandValid("-0&1/3"))
    }

    @Test
    fun `input with improper fraction with zero whole and numerator passes`() {
        assertEquals(true, isOperandValid("-0&0/3"))
    }

    @Test
    fun `input with improper fraction with zero as denominator fails`() {
        assertEquals(false, isOperandValid("4&15/0"))
    }

    @Test
    fun `input with improper fraction with no character before ampersand fails`() {
        assertEquals(false, isOperandValid("&0/3"))
    }

    @Test
    fun `input with improper fraction with no character after ampersand fails`() {
        assertEquals(false, isOperandValid("-4&"))
    }
}
