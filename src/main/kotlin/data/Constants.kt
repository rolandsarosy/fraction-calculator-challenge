package data

object Constants {
    const val SPECIAL_COMMAND_EXIT = "exit"
    const val ERROR_EMPTY_MESSAGE = "Empty command received. Please try again."
    const val ERROR_NO_OPERATOR = "No valid operator was found. Please try again."
    const val ERROR_INVALID_OPERATION_FORMAT = "Invalid operation format received. Please try again."
    const val ERROR_INVALID_FIRST_OPERAND = "First operand was invalid. Please try again."
    const val ERROR_INVALID_LAST_OPERAND = "Last operand was invalid. Please try again."

    val LEGAL_OPERATORS = mapOf(
        '+' to Fraction::plus,
        '-' to Fraction::minus,
        '*' to Fraction::times,
        '/' to Fraction::div
    )
}
