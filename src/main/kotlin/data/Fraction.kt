package data

import kotlin.math.abs
import kotlin.math.sign

data class Fraction(val numerator: Int, val denominator: Int) {
    companion object {
        @JvmStatic
        fun fromString(fractionString: String): Fraction {
            val sign = if (fractionString.startsWith("-")) -1 else 1
            val fractionPart = fractionString.trim().removePrefix("-")
            val fractionComponents = fractionPart.split("&", "/").map { it.trim().toInt() }

            return when (fractionComponents.size) {
                3 -> Fraction(
                    numerator = sign * (fractionComponents[0] * fractionComponents[2] + fractionComponents[1]),
                    denominator = fractionComponents[2]
                )

                2 -> Fraction(
                    numerator = sign * fractionComponents[0],
                    denominator = fractionComponents[1]
                )

                1 -> Fraction(
                    numerator = sign * fractionComponents[0],
                    denominator = 1
                )

                else -> throw IllegalArgumentException("Invalid fraction format received.")
            }
        }
    }

    override fun toString(): String {
        val whole = numerator / denominator
        val remainder = numerator % denominator

        return when {
            whole != 0 && remainder != 0 -> "$whole&${simplifyFraction(Fraction(abs(remainder), abs(denominator)))}"
            whole != 0 -> "$whole"
            remainder != 0 -> "${remainder}/${abs(denominator)}"
            else -> "0"
        }
    }

    operator fun plus(other: Fraction): Fraction {
        val lcd = lcm(denominator, other.denominator)
        val numeratorSum = numerator * (lcd / denominator) + other.numerator * (lcd / other.denominator)
        return simplifyFraction(Fraction(numeratorSum, lcd))
    }

    operator fun minus(other: Fraction): Fraction {
        val lcd = lcm(denominator, other.denominator)
        val numeratorDiff = numerator * (lcd / denominator) - other.numerator * (lcd / other.denominator)
        return simplifyFraction(Fraction(numeratorDiff, lcd))
    }

    operator fun times(other: Fraction): Fraction {
        val numeratorProd = numerator * other.numerator
        val denominatorProd = denominator * other.denominator
        return simplifyFraction(Fraction(numeratorProd, denominatorProd))
    }

    operator fun div(other: Fraction): Fraction {
        val numeratorProd = (denominator * other.numerator).sign * (numerator * other.denominator)
        val denominatorProd = abs(denominator * other.numerator)
        return simplifyFraction(Fraction(numeratorProd, denominatorProd))
    }

    private fun simplifyFraction(fraction: Fraction): Fraction {
        val gcd = gcd(abs(fraction.numerator), abs(fraction.denominator))
        val sign = if (fraction.numerator < 0) -1 else 1
        val simplifiedNumerator = sign * (abs(fraction.numerator) / gcd)
        val simplifiedDenominator = abs(fraction.denominator) / gcd

        return Fraction(simplifiedNumerator, simplifiedDenominator)
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private fun lcm(a: Int, b: Int) = abs(a * b) / gcd(a, b)
}
