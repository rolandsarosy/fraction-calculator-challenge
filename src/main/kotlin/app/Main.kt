package app

import data.Constants.SPECIAL_COMMAND_EXIT
import utils.InputOperations
import utils.clear
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    while (true) {
        val input = if (scanner.hasNextLine()) scanner.nextLine().clear() else break
        if (input == SPECIAL_COMMAND_EXIT) break
        println(InputOperations.parseInput(input))
    }
}
