package input

import app.main
import data.Constants
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.InputOperations
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class InputTests {

    @Test
    fun `input of 'exit' quits the program`() {
        val input = Constants.SPECIAL_COMMAND_EXIT
        val expectedOutput = "? "

        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        val actualOutput = outputStream.toString()
        assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `empty input shows relevant error message`() {
        val input = ""
        val expectedOutput = Constants.ERROR_EMPTY_MESSAGE
        assertEquals(expectedOutput, InputOperations.parseInput(input))
    }

    @Test
    fun `input with no operators shows relevant error message`() {
        val input = "this is a test message"
        val expectedOutput = Constants.ERROR_NO_OPERATOR
        assertEquals(expectedOutput, InputOperations.parseInput(input))
    }
}
