package com.katas

import kotlin.text.all
import kotlin.text.filterNot
import kotlin.text.isDigit
import kotlin.text.isWhitespace
import kotlin.text.map


object Luhn {

    fun valid(number: String): Boolean {

        val cleanNumber = stripSpaces(number)

        if (cleanNumber.length <= 1) return false
        if (containsNonDigitChars(cleanNumber)) return false

        return cleanNumber.digits()
            .reversed()
            .mapIndexed(::doubleEverySecondDigit)
            .map(::limitDigitsGreaterThanNine)
            .sum()
            .isDivisibleBy(10)
    }

    private fun stripSpaces(number: String) = number.filterNot(Char::isWhitespace)
    private fun containsNonDigitChars(number: String) = !number.all(Char::isDigit)
    private fun doubleEverySecondDigit(index: Int, digit: Int) = if (index.isOdd()) digit * 2 else digit
    private fun limitDigitsGreaterThanNine(digit: Int) = if (digit > 9) digit - 9 else digit
}

private fun String.digits() = this.map(Character::getNumericValue)
private fun Int.isOdd() = this.rem(2) == 1
private fun Int.isDivisibleBy(num: Int) = this.rem(num) == 0

