package input

import org.junit.jupiter.api.Test
import utils.InputOperations.checkOperationFormatValidity
import kotlin.test.assertEquals

class OperationFormatValidityCheckTests {

    @Test
    fun `input with missing second operand fails`() {
        assertEquals(false, checkOperationFormatValidity("3 -"))
    }

    @Test
    fun `input with invalid operand elements fails`() {
        assertEquals(false, checkOperationFormatValidity("3 *2 222223v sdfmdfmdf"))
    }

    @Test
    fun `input with invalid operator fails`() {
        assertEquals(false, checkOperationFormatValidity("3 % 222223"))
    }

    @Test
    fun `input with valid operation passes`() {
        assertEquals(true, checkOperationFormatValidity("3 * 3&3/3"))
    }
}
