package data

object Constants {
    const val SPECIAL_COMMAND_EXIT = "exit"
    const val ERROR_EMPTY_MESSAGE = "Empty command received. Please try again."
    const val ERROR_NO_OPERATOR = "No valid operator was found. Please try again."
    const val ERROR_GENERIC_INVALID_INPUT = "Invalid command received. Please try again."
    const val ERROR_INVALID_DENOMINATOR = "Invalid fraction denominator. Please try again."

    val LEGAL_OPERATORS = listOf("+", "-", "*", "/")
}
