package utils

import data.Constants.ERROR_EMPTY_MESSAGE
import data.Constants.ERROR_INVALID_FIRST_OPERAND
import data.Constants.ERROR_INVALID_LAST_OPERAND
import data.Constants.ERROR_INVALID_OPERATION_FORMAT
import data.Constants.ERROR_NO_OPERATOR
import data.Constants.LEGAL_OPERATORS
import data.Fraction

object InputOperations {
    private const val OPERATION_ELEMENTS_SIZE = 3

    @JvmStatic // Assumes any input, returns valid operation format.
    fun parseInput(input: String) = when {
        input.isEmpty() -> ERROR_EMPTY_MESSAGE
        !input.containsElementFromList(LEGAL_OPERATORS) -> ERROR_NO_OPERATOR
        !checkOperationFormatValidity(input) -> ERROR_INVALID_OPERATION_FORMAT
        else -> parseOperation(input)
    }

    @JvmStatic // Assumes a valid operation format, returns operands and operator.
    fun parseOperation(operationStr: String): String {
        val elements = splitOperation(operationStr)
        val operand1 = if (checkOperandValidity(elements[0])) elements[0] else return ERROR_INVALID_FIRST_OPERAND
        val operand2 = if (checkOperandValidity(elements[2])) elements[2] else return ERROR_INVALID_LAST_OPERAND

        return performOperation(elements[1][0], Fraction.fromString(operand1), Fraction.fromString(operand2))
    }

    @JvmStatic // Assumes a valid operation, returns operation result.
    private fun performOperation(operator: Char, operand1: Fraction, operand2: Fraction): String {
        return when (operator) {
            '+' -> (operand1 + operand2).toString()
            '-' -> (operand1 - operand2).toString()
            '*' -> (operand1 * operand2).toString()
            '/' -> (operand1 / operand2).toString()
            else -> throw IllegalArgumentException("Invalid operator: $operator")
        }
    }

    @JvmStatic
    fun checkOperationFormatValidity(operationStr: String): Boolean {
        val elements = splitOperation(operationStr)
        return elements.size == OPERATION_ELEMENTS_SIZE
                && elements[1].length == 1
                && elements[1].containsElementFromList(LEGAL_OPERATORS)
    }

    /**
     * This nightmare of a regex checks the validity of a potential operand. (https://i.imgur.com/IlUxK9T.jpg)
     *
     * It can check for all 3 types of possible operand inputs. (improper fraction, proper fraction, whole)
     * [-]? checks for an optional negative sign at the start
     *
     * The rest can be separated into 3 parts, one for each possible operand type:
     *
     * `\d+&\d+/[1-9]\d*` checks for a whole number, followed by an ampersand and a fraction with a non-zero denominator
     * `\d+/[1-9]\d*` checks for a fraction with a non-zero denominator
     * `\d+` matches a whole number.
     *
     * I do not like regex.
     */
    @JvmStatic
    fun checkOperandValidity(fractionStr: String): Boolean {
        val fractionRegex = """^-?(\d+&\d+/[1-9]\d*|\d+/[1-9]\d*|\d+)$""".toRegex()
        return fractionRegex.matches(fractionStr)
    }

    @JvmStatic
    private fun splitOperation(operationStr: String): List<String> {
        return operationStr.replace("\\s+".toRegex(), " ").split(" ")
    }
}
