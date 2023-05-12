package utils

fun String.containsElementFromList(items: List<String>) = items.any { operator -> this.contains(operator) }

fun String.clear(): String = this.lowercase().trim()