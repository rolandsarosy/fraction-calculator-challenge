package input

import utils.InputOperations.checkOperandValidity
import kotlin.test.Test
import kotlin.test.assertEquals

class OperandValidityCheckTests {

    @Test
    fun `input with zero passes`() {
        assertEquals(true, checkOperandValidity("-0"))
    }

    @Test
    fun `input with positive passes`() {
        assertEquals(true, checkOperandValidity("323"))
    }

    @Test
    fun `input with negative sign at the end fails`() {
        assertEquals(false, checkOperandValidity("99-"))
    }

    @Test
    fun `input with negative sign between characters fails`() {
        assertEquals(false, checkOperandValidity("33-3"))
    }

    @Test
    fun `input with proper fraction as positive passes`() {
        assertEquals(true, checkOperandValidity("0/34"))
    }

    @Test
    fun `input with proper fraction as negative passes`() {
        assertEquals(true, checkOperandValidity("-3/3"))
    }

    @Test
    fun `input with proper fraction with negative sign before forward slash fails`() {
        assertEquals(false, checkOperandValidity("3-/3"))
    }

    @Test
    fun `input with proper fraction with negative sign after forward slash fails`() {
        assertEquals(false, checkOperandValidity("-43/-3"))
    }

    @Test
    fun `input with proper fraction with negative sign as the last character fails`() {
        assertEquals(false, checkOperandValidity("3/2-"))
    }

    @Test
    fun `input with proper fraction with negative sign between characters fails`() {
        assertEquals(false, checkOperandValidity("3/2-3"))
    }

    @Test
    fun `input with improper fraction as positive passes`() {
        assertEquals(true, checkOperandValidity("3&0/3"))
    }

    @Test
    fun `input with improper fraction as negative passes`() {
        assertEquals(true, checkOperandValidity("-0&1/3"))
    }

    @Test
    fun `input with improper fraction with zero whole and numerator passes`() {
        assertEquals(true, checkOperandValidity("-0&0/3"))
    }

    @Test
    fun `input with improper fraction with zero as denominator fails`() {
        assertEquals(false, checkOperandValidity("4&15/0"))
    }

    @Test
    fun `input with improper fraction with no character before ampersand fails`() {
        assertEquals(false, checkOperandValidity("&0/3"))
    }

    @Test
    fun `input with improper fraction with no character after ampersand fails`() {
        assertEquals(false, checkOperandValidity("-4&"))
    }
}
