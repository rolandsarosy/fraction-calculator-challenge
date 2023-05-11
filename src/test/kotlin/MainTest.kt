import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainTest {

    @Test
    fun `input of 'exit' quits the program`() {
        val input = Constants.SPECIAL_COMMAND_EXIT
        val expectedOutput = ""

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
        val input = "\nexit\n"
        val expectedError = Constants.ERROR_EMPTY_MESSAGE

        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        val output = outputStream.toString()
        assert(output.contains(expectedError))
    }

    @Test
    fun `input with no operators shows relevant error message`() {
        val input = "this is a test message\nexit\n"
        val expectedError = Constants.ERROR_NO_OPERATOR

        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        main()

        val output = outputStream.toString()
        assert(output.contains(expectedError))
    }
}