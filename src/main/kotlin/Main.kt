import Constants.ERROR_EMPTY_MESSAGE
import Constants.ERROR_NO_OPERATOR
import Constants.LEGAL_OPERATORS
import Constants.SPECIAL_COMMAND_EXIT
import java.util.*

private val scanner = Scanner(System.`in`)

fun main() {
    while (true) {
        val inputString = if (scanner.hasNextLine()) scanner.nextLine() else break
        if (inputString.clear() == SPECIAL_COMMAND_EXIT) break
        println(parseInput(inputString))
    }
}

// Parses the input to make sure it is valid operation format.
fun parseInput(input: String) = when {
    input.isEmpty() -> ERROR_EMPTY_MESSAGE
    !input.containsElementFromList(LEGAL_OPERATORS) -> ERROR_NO_OPERATOR
    else -> parseOperation(input)
}

// Parses an operation and attempts to perform it.
private fun parseOperation(input: String): String {
    val splitElements = input.replace("\\s+".toRegex(), " ").split(" ")
    val operand1 = Fraction.fromString(splitElements[0])
    val operand2 = Fraction.fromString(splitElements[2])
    val operator = splitElements[1][0]

    return performOperation(operator, operand1, operand2)
}

private fun performOperation(operator: Char, operand1: Fraction, operand2: Fraction): String {
    return when (operator) {
        '+' -> (operand1 + operand2).toString()
        '-' -> (operand1 - operand2).toString()
        '*' -> (operand1 * operand2).toString()
        '/' -> (operand1 / operand2).toString()
        else -> throw IllegalArgumentException("Invalid operator: $operator")
    }
}
