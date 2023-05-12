package utils

import data.Constants.ERROR_EMPTY_MESSAGE
import data.Constants.ERROR_NO_OPERATOR
import data.Constants.LEGAL_OPERATORS
import data.Fraction

object InputOperations {
    @JvmStatic
    fun parseInput(input: String) = when {
        input.isEmpty() -> ERROR_EMPTY_MESSAGE
        !input.containsElementFromList(LEGAL_OPERATORS) -> ERROR_NO_OPERATOR
        else -> parseOperation(input)
    }

    @JvmStatic
    fun parseOperation(input: String): String {
        val splitElements = input.replace("\\s+".toRegex(), " ").split(" ")
        val operand1 = Fraction.fromString(splitElements[0])
        val operand2 = Fraction.fromString(splitElements[2])
        val operator = splitElements[1][0]

        return performOperation(operator, operand1, operand2)
    }

    @JvmStatic
    private fun performOperation(operator: Char, operand1: Fraction, operand2: Fraction): String {
        return when (operator) {
            '+' -> (operand1 + operand2).toString()
            '-' -> (operand1 - operand2).toString()
            '*' -> (operand1 * operand2).toString()
            '/' -> (operand1 / operand2).toString()
            else -> throw IllegalArgumentException("Invalid operator: $operator")
        }
    }
}
