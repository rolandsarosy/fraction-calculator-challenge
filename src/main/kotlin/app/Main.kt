package app

import data.Constants.SPECIAL_COMMAND_EXIT
import utils.InputOperations
import utils.clear
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    while (true) {
        val inputString = if (scanner.hasNextLine()) scanner.nextLine() else break
        if (inputString.clear() == SPECIAL_COMMAND_EXIT) break
        println(InputOperations.parseInput(inputString))
    }
}
