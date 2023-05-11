import kotlin.math.abs
import kotlin.math.sign

data class Fraction(val numerator: Int, val denominator: Int) {
    constructor(
        whole: Int, numerator: Int, denominator: Int
    ) : this(denominator.sign * (whole * abs(denominator) + numerator), abs(denominator))

    companion object {
        @JvmStatic
        fun fromString(fractionString: String): Fraction {
            val cleanedString = fractionString.trim()

            // Check if the fraction is negative
            val isNegative = cleanedString.startsWith("-")
            val fractionPart = if (isNegative) cleanedString.substring(1) else cleanedString

            // Check if the fraction is an improper fraction or a mixed number
            return if (fractionPart.contains("&")) {
                val wholeAndFraction = fractionPart.split("&")
                val whole = wholeAndFraction[0].toInt()
                val fraction = wholeAndFraction[1].toFraction()
                if (isNegative) Fraction(whole, fraction.numerator, -fraction.denominator)
                else Fraction(whole, fraction.numerator, fraction.denominator)
            } else {
                if (isNegative) fractionPart.toFraction().negate()
                else fractionPart.toFraction()
            }
        }

        @JvmStatic
        private fun String.toFraction(): Fraction {
            val splitFraction = this.split("/")
            val numerator = splitFraction[0].toInt()
            val denominator = if (splitFraction.size > 1) splitFraction[1].toInt() else 1
            return Fraction(numerator, denominator)
        }
    }

    override fun toString(): String {
        val whole = numerator / denominator
        val remainder = numerator % denominator

        return when {
            whole != 0 && remainder != 0 -> "$whole&${simplifyToString(abs(remainder), abs(denominator))}"
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

    private fun simplifyToString(numerator: Int, denominator: Int): String {
        val gcd = gcd(numerator, denominator)
        return "${numerator / gcd}/${denominator / gcd}"
    }

    private fun negate() = Fraction(-numerator, denominator)

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private fun lcm(a: Int, b: Int) = abs(a * b) / gcd(a, b)
}