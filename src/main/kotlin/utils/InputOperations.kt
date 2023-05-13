package utils

import data.Constants.ERROR_DIVISION_BY_ZERO
import data.Constants.ERROR_EMPTY_MESSAGE
import data.Constants.ERROR_INVALID_FIRST_OPERAND
import data.Constants.ERROR_INVALID_LAST_OPERAND
import data.Constants.ERROR_INVALID_OPERATION_FORMAT
import data.Constants.ERROR_NO_OPERATOR
import data.Constants.LEGAL_OPERATORS
import data.Fraction

object InputOperations {
    private const val VALID_OPERATION_ELEMENTS_SIZE = 3
    private const val VALID_OPERAND_REGEX = """^-?(\d+&\d+/[1-9]\d*|\d+/[1-9]\d*|\d+)$"""

    @JvmStatic // Assumes any input, returns valid operation format.
    fun parseInput(input: String) = when {
        input.isEmpty() -> ERROR_EMPTY_MESSAGE
        !input.containsElementFromList(LEGAL_OPERATORS.keys.toList()) -> ERROR_NO_OPERATOR
        !isOperationFormatValid(input) -> ERROR_INVALID_OPERATION_FORMAT
        isDivisionByZero(input) -> ERROR_DIVISION_BY_ZERO
        else -> parseOperation(input)
    }

    @JvmStatic // Assumes a valid operation format, returns operands and operator.
    fun parseOperation(operationStr: String): String {
        val elements = splitOperation(operationStr)
        val operand1 = if (isOperandValid(elements[0])) elements[0] else return ERROR_INVALID_FIRST_OPERAND
        val operand2 = if (isOperandValid(elements[2])) elements[2] else return ERROR_INVALID_LAST_OPERAND

        return performOperation(elements[1][0], Fraction.fromString(operand1), Fraction.fromString(operand2))
    }

    @JvmStatic // Assumes a valid operation, returns operation result.
    private fun performOperation(operator: Char, operand1: Fraction, operand2: Fraction): String {
        val operation = LEGAL_OPERATORS[operator] ?: throw IllegalArgumentException("Invalid operator: $operator")
        return operation(operand1, operand2).toString()
    }

    @JvmStatic
    fun isOperationFormatValid(operationStr: String): Boolean {
        val elements = splitOperation(operationStr)
        return elements.size == VALID_OPERATION_ELEMENTS_SIZE
                && elements[1].length == 1
                && elements[1].containsElementFromList(LEGAL_OPERATORS.keys.toList())
    }

    @JvmStatic
    fun isDivisionByZero(operationStr: String): Boolean {
        val elements = splitOperation(operationStr.replace("-", ""))
        if (elements[1] != "/") return false
        if (elements[2].toIntOrNull() == 0) return true

        val fractionParts = elements[2].split("/")
        if (fractionParts.size == 2 && fractionParts[0] == "0") return true

        val improperFractionParts = elements[2].split("&")
        return improperFractionParts.size == 2 && improperFractionParts[0] == "0" && improperFractionParts[1].split("/")[0] == "0"
    }

    @JvmStatic
    fun isOperandValid(fractionStr: String) = VALID_OPERAND_REGEX.toRegex().matches(fractionStr)

    @JvmStatic
    private fun splitOperation(operationStr: String) = operationStr.replace("\\s+".toRegex(), " ").split(" ")
}
