package utils

fun String.containsElementFromList(items: List<Char>) = items.any { operator -> this.contains(operator) }

fun String.clear(): String = this.lowercase().trim()
